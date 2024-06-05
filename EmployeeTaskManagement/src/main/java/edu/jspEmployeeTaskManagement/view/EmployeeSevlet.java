package edu.jspEmployeeTaskManagement.view;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.jsp.EmployeeTaskManagement.controller.Controller;
import edu.jsp.EmployeeTaskManagement.model.Employee;
import edu.jsp.EmployeeTaskManagement.model.EmployeeNotFoundException;
import edu.jsp.EmployeeTaskManagement.model.Task;
import edu.jsp.EmployeeTaskManagement.model.TaskNotFoundException;

@WebServlet("/employeeServlet")
public class EmployeeSevlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private Controller controller=new Controller();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            response.getWriter().write("No action specified.");
            return;
        }

        switch (action) {
            case "addEmployee":
                addEmployee(request, response);
                break;
            case "removeEmployee":
                removeEmployee(request, response);
                break;

            case "addTask":
                addTask(request, response);
                break;
            case "removeTask":
                removeTask(request, response);
                break;
            case "searchTask":
                searchTask(request, response);
                break;
            case "assignTask":
            	assignTask(request, response);
                break;
            case "updateEmployee":
            	updateEmployee(request, response);
                break;
            
            case"updateTask":
            	updateTask(request,response);
           
            default:
                response.getWriter().write("Invalid action.");
                break;
        }
    }

	private void addEmployee(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("empname");
        int age = Integer.parseInt(request.getParameter("empage"));
        int salary = Integer.parseInt(request.getParameter("empsalary"));

        Employee employee = new Employee();
        employee.setName(name);
        employee.setAge(age);
        employee.setDateOfJoining(LocalDate.now());
        employee.setSalary(salary);

        try {
            controller.addEmployee(employee);
            response.getWriter().write("<html><body><script> alert('Employee added Succesfully.');"
            		+ "window.location.href='index.html';</script></body></html>");
           // response.sendRedirect("success.html");
        } catch (EmployeeNotFoundException e) {
        	 response.getWriter().write("<html><body><script> alert('OPPSS....! There was some error while inserting Employee Details Try Again...');"
             		+ "window.location.href='addEmployee.html';</script></body></html>");
        }catch (Exception e) {
       	 response.getWriter().write("<html><body><script>alert('OPPSS....! There was some error occured Try Again...');"
       	 		+ "window.location.href='addEmployee.html';</script>></body></html>");
 		
       }
    }

    private void removeEmployee(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("empid"));

        try {
        	Employee e= controller.removeEmployee(id);
            response.getWriter().write("<html><body><script>alert('Employee  details removed from database Successfully');"
            		+ "window.location.href='index.html';</script></body></html>");
        } 
        catch (EmployeeNotFoundException e) {
    		// TODO: handle exception
    		
    		response.getWriter().write("<html><body><script>alert('OPPSS....!  There was some error while Deleting Employee Details.Please Ensure that you Entered correct Employee Id and Try Again...');"
    				+ "window.location.href='removeEmployee.html';</script>></body></html>");
    	}
        catch (Exception e) {
        	 response.getWriter().write("<html><body><script>alert('OPPSS....! There was some error .Try Again...');"
        	 		+ "window.location.href='removeEmployee.html';</script>></body></html>");
    		
        }
    }
    
