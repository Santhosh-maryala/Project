<%@ page import="java.util.*, model.Employee" %>

<h2>Employee List</h2>

<a href="addEmployee.jsp">Add Employee</a>

<table border="1">
<tr>
<th>ID</th><th>Name</th><th>Dept</th><th>Salary</th><th>Actions</th>
</tr>

<%
List<Employee> list = (List<Employee>) request.getAttribute("list");

if(list != null){
    for(Employee e : list){
%>

<tr>
<td><%=e.getEmpId()%></td>
<td><%=e.getEmpName()%></td>
<td><%=e.getDepartment()%></td>
<td><%=e.getSalary()%></td>
<td>
<a href="editEmployee?id=<%=e.getEmpId()%>">Edit</a>
<a href="deleteEmployee?id=<%=e.getEmpId()%>">Delete</a>
</td>
</tr>

<% 
    }
} else {
%>
<tr><td colspan="5">No data found</td></tr>
<% } %>

</table>