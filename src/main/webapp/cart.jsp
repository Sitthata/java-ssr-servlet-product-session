<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: FIRST-ACER-Desktop
  Date: 10/21/2023
  Time: 3:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Your Cart</h2>
<c:if test="${not empty sessionScope.selectedProducts}">
    <ul>
        <c:forEach var="product" items="${sessionScope.selectedProducts}">
            <li>${product.getTitle()} - ${product.getDescription()}</li>
        </c:forEach>
    </ul>
</c:if>

<c:if test="${empty sessionScope.selectedProducts}">
    <p>No products selected.</p>
</c:if>
</body>
</html>