//    private void searchEmployee(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        int id = Integer.parseInt(request.getParameter("empid"));
//
//        try {
//          Employee e= controller.searchEmployee(id);
//          response.getWriter().write("<html><body><script>alert('Employee Found');</script><h3>Employee Details</h3>"
//          		+ "<br>Employee Id : "+e.getId()+"<br>Employee Name : "+e.getName()+"<br>Employee Age : "+e.getAge()+
//          		"<br>Employee Salary : "+e.getSalary()+"<br>Employee Date of Joining : "+e.getDateOfJoining()+
//          		"<br><a href='index.html'>Go To Index</a></body></html>");
//        } catch (EmployeeNotFoundException e) {
//    		// TODO: handle exception
//    		
//    		response.getWriter().write("<html><body><script>alert('OPPSS....!  There was some error while Searching Employee Details.Please Ensure that you Entered correct Employee Id and Try Again...');"
//    				+ "window.location.href='searchEmployee.html';</script>></body></html>");
//    	} 
//        
//        catch (Exception e) {
//        	 response.getWriter().write("<html><body><script>alert('OPPSS....! There was some error . Try Again...');"
//        	 		+ "window.location.href='searchEmployee.html';</script>></body></html>");
//        }
//    }
//    

    private void addTask(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		// TODO Auto-generated method stub
		
    	String tname=request.getParameter("taskName");
    	
    	Task task =new Task();
    	task.setTaskName(tname);
    	task.setDateofcreation(LocalDate.now());
    	try{
    		 controller.addTask(task);
    		 response.getWriter().write("<html><body><script>alert('Task Added Sucessfully'); "
    		 		+ "window.location.href='index.html';</script>></body></html>");
    		
    	}
    	catch (TaskNotFoundException e) {
			// TODO: handle exception
    		 response.getWriter().write("<html><body><script>alert('OPPSS....! There was some error while Adding Task Try Again...'); "
    		 		+ "window.location.href='addTask.html';</script></body></html>");
    	} catch (Exception e) {
       	 response.getWriter().write("<html><body><script>alert('OPPSS....! There was some error . Try Again...');"
     	 		+ "window.location.href='addTask.html';</script>></body></html>");
     }
    	
	}
    

	private void removeTask(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		// TODO Auto-generated method stub
		 int id = Integer.parseInt(request.getParameter("taskid"));

	        try {
	        	controller.removeTask(id);
	            response.getWriter().write("<html><body><script>alert('Task details removed from database Successfully');"
	            		+ "window.location.href='index.html';</script></body></html>");
	        } catch (TaskNotFoundException e) {
	        	 response.getWriter().write("<html><body><script>alert('OPPSS....! There was some error while Deleting Task Details Try Again...');"
	        	 		+ "window.location.href='removeTask.html';</script></body></html>");
	    		
	        } catch (Exception e) {
	        	 response.getWriter().write("<html><body><script>alert('OPPSS....! There was some error . Try Again...');"
	         	 		+ "window.location.href='removeTask.html';</script>></body></html>");
	         }
	    }

	private void searchTask(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		// TODO Auto-generated method stub
		
		int id = Integer.parseInt(request.getParameter("taskid"));
		try {
		Task task= controller.searchTask(id);
         response.getWriter().write("<html><body><script>alert('Task Found');</script><h3>Task Details</h3>"
         		+ "<br>Task Id : "+task.getTaskId()+"<br>Task Name : "+task.getTaskName()+"<br>Date of Creation : "+task.getDateofcreation()+
         		"<br>Start date : "+task.getStartDate()+"<br> Date of completion : "+task.getEndDate()+
         		"<br><a href='index.html'>Go To Index</a></body></html>");
       } catch (TaskNotFoundException e) {
      	 response.getWriter().write("<html><body><script>alert('OPPSS....! There was some error while Searching Task Details . Try Again...');"
     	 		+ "window.location.href='searchTask.html';</script>></body></html>");
     } 
		
		catch (Exception e) {
       	 response.getWriter().write("<html><body><script>alert('OPPSS....! There was some error. Try Again...');"
       	 		+ "window.location.href='searchTask.html';</script>></body></html>");
       }
		
	}

