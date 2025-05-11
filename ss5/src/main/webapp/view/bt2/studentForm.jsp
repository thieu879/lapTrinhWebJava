<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Form Nhập Sinh Viên</title>
</head>
<body>
<h2>Nhập thông tin sinh viên</h2>
<form action="StudentController" method="post">
  Tên: <input type="text" name="name" required><br><br>
  Tuổi: <input type="number" name="age" required><br><br>
  Địa chỉ: <input type="text" name="address" required><br><br>
  <input type="submit" value="Gửi">
</form>
</body>
</html>
