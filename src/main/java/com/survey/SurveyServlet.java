package com.survey;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
public class SurveyServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String branch = request.getParameter("branch");
        String feedback = request.getParameter("feedback");

        // Gmail sender details
        final String senderEmail = "sweetsheet07@gmail.com";
        final String appPassword = "evgm gflf payf olfq";

        // SMTP configuration
        Properties props = new Properties();

        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.enable", "true");

        Session session = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(senderEmail, appPassword);
                    }
                });

        try {

            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(senderEmail));

            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("sweetsheet07@gmail.com")
            );

            message.setSubject("New Student Survey Submission");

            String emailContent =
                    "New Survey Submission\n\n" +
                    "Name: " + name + "\n" +
                    "Branch: " + branch + "\n" +
                    "Feedback: " + feedback;

            message.setText(emailContent);

            Transport.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        }

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<h2>Survey Submitted Successfully!</h2>");
    }
}