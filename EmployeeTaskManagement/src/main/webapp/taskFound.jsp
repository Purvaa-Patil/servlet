<!DOCTYPE html>
<%@page import="edu.jsp.EmployeeTaskManagement.model.Task"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Search task</title>
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
    <h1>Search Task</h1>
    <form action="taskFound.jsp" method="post">
        <input type="number" id="taskId" name="taskId" placeholder="Enter Task Id" required><br><br>
        <button type="submit">Search Task</button>
        
        </form>
       
            
        <%@ page import="edu.jsp.EmployeeTaskManagement.model.Task" %>
        <%@ page import="edu.jsp.EmployeeTaskManagement.model.TaskNotFoundException" %>
        <%@ page import="edu.jsp.EmployeeTaskManagement.controller.Controller" %>
        
        
        <%
        int id = Integer.parseInt(request.getParameter("taskId"));
		try {
		Controller controller= new Controller();
		Task task= controller.searchTask(id);
         			 
        %>
         <h2>Task</h2>
        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Date of creation</th>
                <th>Star Date</th>
                <th>End Date</th>
                <th>Update</th>
            </tr>
        	
        	 <tr>
                <td><%= task.getTaskId() %></td>
                <td><%= task.getTaskName() %></td>
                <td><%= task.getDateofcreation() %></td>
                <td><%= task.getStartDate() %></td>
                <td><%= task.getEndDate() %></td>
                <td><a href="updateTask.jsp?taskId=<%= task.getTaskId() %>"><button>Update</button></a></td>
               
                
             </tr>
               <% }
       		catch (TaskNotFoundException e) {
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
