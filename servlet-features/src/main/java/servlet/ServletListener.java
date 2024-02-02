package servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener("HttpSessionListener")
public class ServletListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent sessionEvent) {

        String sessionId = sessionEvent.getSession().getId();


        ServletContext servletContext = sessionEvent.getSession().getServletContext();
        servletContext.setAttribute(sessionId, "New session created with ID: " + sessionId);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent sessionEvent) {
        String sessionId = sessionEvent.getSession().getId();


        ServletContext servletContext = sessionEvent.getSession().getServletContext();
        servletContext.removeAttribute(sessionId);

        System.out.println("Session with ID " + sessionId + " has been destroyed.");
    }
}
