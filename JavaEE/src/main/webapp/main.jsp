<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="models.entities.QuestionsEntity" %>
<%@ page import="java.util.List" %>

<style><%@include file="style.css"%></style>

<!DOCTYPE html>
<html>
<p><center>Welcome on my lab 1 - Questions platform </center></p>
<head>
        <body>
                 <div class="container" align="center" valign="middle">
                     <div class="question-input">
                         You can create a question
                     </div>
                     <div class="createQuestion">
                         <div class="container-input">
                                 <form action="./question" method="post">
                                         <input type="text" name="question", placeholder="Your Question", required="required">
                                         <button type="submit">Save</button>
                                 </form>
                         </div>
                     </div>
                     <div class="questions">
                         <% List<QuestionsEntity> questions = (List<QuestionsEntity>) request.getAttribute("table_questions");%>
                         <div class="table-question" >
                                 <tbody>
                                     <% for (QuestionsEntity question : questions) { %>
                                         <div class="containerQuestion">
                                                 <tr>
                                                    <div class="questionId">
                                                        ID question: <%= question.getId() %>
                                                     </div>
                                                    <div class="questionText">
                                                        Question is <%= question.getTxt() %>
                                                    </div>
                                                 </tr>
                                             <br>
                                                 <form action="./answer" method="post">
                                                         <label for="name">Fill the response from the user </label>
                                                         <input type="hidden" name="questionId" value= "<%=(question.getId())%>">
                                                         <input type="text" name="firstName", placeholder="firstName", required="required">
                                                         <input type="text" name="answer", placeholder="answer", required="required">
                                                         <button type="submit">Save</button>
                                                 </form>
                                             </br>
                                         </div>
                                     <% } %>
                             </table>
                         </div>
                     </div>
                     <% if (!questions.isEmpty()) { %>
                         <div class="container-delete">
                             <div class="question-input">
                                 select id question to delete
                                 <form action="./question" method="post">
                                         <input type="number" name="id", placeholder="Id", required="required">
                                         <button type="submit">Delete</button>
                                 </form>
                             </div>
                         </div>
                     <% } %>

                 </div>
     </body>
</head>

