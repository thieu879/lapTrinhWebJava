<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Trò Chơi Oẳn Tù Tì</title>
</head>
<body>
<h1>Trò Chơi Oẳn Tù Tì</h1>
<form action="game" method="post">
    <p>Lựa Chọn Của Bạn:</p>
    <input type="radio" name="userChoice" value="Búa" required>Búa
    <input type="radio" name="userChoice" value="Kéo">Kéo
    <input type="radio" name="userChoice" value="Lá">Lá
    <br><br>
    <input type="submit" value="Chơi">
</form>

<% if (request.getAttribute("result") != null) { %>
<h3>Kết Quả:</h3>
<p>Lựa Chọn Của Bạn: <%= request.getAttribute("userChoice") %></p>
<p>Lựa Chọn Của Máy Tính: <%= request.getAttribute("computerChoice") %></p>
<p><%= request.getAttribute("result") %></p>
<% } %>
</body>
</html>