<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Register User</title>
    <style>
        .error {
            color: #d93025;
            font-weight: bold;
            font-size: 0.85em;
            margin-top: 3px;
            display: block;
        }
    </style>

</head>
<body>
<form:form modelAttribute="user" action="register" method="post">
    <div>
        <form:label path="name">Name:</form:label>
        <form:input path="name"/>
        <form:errors path="name" cssClass="error"/>
    </div>
    <div>
        <form:label path="email">Email:</form:label>
        <form:input path="email"/>
        <form:errors path="email" cssClass="error"/>
    </div>
    <div>
        <form:label path="phone">Phone:</form:label>
        <form:input path="phone"/>
        <form:errors path="phone" cssClass="error"/>
    </div>
    <div>
        <form:label path="password">Password:</form:label>
        <form:password path="password"/>
        <form:errors path="password" cssClass="error"/>
    </div>
    <div>
        <form:label path="status">Status:</form:label>
        <form:checkbox path="status"/>
        <form:errors path="status" cssClass="error"/>
    </div>
    <div>
        <input type="submit" value="Submit"/>
    </div>
</form:form>
</body>
</html>