//
//	private void getAllEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		// TODO Auto-generated method stub
//		try {
//		 List<Employee> e= controller.getAllEmployee();
//		 response.sendRedirect("getAllEmployee.html");
//		}
//		catch (Exception e) {
//		// TODO: handle exception
//			 response.getWriter().write("<html><body><script>alert('OPPSS....! There was some error while Fetching Employee Details Try Again...');"
//			 		+ "window.location.href='index.html';</script>></body></html>");
//		}
//	}
//	
	


	private void assignTask(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		int empId = Integer.parseInt(request.getParameter("empid"));
		int taskId = Integer.parseInt(request.getParameter("taskid"));
		String endDateParam = request.getParameter("endDate");
		LocalDate endDate = LocalDate.parse(endDateParam, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

		try {
		Task task =controller.searchTask(taskId);
		task.setStartDate(LocalDate.now());
		task.setEndDate(endDate);
		controller.updateTask(task);
		controller.assignTask(empId, taskId);
		response.getWriter().write("<html><body><script>alert('Task Assigned sucessfully ');"
				+ "window.location.href='index.html';</script>></body></html>");

		
	}catch (EmployeeNotFoundException e) {
		// TODO: handle exception
		
		response.getWriter().write("<html><body><script>alert('OPPSS....!  There was some error while Searching Employee Id.Please Ensure that you Entered correct Employee Id and Try Again...');"
				+ "window.location.href='assignTask.html';</script>></body></html>");
	}
	catch (TaskNotFoundException e) {
			// TODO: handle exception
		response.getWriter().write("<html><body><script>alert('OPPSS....!  There was some error while Searching Task Id.Please Ensure that you Entered correct Task Id and Try Again...');"
				+ "window.location.href='assignTask.html';</script>></body></html>");

		}


}
	
	private void updateTask(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		 int taskId = Integer.parseInt(request.getParameter("taskId"));
	     String taskName =request.getParameter("taskName");
	    
	     try {
	     Controller controller = new Controller();
	     Task task =controller.searchTask(taskId);
	     task.setTaskName(taskName);
	     controller.updateTask(task);
	     String  employeeIdParam = request.getParameter("employeeId");
	    	    if (employeeIdParam != null) {
	    	        int employeeId = Integer.parseInt(employeeIdParam);
	    	        response.getWriter().write("<html><body><script>alert('Task Updated successfully ');"
	    	                + "window.location.href='taskList.jsp?employeeId=" + employeeId + "';</script></body></html>");
	    	    } else {
	    	        response.getWriter().write("<html><body><script>alert('Task Updated successfully ');"
	    	                + "window.location.href='getAllTask.jsp';</script></body></html>");
	    	    }

		
	     }catch (TaskNotFoundException e) {
		// TODO: handle exception
	    	 response.getWriter().write("<html><body><script>alert('OPPSS....!  There was some error while Searching Task Id.Please Ensure that you Entered correct Task Id and Try Again...');"
			+ "window.location.href='assignTask.html';</script>></body></html>");

	     }

	}
	
	private void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	    int employeeId = Integer.parseInt(request.getParameter("employeeId"));
	    String newName = request.getParameter("employeeName");
	    int newAge = 0;
	    int newSal=0;
	   
	    if (request.getParameter("employeeAge") != null && !request.getParameter("employeeAge").isEmpty()) {
	        newAge = Integer.parseInt(request.getParameter("employeeAge"));
	    }
	    
	    if (request.getParameter("employeeSalary") != null && !request.getParameter("employeeSalary").isEmpty()) {
	        newSal = Integer.parseInt(request.getParameter("employeeSalary"));
	    }

	  
	  
	        try {
	            Controller controller = new Controller();
	            Employee employee = controller.searchEmployee(employeeId);
	           
	            if (newName != null && !newName.isEmpty()) {
	            employee.setName(newName);
	            }
	           
	            if (newAge != 0) {
	                employee.setAge(newAge);
	            }
	            if (newSal != 0) {
	                employee.setSalary(newSal);
	            }
	           
	            controller.updateEmployee(employee);

	            response.getWriter().write("<html><body><script>alert('Employee Updated successfully ');"
	                    + "window.location.href='getAllEmployee.jsp';</script></body></html>");
	            
	        } catch (EmployeeNotFoundException e) {
	        	
	            response.getWriter().write("<html><body><script>alert('OPPSS....!  There was some error while searching Employee Id. Please ensure that you entered correct Employee Id and try again...');"
	                    + "window.location.href='updateEmployee.jsp';</script></body></html>");
	            
	        }catch(Exception e) {
	        	
	    	response.getWriter().write("<html><body><script>alert('OPPSS....!  There was some error . Please  try again...');"
                    + "window.location.href='updateEmployee.jsp';</script></body></html>");
	    	
	        }
		}

	
}
