<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Remove Employee</title>
   <link rel="stylesheet" href="EmployeeTaskManagement.css">
   <style >
     table {
        width: 100%;
        border-collapse: collapse;
    }
    th, td {
        padding: 8px;
        text-align: left;
        border-bottom: 1px solid #ddd;
    }
    th {
        background-color: #f2f2f2;
        
    }
    a{
    text-decoration: none;
    }
   </style>
</head>
<body>
	<div class="navbar">
 		 <a href="index.html">Home</a>
	</div>
	<div class="container">
    <h1>Search Employee</h1>
    <form action="EmployeeFound.jsp" method="post">
        <input type="number" id="employeeId" name="empid" placeholder="Enter Employee Id" required><br><br>
        <button type="submit">Search Employee</button>
        
        </form>
       
            
        <%@ page import="edu.jsp.EmployeeTaskManagement.model.Employee" %>
        <%@ page import="edu.jsp.EmployeeTaskManagement.model.EmployeeNotFoundException" %>
        <%@ page import="edu.jsp.EmployeeTaskManagement.controller.Controller" %>
        
        
        <%
            Controller controller = new Controller(); 
       		int id = Integer.parseInt(request.getParameter("empid"));

       		 try {
         			 Employee employee= controller.searchEmployee(id);
         			 
        %>
         <h2>Employee</h2>
        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Age</th>
                <th>Date of Joining</th>
                <th>Salary</th>
                <th>Assigned Task</th>
            </tr>
        	
        	 <tr>
                <td><%= employee.getId() %></td>
                <td><%= employee.getName() %></td>
                <td><%= employee.getAge() %></td>
                <td><%= employee.getDateOfJoining() %></td>
                <td><%= employee.getSalary() %></td>
                <td><a href="taskList.jsp?employeeId=<%= employee.getId() %>"><button >Get Task List</button></a></td>
                
             </tr>
               <% }
       		catch (EmployeeNotFoundException e) {
        		// TODO: handle exception
        		
        		response.getWriter().write("<html><body><script>alert('OPPSS....!  There was some error while Searching Employee Details.Please Ensure that you Entered correct Employee Id and Try Again...');"
        				+ "window.location.href='searchEmployee.html';</script>></body></html>");
        	} 
            
            catch (Exception e) {
            	 response.getWriter().write("<html><body><script>alert('OPPSS....! There was some error . Try Again...');"
            	 		+ "window.location.href='searchEmployee.html';</script>></body></html>");
            }
       		 %>
             </table>
            
   
	</div>
</body>
</html>
