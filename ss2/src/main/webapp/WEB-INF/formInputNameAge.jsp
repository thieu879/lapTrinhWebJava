<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Thông tin</title>
</head>
<body>
<form action="UserInfoServlet" method="post">
  <label>Họ và tên:</label><br>
  <input type="text" name="name" required><br><br>

  <label>Tuổi:</label><br>
  <input type="text" name="age" required><br><br>

  <input type="submit" value="Đăng ký">
</form>
</body>
</html>