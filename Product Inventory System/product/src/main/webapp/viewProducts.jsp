<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<body>

<h2>Product List</h2>

<table border="1">
<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Price</th>
    <th>Quantity</th>
    <th>Category</th>
    <th>Actions</th>
</tr>
<c:forEach var="p" items="${products}">
<tr>
    <td>${p.id}</td>
    <td>${p.name}</td>
    <td>${p.price}</td>
    <td>${p.quantity}</td>
    <td>${p.category}</td>
    <td>
        <a href="editProduct?id=${p.id}">Edit</a>
        <a href="deleteProduct?id=${p.id}">Delete</a>
    </td>
</tr>
</c:forEach>
</table>

<a href="addProduct.jsp">Add New Product</a>

</body>
</html>