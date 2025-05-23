package com.aditya;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet("/hello") // annotation way of mapping call to servlet (in external tomcat)
public class HelloServlet extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("In service");

        // sets the content type of the Servlet response
        response.setContentType("text/html");

        // writing response for the request using servlet PrintWriter class
        PrintWriter out = response.getWriter();
        out.println("<h2>Hello World</h2>");
    }
}
