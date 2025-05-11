<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Form Nhập Sinh Viên</title>
</head>
<body>
<h2>Nhập Thông Tin Sinh Viên</h2>

<form action="student" method="post">
  Tên: <input type="text" name="name" value="${param.name}"><br>
  <span style="color:red">${requestScope.nameError}</span><br><br>

  Tuổi: <input type="text" name="age" value="${param.age}"><br>
  <span style="color:red">${requestScope.ageError}</span><br><br>

  Địa chỉ: <input type="text" name="address" value="${param.address}"><br>
  <span style="color:red">${requestScope.addressError}</span><br><br>

  <input type="submit" value="Gửi">
</form>
</body>
</html>
