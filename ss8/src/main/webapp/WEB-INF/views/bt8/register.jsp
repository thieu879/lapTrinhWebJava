<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Register</title>
</head>
<body>
<h1>Register</h1>
<form action="${pageContext.request.contextPath}/GameController/register" method="post">
  <input type="text" name="username" placeholder="Username" required><br>
  <input type="password" name="password" placeholder="Password" required><br>
  <input type="email" name="email" placeholder="Email" required><br>
  <button type="submit">Register</button>
</form>
<a href="${pageContext.request.contextPath}/GameController/login">Login</a>
</body>
</html>