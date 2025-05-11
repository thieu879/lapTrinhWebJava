<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*, com.example.ss5.model.Post" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Danh sách bài viết</title></head>
<body>
<h2>Danh sách bài viết</h2>
<ul>
    <c:forEach var="post" items="${posts}">
        <li>
            <strong>${post.title}</strong> - ${post.author} (${post.publishDate})
            <a href="blog?action=post&id=${post.id}">[Xem chi tiết]</a>
        </li>
    </c:forEach>
</ul>
</body>
</html>
