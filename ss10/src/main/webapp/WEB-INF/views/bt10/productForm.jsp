<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
  <title>Product Form</title>
</head>
<body>
<h2>Product Form</h2>
<c:if test="${not empty error}">
  <div style="color:red">${error}</div>
</c:if>
<form:form method="post" modelAttribute="product" enctype="multipart/form-data"
           action="${product.id == 0 ? '/products/add' : '/products/edit'}">
  <form:hidden path="id"/>
  <p>
    Name: <form:input path="name" required="true"/>
  </p>
  <p>
    Price: <form:input path="price" type="number" step="0.01" required="true"/>
  </p>
  <p>
    Stock: <form:input path="stock" type="number" required="true"/>
  </p>
  <p>
    Image: <input type="file" name="imageFile"/>
  </p>
  <c:if test="${product.image != null}">
    <p><img src="${product.image}" width="100"/></p>
  </c:if>
  <p>
    <input type="submit" value="Save"/>
  </p>
</form:form>
</body>
</html>

