<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Home - Movie Ticketing</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="container">
  <h2>Now Showing</h2>
  <div class="movie-list">
    <c:forEach var="movie" items="${movies}">
      <div class="movie-item">
        <h3>${movie.title}</h3>
        <p>Director: ${movie.director}</p>
        <p>Genre: ${movie.genre}</p>
        <a href="${pageContext.request.contextPath}/detailMovie?id=${movie.id}">View Details</a>
      </div>
    </c:forEach>
  </div>
</div>
</body>
</html>