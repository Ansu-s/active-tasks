package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.DataInput;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(name = "hello" ,displayName = "Display", urlPatterns = "/test")
public class hello extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       PrintWriter out = response.getWriter();
       response.setHeader("test", "sucess");
       response.setHeader("DevIDE", "Intellij IDEA Ultimate");
       response.setDateHeader("DateInput" ,4535L );


       out.println("You have learnt servlet");
    }
}
