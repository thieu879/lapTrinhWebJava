<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.ss1.Bt7.Student" %>
<%@ page import="java.util.List" %>
<html>
<head>
  <title>Danh sách sinh viên đăng ký vé xe</title>
</head>
<body>
<h2>Danh sách sinh viên đăng ký vé xe</h2>
<table border="1">
  <tr>
    <th>Họ và tên</th>
    <th>Lớp</th>
    <th>Loại xe</th>
    <th>Biển số xe</th>
  </tr>
  <%
    List<Student> studentList = (List<Student>) request.getAttribute("studentList");
    if (studentList != null) {
      for (Student student : studentList) {
  %>
  <tr>
    <td><%= student.getFullName() %></td>
    <td><%= student.getStudentClass() %></td>
    <td><%= student.getVehicleType() %></td>
    <td><%= student.getLicensePlate() %></td>
  </tr>
  <%
      }
    }
  %>
</table>
</body>
</html>