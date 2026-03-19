<%@ page import="java.sql.*" %>
<%@ page import="com.example.student.DBConnection" %>

<h2>Student List</h2>

<a href="addStudent.jsp">Add New Student</a><br><br>

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
PreparedStatement ps = conn.prepareStatement("SELECT * FROM students");
ResultSet rs = ps.executeQuery();

while(rs.next()){
%>

<tr>
<td><%=rs.getInt("id")%></td>
<td><%=rs.getString("name")%></td>
<td><%=rs.getString("email")%></td>
<td><%=rs.getString("course")%></td>

<td>
    <a href="editStudent.jsp?id=<%=rs.getInt("id")%>">Edit</a> |
    <a href="DeleteStudentServlet?id=<%=rs.getInt("id")%>">Delete</a>
</td>
</tr>

<%
}
%>

</table>