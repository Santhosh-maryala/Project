<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Employee</title>
</head>
<body>
    <h2>Add Employee</h2>
    <form action="AddEmployeeServlet" method="post">
    Name: <input type="text" name="name"><br><br>
    Department: <input type="text" name="department"><br><br>
    Salary: <input type="text" name="salary"><br><br>
    <input type="submit" value="Add Employee">
    </form>
    <a href="listEmployees.jsp">View Employee</a>
    
</body>
</html>