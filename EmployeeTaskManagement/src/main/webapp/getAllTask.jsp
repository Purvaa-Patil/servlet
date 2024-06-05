<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of Employees</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f4f4f4;
    }
    .container {
        max-width: 800px;
        margin: 20px auto;
        padding: 20px;
        background-color: #fff;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
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
      button {
        display: block;
        width: 100%;
        padding: 10px;
        background-color: #4caf50;
        color: #fff;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }
    button:hover {
        background-color: #45a049;
    }
    a{
    text-decoration: none;
    }
   .navbar {
            overflow: hidden;
            background-color: #4caf50;
            text-align: right;
            font-size: 30px;
            
        }
    .navbar a{
		 color: white;
		 text-decoration: none;
		 padding-right: 20px;
	}
   

</style>
</head>
<body>
<div class="navbar">
 		 <a href="index.html">Home</a>
	</div>
    <div class="container">
        <h2>List of Task</h2>
        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Date of Creation </th>
                <th>Start Date </th>
                <th>End Date</th>
                <th></th>
              
            </tr>
           
            <%@ page import="java.util.List" %>
            <%@ page import="edu.jsp.EmployeeTaskManagement.model.Employee" %>
            <%@ page import="edu.jsp.EmployeeTaskManagement.model.Task" %>
            <%@ page import="edu.jsp.EmployeeTaskManagement.controller.Controller" %>
            <%
                Controller controller = new Controller();
                List<Task> taskList = controller.getAllTask();
                for ( Task task : taskList) {
            %>
            <tr>
                <td><%= task.getTaskId() %></td>
                <td><%= task.getTaskName() %></td>
                <td><%= task.getDateofcreation() %></td>
                <td><%= task.getStartDate() %></td>
                <td><%= task.getEndDate()%></td>
                 <td><a href="updateTask.jsp?taskId=<%= task.getTaskId() %>"><button>Update</button></a></td>
       
                
             </tr>
              <% } %>
             </table>
          
    </div>
    
   
</body>
</html>
