package com.example.demo.services.jms;

import com.example.demo.models.jms.Email;
import com.example.demo.models.jms.EventType;
import com.example.demo.models.jms.WatchDog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;

@Aspect
public class LoggingAspect {
    @Autowired
    private JmsSendEvent jmsSendEvent;

    @AfterReturning(pointcut = "execution(* com.example.demo.repositories.*.*(..))", returning = "retVal")
    public void trackDatabaseChanges(JoinPoint joinPoint, Object retVal) {
        String name = joinPoint.getSignature().toString();
        if (!name.contains("WatchDog") && !name.contains("Email")) {
            boolean b = name.contains("Question") || name.contains("User") || name.contains("Answer");
            if (name.contains(EventType.save.name()) && b) {
                jmsSendEvent.sendEvent("event", new WatchDog(retVal.toString(), EventType.save));
                jmsSendEvent.sendEvent("email", new Email("test@example.ru", retVal.toString()));
            } else if (name.contains(EventType.delete.name()) && b) {
                jmsSendEvent.sendEvent("event", new WatchDog(name.split("\\.")[4], EventType.delete));
                jmsSendEvent.sendEvent("email", new Email("test@example.ru", EventType.delete.name() + name.split("\\.")[4]));
            }
        }
    }
}
