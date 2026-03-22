<%@ page import="model.Employee" %>

<%
Employee e = (Employee) request.getAttribute("emp");
if(e == null){
%>
<h3>Employee not found</h3>
<%
return;
}
%>

<h2>Edit Employee</h2>

<form action="updateEmployee" method="post">
<input type="hidden" name="id" value="<%=e.getEmpId()%>">

Name: <input type="text" name="name" value="<%=e.getEmpName()%>"><br>
Department: <input type="text" name="department" value="<%=e.getDepartment()%>"><br>
Salary: <input type="text" name="salary" value="<%=e.getSalary()%>"><br>

<input type="submit" value="Update">
</form>