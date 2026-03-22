<%
    String user = (String) session.getAttribute("user");

    if (user == null) {
        response.sendRedirect(request.getContextPath() + "/login.jsp");
        return;
    }
%>

<h2>Welcome <%= user %>!</h2>

<a href="<%= request.getContextPath() %>/logout">Logout</a>