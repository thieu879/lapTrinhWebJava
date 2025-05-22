<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>User Info</title></head>
<body>
<h2>Thông tin người dùng</h2>
<p>Name: ${user.name}</p>
<p>Email: ${user.email}</p>
<p>Phone: ${user.phone}</p>
<p>Status: <c:if test="not empty user.status">
    <c:choose>
        <c:when test="${user.status == 'true'}">Active</c:when>
        <c:otherwise>Inactive</c:otherwise>
    </c:choose>

</c:if></p>
</body>
</html>

