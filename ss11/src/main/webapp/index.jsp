<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<a href="/register">Bt1,2,3,4:</a>
<br>
<a href="/bt5/register">Bt5:</a>
<br>
<a href="/registers">Bt6:</a>
<br>
<a href="/review">Bt7:</a>
<br>
<a href="${pageContext.request.contextPath}/categories">Bt8,9:</a>
<br>
<a href="${pageContext.request.contextPath}/movies">Bt10:</a>
</body>
</html>