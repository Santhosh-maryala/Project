<%@ page import="com.example.library.Book" %>

<%
    Book b = (Book) request.getAttribute("book");
%>

<h2>Edit Book</h2>

<form action="updateBook" method="post">
    
    <input type="hidden" name="id" value="<%=b.getBook_id()%>">

    Title: <input type="text" name="title" value="<%=b.getTitle()%>"><br><br>

    Author: <input type="text" name="author" value="<%=b.getAuthor()%>"><br><br>

    Category: <input type="text" name="category" value="<%=b.getCategory()%>"><br><br>

    Quantity: <input type="number" name="quantity" value="<%=b.getQuantity()%>"><br><br>

    <input type="submit" value="Update Book">
</form>