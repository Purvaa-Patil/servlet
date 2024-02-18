package edu.jsp.sessionManagement;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet(name="pagea" , urlPatterns = {"/setv"})
public class PageA extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name="postgresql";
		String password ="root";
		
		HttpSession session= req.getSession();
		session.setAttribute("dbname", name);
		session.setAttribute("dbpass", password);
		
	}
}
