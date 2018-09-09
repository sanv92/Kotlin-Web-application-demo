package com.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// @WebServlet(urlPatterns = {"/test/*"}, loadOnStartup = 1)
@WebServlet(name = "Test", urlPatterns = {"/page"})
public class Hello2Servlet extends HttpServlet {
    private String greeting = "Hello World!!!";

    public Hello2Servlet() {
    }

    public Hello2Servlet(String greeting) {
        this.greeting = greeting;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println("<h1>" + greeting + "</h1>");
        response.getWriter().println("session=" + request.getSession(true).getId());
    }
}
