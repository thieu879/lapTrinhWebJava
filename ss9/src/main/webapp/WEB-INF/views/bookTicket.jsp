<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Book Ticket</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="container">
  <h2>Book Ticket</h2>
  <c:if test="${not empty error}">
    <div class="error">${error}</div>
  </c:if>
  <c:if test="${not empty message}">
    <div class="success">${message}</div>
  </c:if>
  <p><strong>Movie:</strong> ${schedule.movieTitle}</p>
  <p><strong>Time:</strong> ${schedule.showTime}</p>
  <p><strong>Screen Room:</strong> ${screenRoom.screenRoomName}</p>

  <form action="${pageContext.request.contextPath}/bookTicket" method="post">
    <input type="hidden" name="scheduleId" value="${schedule.id}">
    <h3>Select Seats</h3>
    <div class="seat-selection">
      <c:forEach var="seat" items="${seats}">
        <div class="seat">
          <input type="checkbox"
                 id="seat${seat.id}"
                 name="seatIds"
                 value="${seat.id}"
                 <c:if test="${seat.status == 'BOOKED'}">disabled</c:if>>
          <label for="seat${seat.id}"
                 class="${seat.status == 'BOOKED' ? 'booked' : 'available'}">
            Seat ${seat.id}
          </label>
        </div>
      </c:forEach>
    </div>
    <button type="submit">Book Tickets</button>
  </form>
</div>
</body>
</html>