<%@ page import="java.sql.*" %>
<%@ page import="com.example.student.DBConnection" %>

<h2>Student List</h2>

<a href="addStudent.jsp">Add New Student</a>

<br><br>

<table border="1">

<tr>
<th>ID</th>
<th>Name</th>
<th>Email</th>
<th>Course</th>
<th>Action</th>
</tr>

<%
Connection conn = DBConnection.getConnection();
Statement stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery("SELECT * FROM students");

while(rs.next()){
%>

<tr>
<td><%=rs.getInt("id")%></td>
<td><%=rs.getString("name")%></td>
<td><%=rs.getString("email")%></td>
<td><%=rs.getString("course")%></td>

<td>
    <a href="EditStudentServlet?id=<%= rs.getInt("id") %>">Edit</a>
    <a href="DeleteStudentServlet?id=<%= rs.getInt("id") %>"
   onclick="return confirm('Delete this student?')">
   Delete
</a>

</td>
</tr>

<%
}
%>

</table>