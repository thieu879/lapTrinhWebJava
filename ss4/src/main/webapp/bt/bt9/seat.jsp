<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Đặt vé xem phim</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
        }
        .seat {
            display: inline-block;
            margin: 5px;
        }
        .seat input {
            display: none;
        }
        .seat label {
            display: inline-block;
            width: 40px;
            height: 40px;
            background-color: #eee;
            line-height: 40px;
            border: 1px solid #ccc;
            cursor: pointer;
        }
        .seat input:checked + label {
            background-color: black;
            color: white;
        }
        .seat label.disabled {
            background-color: #2196F3;
            pointer-events: none;
            color: white;
        }
    </style>
</head>
<body>
<h2>Danh sách ghế phòng chiếu số 8</h2>

<form method="post" action="seats">
    <c:forEach var="seat" items="${seats}">
        <div class="seat">
            <c:choose>
                <c:when test="${seat.status}">
                    <label class="disabled">${seat.name}</label>
                </c:when>
                <c:otherwise>
                    <input type="checkbox" name="selectedSeats" id="${seat.id}" value="${seat.id}"
                           <c:if test="${selected != null && fn:contains(selected, seat.id)}">checked</c:if> />
                    <label for="${seat.id}">${seat.name}</label>
                </c:otherwise>
            </c:choose>
        </div>
        <c:if test="${seat.name.endsWith('10')}"><br/></c:if>
    </c:forEach>
    <br/>
    <button type="submit">Thanh toán</button>
</form>

<c:if test="${param.selectedSeats != null}">
    <c:choose>
        <c:when test="${total > 0}">
            <p>Tổng số tiền phải thanh toán của bạn là : ${total}</p>
        </c:when>
        <c:otherwise>
            <p style="color:red;">Vui lòng chọn ít nhất một ghế để thanh toán.</p>
        </c:otherwise>
    </c:choose>
</c:if>

</body>
</html>
