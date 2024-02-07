package servlets;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.entities.QuestionsEntity;
import repositories.QuestionRepository;

import java.io.IOException;

@WebServlet("/question")
public class QuestionServlet extends HttpServlet {
    @Inject
    private QuestionRepository questionRepository;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String question = request.getParameter("question");
        String id = request.getParameter("id");

        if (id != null) {
            int id_index = Integer.parseInt(id);
            try {
                questionRepository.delete(id_index);
            } catch (Exception ignored) {

            }
            request.getRequestDispatcher("/").forward(request, response);
        }

        questionRepository.instance(new QuestionsEntity((int) (questionRepository.getCount() + 1), question));
        request.getRequestDispatcher("/").forward(request, response);
    }
}
