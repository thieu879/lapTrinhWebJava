<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Game Đoán Từ</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            margin-top: 50px;
        }
        .container {
            display: inline-block;
            text-align: left;
        }
        .word-hint {
            font-size: 24px;
            letter-spacing: 5px;
            margin: 20px 0;
        }
        .status {
            color: red;
            font-weight: bold;
            margin: 10px 0;
        }
        .input-box {
            margin: 10px 0;
        }
        .guess-btn, .play-again-btn {
            padding: 5px 15px;
            margin: 5px;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Game Đoán Từ</h1>
    <p>Từ bạn đang phải đoán như sau: <span class="word-hint"><%= (String) request.getAttribute("wordHint") %></span></p>
    <p>Bạn còn: <%= request.getAttribute("attemptsLeft") %> lượt đoán</p>
    <% if (request.getAttribute("gameStatus") != null && !((String) request.getAttribute("gameStatus")).equals("")) { %>
    <p class="status"><%= request.getAttribute("gameStatus") %></p>
    <% } %>
    <% if (request.getAttribute("gameOver") == null || !(Boolean) request.getAttribute("gameOver")) { %>
    <form action="WordGameServlet" method="post">
        <input type="hidden" name="secretWord" value="<%= request.getAttribute("secretWord") %>">
        <input type="hidden" name="attemptsLeft" value="<%= request.getAttribute("attemptsLeft") %>">
        <input type="hidden" name="gameStatus" value="<%= request.getAttribute("gameStatus") %>">
        <input type="hidden" name="gameOver" value="<%= request.getAttribute("gameOver") %>">
        <input type="hidden" name="wordIndexCounter" value="<%= request.getAttribute("wordIndexCounter") %>">
        <div class="input-box">
            <label>Nhập từ bạn đoán:</label>
            <input type="text" name="guess" required>
        </div>
        <input type="submit" value="Đoán" class="guess-btn">
    </form>
    <% } else { %>
    <form action="WordGameServlet" method="post">
        <input type="hidden" name="action" value="playAgain">
        <input type="hidden" name="secretWord" value="<%= request.getAttribute("secretWord") %>">
        <input type="hidden" name="attemptsLeft" value="<%= request.getAttribute("attemptsLeft") %>">
        <input type="hidden" name="gameStatus" value="<%= request.getAttribute("gameStatus") %>">
        <input type="hidden" name="gameOver" value="<%= request.getAttribute("gameOver") %>">
        <input type="hidden" name="wordIndexCounter" value="<%= request.getAttribute("wordIndexCounter") %>">
        <input type="submit" value="Chơi Lại" class="play-again-btn">
    </form>
    <% } %>
</div>
</body>
</html>