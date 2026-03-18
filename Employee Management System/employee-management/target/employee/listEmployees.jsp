<%@ page import="java.util.*,model.Employee" %>

<h2>Employee List</h2>

<table border="1">

<tr>
<th>ID</th>
<th>Name</th>
<th>Department</th>
<th>Salary</th>
<th>Action</th>

</tr>

<%
List<Employee> list = (List<Employee>)request.getAttribute("empList");

if(list != null && !list.isEmpty()){
for(Employee e : list){
%>

<tr>
<td><%=e.getEmp_id()%></td>
<td><%=e.getEmp_name()%></td>
<td><%=e.getDepartment()%></td>
<td><%=e.getSalary()%></td>

</tr>

<%
}
}else{
%>

<tr>
<td colspan="5">No Employees Found</td>
</tr>

<%
}
%>

</table>