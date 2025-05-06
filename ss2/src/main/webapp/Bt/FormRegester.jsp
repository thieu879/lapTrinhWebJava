<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>RegisterServlet</title>
</head>
<body>
<form action="UserRegistrationServlet" method="post">
  <label>Họ và tên:</label><br>
  <input type="text" name="name" required><br><br>

  <label>Email:</label><br>
  <input type="text" name="email" required><br><br>

  <label>password:</label><br>
  <input type="password" name="password" required><br><br>

  <input type="submit" value="Đăng ký">
</form>
</body>
</html>
