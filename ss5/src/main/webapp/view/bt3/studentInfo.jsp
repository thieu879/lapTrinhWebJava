<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.example.ss5.model.Student" %>
<!DOCTYPE html>
<html>
<head>
  <title>Thông Tin Sinh Viên</title>
</head>
<body>
<h2>Thông Tin Sinh Viên Đã Nhập</h2>
<%
  Student student = (Student) request.getAttribute("student");
  if (student != null) {
%>
<p><strong>Tên:</strong> <%= student.getName() %></p>
<p><strong>Tuổi:</strong> <%= student.getAge() %></p>
<p><strong>Địa chỉ:</strong> <%= student.getAddress() %></p>
<%
  }
%>
</body>
</html>
