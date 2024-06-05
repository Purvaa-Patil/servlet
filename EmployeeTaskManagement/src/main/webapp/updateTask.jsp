<%@ page import="java.util.List" %>
<%@ page import="edu.jsp.EmployeeTaskManagement.model.Employee" %>
<%@ page import="edu.jsp.EmployeeTaskManagement.model.Task" %>
<%@ page import="edu.jsp.EmployeeTaskManagement.model.TaskNotFoundException" %>
<%@ page import="edu.jsp.EmployeeTaskManagement.controller.Controller" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Task</title>
<link rel="stylesheet" href="EmployeeTaskManagement.css">
</head>
<body>
<div class="navbar">
 		 <a href="index.html">Home</a>
 		 <a href="#" onclick="goBack()">Back</a>
	</div>
	<script>
		function goBack() {
 		 window.history.back();
		}
	</script>
    <div class="container">
        <h1>Update Task</h1>
         <form action="employeeServlet" method="post">
          <%
            int taskId = 0;
            int employeeId = 0;
            String taskIdParam = request.getParameter("taskId");
            String employeeIdParam = request.getParameter("employeeId");
            
            if(taskIdParam != null && !taskIdParam.isEmpty()) {
                taskId = Integer.parseInt(taskIdParam);
            }
            
            if(employeeIdParam != null && !employeeIdParam.isEmpty()) {
                employeeId = Integer.parseInt(employeeIdParam);
            }
        %>
            <input type="hidden" name="action" value="updateTask">
            <% if(employeeId != 0) { %>
                <input type="hidden" name="employeeId" value="<%=employeeId %>">
            <% } %>
            <input type="text" name="taskId" value="<%=taskId %>" required>
            <input type="text" name="taskName" placeholder="Enter Task name" required>
           <span style="display: block;">
            <button type="submit">Update Task</button>
            <button type="reset">Reset</button>
            </span>
        </form>
       
    </div>
     
</body>
</html>
