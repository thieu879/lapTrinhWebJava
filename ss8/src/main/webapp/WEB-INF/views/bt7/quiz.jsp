<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Đoán hình ảnh</title>
</head>
<body>
<h2>Đoán hình ảnh</h2>

<img src="${question.imageUrl}" alt="Câu hỏi" width="200" /><br><br>

<c:if test="${canGuess}">
    <form method="post" action="${pageContext.request.contextPath}/guess">
        Nhập đáp án: <input type="text" name="userAnswer" required/>
        <button type="submit">Đoán</button>
    </form>
</c:if>

<p style="color: red;">${message}</p>

<c:if test="${not canGuess}">
    <form method="get" action="${pageContext.request.contextPath}/quiz">
        <button type="submit">Chơi lại</button>
    </form>
</c:if>
</body>
</html>

