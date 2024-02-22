package edu.jsp.Users.view;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.jsp.Users.controller.Controller;
import edu.jsp.Users.entity.Udetail;

@WebServlet("/login")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get parameters from request
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Create a Controller instance
        Controller controller = new Controller();

        // Attempt to log in the user
        Udetail loggedInUser = controller.login(email, password);

        if (loggedInUser != null) {
            // Login successful
            // You can set user session here if needed
            response.sendRedirect("login-success.html");
        } else {
            // Login failed
            response.sendRedirect("login-failure.html");
        }
    }
}

