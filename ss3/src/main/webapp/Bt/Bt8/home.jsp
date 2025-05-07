<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, com.example.ss3.bt8.Book" %>
<%
    List<Book> books = (List<Book>) request.getAttribute("filteredBooks");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quản Lý Thư Viện</title>
</head>
<body>
<h1>Quản Lý Thư Viện</h1>

<form method="post" action="BookServlet">
    <input type="text" name="title" placeholder="Tên sách" required>
    <input type="text" name="author" placeholder="Tác giả" required>
    <input type="number" name="year" placeholder="Năm xuất bản" required>
    <button type="submit">Thêm sách</button>
</form>

<form method="get" action="BookServlet">
    <input type="text" name="search" placeholder="Tìm kiếm theo tên">
    <button type="submit">Tìm</button>
</form>

<h2>Danh Sách Sách</h2>
<table border="1" cellpadding="5">
    <tr>
        <th>Tên sách</th>
        <th>Tác giả</th>
        <th>Năm xuất bản</th>
    </tr>
    <%
        if (books != null && !books.isEmpty()) {
            for (Book book : books) {
    %>
    <tr>
        <td><%= book.getTitle() %></td>
        <td><%= book.getAuthor() %></td>
        <td><%= book.getYear() %></td>
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="3">Không có sách nào.</td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
