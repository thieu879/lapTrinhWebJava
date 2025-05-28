<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Form</title>
</head>
<body>
<h1>User Form</h1>
<form:form action="logIn" modelAttribute="user" method="post">
    <form:input path="username" placeholder="Enter your username" />
    <form:password path="password" placeholder="Enter your password" />
    <input type="submit" value="Submit" />
</form:form>
</body>
</html>
