<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.example.ss5.model.Students" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sửa thông tin sinh viên</title>
</head>
<body>
<h2>Sửa thông tin sinh viên</h2>
<%
    Students s = (Students) request.getAttribute("student");
%>
<form action="edit-student" method="post">
    <input type="hidden" name="id" value="<%= s.getId() %>">
    Tên: <input type="text" name="name" value="<%= s.getName() %>"><br><br>
    Tuổi: <input type="number" name="age" value="<%= s.getAge() %>"><br><br>
    Địa chỉ: <input type="text" name="address" value="<%= s.getAddress() %>"><br><br>
    <input type="submit" value="Cập nhật">
</form>
</body>
</html>
