<%@ page import="java.sql.*" %>
<%@ page import="com.example.student.DBConnection" %>

<%
String idParam = request.getParameter("id");

if(idParam == null || idParam.isEmpty()){
    out.println("Error: ID is missing in URL");
} else {

    int id = Integer.parseInt(idParam);

    Connection conn = DBConnection.getConnection();
    PreparedStatement ps = conn.prepareStatement("SELECT * FROM students WHERE id=?");
    ps.setInt(1, id);

    ResultSet rs = ps.executeQuery();

    if(rs.next()){
%>

<h2>Edit Student</h2>

<form action="UpdateStudentServlet" method="post">

<input type="hidden" name="id" value="<%=rs.getInt("id")%>">

Name: <input type="text" name="name" value="<%=rs.getString("name")%>"><br><br>

Email: <input type="text" name="email" value="<%=rs.getString("email")%>"><br><br>

Course: <input type="text" name="course" value="<%=rs.getString("course")%>"><br><br>

<input type="submit" value="Update">

</form>

<%
    } else {
        out.println("Student not found!");
    }

} // <-- THIS closing brace was missing or misplaced
%>