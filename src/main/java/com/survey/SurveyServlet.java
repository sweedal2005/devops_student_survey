package com.survey;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class SurveyServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String dept = request.getParameter("dept");
        String rating = request.getParameter("rating");
        String feedback = request.getParameter("feedback");

        String data = name + " | " + dept + " | " + rating + " | " + feedback;

        App.submitResponse(data);

        response.getWriter().println("Survey submitted successfully!");
    }
}