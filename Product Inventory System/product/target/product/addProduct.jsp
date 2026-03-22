<%@ page isELIgnored="false" %>
<html>
<head><title>Add Product</title></head>
<body>
<h2>Add Product</h2>

<form action="addProduct" method="post">
    Name: <input type="text" name="product_name"><br>
    Price: <input type="number" name="price"><br>
    Quantity: <input type="number" name="quantity"><br>
    Category: <input type="text" name="category"><br>
    <input type="submit" value="Add Product">
</form>

<a href="viewProducts">View Products</a>
</body>
</html>