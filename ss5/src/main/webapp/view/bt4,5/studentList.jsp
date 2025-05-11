<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*, com.example.ss5.model.Students" %>
<!DOCTYPE html>
<html>
<head>
    <title>Danh sách sinh viên</title>
    <script>
        function confirmDelete(id) {
            if (confirm("Bạn có chắc chắn muốn xóa sinh viên này?")) {
                window.location.href = 'delete-student?id=' + id;
            }
        }
    </script>
</head>
<body>
<h2>Danh sách sinh viên</h2>
<table border="1" cellpadding="5">
    <tr>
        <th>ID</th><th>Tên</th><th>Tuổi</th><th>Địa chỉ</th><th>Hành động</th>
    </tr>
    <%
        List<Students> list = (List<Students>) request.getAttribute("currentPageList");
        for (Students s : list) {
    %>
    <tr>
        <td><%= s.getId() %></td>
        <td><%= s.getName() %></td>
        <td><%= s.getAge() %></td>
        <td><%= s.getAddress() %></td>
        <td>
            <form action="edit-student" method="get" style="display:inline;">
                <input type="hidden" name="id" value="<%= s.getId() %>">
                <input type="submit" value="Sửa">
            </form>
            <button onclick="confirmDelete(<%= s.getId() %>)">Xóa</button>
        </td>
    </tr>
    <% } %>
</table>

<%
    int currentPage = (int) request.getAttribute("currentPage");
    int totalPages = (int) request.getAttribute("totalPages");
%>
<div>
    <p>Trang <%= currentPage %> / <%= totalPages %></p>
    <% if (currentPage > 1) { %>
    <a href="students?page=<%= currentPage - 1 %>">Trước</a>
    <% } %>
    <% if (currentPage < totalPages) { %>
    <a href="students?page=<%= currentPage + 1 %>">Tiếp</a>
    <% } %>
</div>

<p>Xin chào, <%= session.getAttribute("user") %>!</p>
<a href="/logout">Đăng xuất</a>
</body>
</html>
