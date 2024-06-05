<%@ page import="java.util.List" %>
<%@ page import="edu.jsp.EmployeeTaskManagement.model.Employee" %>
<%@ page import="edu.jsp.EmployeeTaskManagement.model.EmployeeNotFoundException" %>
<%@ page import="edu.jsp.EmployeeTaskManagement.controller.Controller" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Employee</title>
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
    <h1>Update Employee</h1>
    <form action="employeeServlet" method="post">
        <%
           
            int employeeId = 0;
                     
            String employeeIdParam = request.getParameter("employeeId");
            
            if(employeeIdParam!= null&& !employeeIdParam.isEmpty()){
            	 employeeId = Integer.parseInt(employeeIdParam);
            } 
     
            Controller controller = new Controller();
            try {
                Employee employee = controller.searchEmployee(employeeId);
        %>
      	 
        <input type="hidden" name="action" value="updateEmployee">
        <input type="hidden" name="employeeId" value="<%=employeeId %>">
        <input type="text" name="employeeName" value="<%=employee.getName() %>" >
        <input type="number" name="employeeAge" value="<%=employee.getAge() %>" >
        <input type="number" name="employeeSalary" value="<%=employee.getSalary() %>">
        <span style="display: flex;">
        <button type="submit">Update Employee</button>
        <button type="reset">Reset</button>
        </span>
        
       
         <%
            }
            
    	catch (EmployeeNotFoundException e) {
    		// TODO: handle exception
    		
    		response.getWriter().write("<html><body><script>alert('OPPSS....!  There was some error while Searching Employee Details.Please Ensure that you Entered correct Employee Id and Try Again...');"
    				+ "window.location.href='searchEmployee.html';</script></body></html>");
    	} 
        
        catch (Exception e) {
        	 response.getWriter().write("<html><body><script>alert('OPPSS....! There was some error . Try Again...');"
        	 		+ "window.location.href='searchEmployee.html';</script>></body></html>");
        }
        %>
    </form>
</div>
</body>
</html>
