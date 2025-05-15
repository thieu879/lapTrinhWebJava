<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Movie Details</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="container">
    <h2>${movie.title}</h2>
    <p><strong>Director:</strong> ${movie.director}</p>
    <p><strong>Genre:</strong> ${movie.genre}</p>
    <p><strong>Description:</strong> ${movie.description}</p>
    <p><strong>Duration:</strong> ${movie.duration} minutes</p>
    <p><strong>Language:</strong> ${movie.language}</p>

    <h3>Show Schedules</h3>
    <c:forEach var="schedule" items="${schedules}">
        <div class="schedule-item">
            <p><strong>Time:</strong> ${schedule.showTime}</p>
            <p><strong>Screen Room:</strong> ${schedule.screenRoomName}</p>
            <p><strong>Format:</strong> ${schedule.format}</p>
            <p><strong>Available Seats:</strong> ${schedule.availableSeats}</p>
            <a href="${pageContext.request.contextPath}/bookTicket?scheduleId=${schedule.id}">Book Now</a>
        </div>
    </c:forEach>
</div>
</body>
</html>