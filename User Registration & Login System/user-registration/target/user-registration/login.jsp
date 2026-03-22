<html>
<head><title>User Login</title></head>
<body>

<h2>Login</h2>

<form action="login" method="post">
    Email: <input type="email" name="email"><br>
    Password: <input type="password" name="password"><br>
    <input type="submit" value="Login">
</form>

<%
    if(request.getParameter("error") != null){
%>
    <p style="color:red;">Invalid Credentials</p>
<%
    }
%>

Don't have an account? <a href="register.jsp">Register here</a>

</body>
</html>