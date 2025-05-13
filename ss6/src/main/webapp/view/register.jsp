<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Register</title>
</head>
<body>
<h1>Register</h1>
<c:if test="${not empty error}">
  <p style="color:red;"><c:out value="${error}"/></p>
</c:if>
<form action="<c:url value='/register'/>" method="post">
  <label>Username:</label>
  <input type="text" name="username" required/><br/>
  <label>Password:</label>
  <input type="password" name="password" required/><br/>
  <label>Email:</label>
  <input type="email" name="email"/><br/>
  <label>Phone:</label>
  <input type="text" name="phone"/><br/>
  <input type="submit" value="Register"/>
</form>
<p>Already have an account? <a href="<c:url value='/login'/>">Login</a></p>
</body>
</html>