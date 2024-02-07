package com.example.demo.services.jms;

import com.example.demo.models.jms.Email;
import com.example.demo.models.jms.WatchDog;
import com.example.demo.repositories.EmailRepository;
import com.example.demo.repositories.WatchDogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class JmsReceiveEvent {
    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private WatchDogRepository watchDogRepository;


    @JmsListener(destination = "mail")
    public void receiveEmail(Email email) {
        emailRepository.save(email);
        System.err.println("Received <" + email + ">");
    }

    @JmsListener(destination = "event")
    public void receiveWatcherEvent(WatchDog event) {
        watchDogRepository.save(event);
        System.err.println("Received <" + event + ">");
    }
}
