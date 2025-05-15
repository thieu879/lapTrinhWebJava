<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Welcome to Movie Ticketing</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="container">
    <h2>Welcome to Movie Ticketing System</h2>
    <p>Please log in to browse movies and book tickets.</p>
    <a href="${pageContext.request.contextPath}/login">
        <button>Go to Login</button>
    </a>
</div>
</body>
</html>