<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Login</title>
</head>
<body>
<h1>Login</h1>
<c:if test="${not empty error}">
  <p style="color:red;"><c:out value="${error}"/></p>
</c:if>
<form action="<c:url value='/login'/>" method="post">
  <label>Username:</label>
  <input type="text" name="username" required/><br/>
  <label>Password:</label>
  <input type="password" name="password" required/><br/>
  <input type="submit" value="Login"/>
</form>
<p>Don't have an account? <a href="<c:url value='/register'/>">Register</a></p>
</body>
</html>