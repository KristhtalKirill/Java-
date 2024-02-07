package servlets;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.entities.AnswersEntity;
import models.entities.QuestionsEntity;
import repositories.AnswerRepository;
import repositories.UserRepository;

import java.io.IOException;
import java.util.List;

@WebServlet("/answer")
public class AnswerServlet extends HttpServlet {
    @Inject
    private UserRepository userRepository;

    @Inject
    private AnswerRepository answerRepository;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String id_question = request.getParameter("questionId");
        String answer = request.getParameter("answer");

        answerRepository.instance(new AnswersEntity(
                (int) (answerRepository.getCount() + 1),
                userRepository.getIdByName(firstName),
                Integer.parseInt(id_question),
                answer
        ));

        request.getRequestDispatcher("/").forward(request, response);
    }

}
