package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "servltClass", urlPatterns = "/servlet")
public class ServletClass extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");


        HttpSession session = request.getSession(true);

        String sessionServletInfo = (String) getServletContext().getAttribute(session.getId());

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Hello Servlet!</h2>");
        out.println("<p>Session Info: " + sessionServletInfo + "</p>");
        out.println("</body></html>");
    }
}

