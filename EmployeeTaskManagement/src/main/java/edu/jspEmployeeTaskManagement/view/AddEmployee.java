package edu.jspEmployeeTaskManagement.view;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.jsp.EmployeeTaskManagement.controller.Controller;
import edu.jsp.EmployeeTaskManagement.model.Employee;

@WebServlet( "/addEmployee")
public class AddEmployee extends HttpServlet{

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name =req.getParameter("empname");
		int age =Integer.parseInt(req.getParameter("empage"));
		int salary =Integer.parseInt(req.getParameter("empsalary"));
		
		Employee employee = new Employee();
		employee.setName(name);
		employee.setAge(age);
		employee.setDateOfJoining(LocalDate.now());
		employee.setSalary(salary);
		
		Controller controller = new Controller();
		
		if(controller.addEmployee(employee)!=null) {
			
			System.out.println("Employee added sucessfully ");
			//resp.getWriter().write("<html><body><script>alert('Employee Added Successfully');</script></body></html>");
			 resp.sendRedirect("success.html");
		}
		else {
			System.out.println("Employee not added ");
			//resp.getWriter().write("<html><body><script>alert('There was Some problem occured please Try again');</script></body></html>");
		}
	}
	
	
}
