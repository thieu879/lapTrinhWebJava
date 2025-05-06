<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lỗi xảy ra</title>
</head>
<body>
<h2>Xin lỗi, đã có lỗi xảy ra!</h2>
<p>
    <%= request.getAttribute("errorMessage") != null ? request.getAttribute("errorMessage") : "Lỗi không xác định." %>
</p>
<a href="index.jsp">Quay lại trang chính</a>
</body>
</html>

