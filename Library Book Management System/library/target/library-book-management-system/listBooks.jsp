<%@ page import="java.util.*,com.example.library.Book" %>

    <form action="listBooks" method="get">
        <input type="text" name="search">
        <input type="submit" value="Search">
    </form>

    <table border="1">
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Author</th>
            <th>Category</th>
            <th>Qty</th>
            <th>Action</th>
        </tr>

        <% List<Book> list = (List<Book>) request.getAttribute("books");
                for(Book b : list){
                %>
                <tr>
                    <td>
                        <%=b.getBook_id()%>
                    </td>
                    <td>
                        <%=b.getTitle()%>
                    </td>
                    <td>
                        <%=b.getAuthor()%>
                    </td>
                    <td>
                        <%=b.getCategory()%>
                    </td>
                    <td>
                        <%=b.getQuantity()%>
                    </td>
                    <td>
                        <a href="editBook?id=<%=b.getBook_id()%>">Edit</a> |
                        <a href="deleteBook?id=<%=b.getBook_id()%>">Delete</a>
                    </td>
                </tr>
                <% } %>
    </table>