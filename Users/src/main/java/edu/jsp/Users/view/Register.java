package edu.jsp.Users.view;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.jsp.Users.controller.Controller;
import edu.jsp.Users.entity.Udetail;

@WebServlet("/register")
public class Register extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get parameters from request
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Create a new User_Details object
        Udetail user = new Udetail();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);

        // Create a Controller instance
        Controller controller = new Controller();

        // Register the user
        Udetail registeredUser = controller.register(user);

        if (registeredUser != null) {
            // Registration successful
            response.sendRedirect("registration-success.html");
        } else {
            // Registration failed
            response.sendRedirect("registration-failure.html");
        }
    }
}

