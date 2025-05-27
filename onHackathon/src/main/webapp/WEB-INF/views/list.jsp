<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<form action="/products/search" method="get">
    <input type="text" name="keyword">
    <button>Tìm kiếm</button>
</form>
<table>
    <thead>
    <tr><th>ID</th><th>Tên</th><th>Giá</th><th>Ảnh</th><th>Trạng thái</th><th>Chức năng</th></tr>
    </thead>
    <tbody>
    <c:forEach items="${products}" var="p">
        <tr>
            <td>${p.id}</td>
            <td>${p.productName}</td>
            <td>${p.price}</td>
            <td><img src="${p.image}" width="80"/></td>
            <td>${p.status}</td>
            <td>
                <a href="/products/edit/${p.id}">Sửa</a>
                <a href="/products/delete/${p.id}" onclick="return confirm('Xóa?')">Xóa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="/products/add">Thêm mới sản phẩm</a>
</body>
</html>