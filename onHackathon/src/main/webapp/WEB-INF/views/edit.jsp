<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h2>Edit Product</h2>
<form:form action="${pageContext.request.contextPath}/products/edit/${id}" modelAttribute="product" method="post" enctype="multipart/form-data">
    <div>
        <form:label path="productName">Product Name:</form:label>
        <form:input path="productName"/>
        <form:errors path="productName" cssClass="error"/>
    </div>
    <div>
        <form:label path="price">Price:</form:label>
        <form:input path="price"/>
        <form:errors path="price" cssClass="error"/>
    </div>
    <div>
        <form:label path="description">Description:</form:label>
        <form:textarea path="description"/>
        <form:errors path="description" cssClass="error"/>
    </div>
    <div>
        <form:label path="status">Status:</form:label>
        <form:input path="status"/>
        <form:errors path="status" cssClass="error"/>
    </div>
    <div>
        <input type="file" name="imageFile"/>
    </div>
    <div>
        <button type="submit">Save</button>
    </div>
</form:form>