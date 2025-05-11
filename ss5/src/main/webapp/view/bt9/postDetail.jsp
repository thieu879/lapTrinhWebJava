<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.example.ss5.model.Post" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Chi tiết bài viết</title></head>
<body>
<h2>${post.title}</h2>
<p><em>Tác giả:</em> ${post.author}</p>
<p><em>Ngày đăng:</em> ${post.publishDate}</p>
<hr>
<p>${post.content}</p>
<hr>
<a href="blog">Quay lại danh sách</a>
</body>
</html>
