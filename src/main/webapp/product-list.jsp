<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: FIRST-ACER-Desktop
  Date: 10/21/2023
  Time: 2:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Product List</h1>
<form action="ProductList" method="post">
    <ul>
        <c:forEach var="product" items="${productList}">
            <div>
                <h3>${product.getDescription()}</h3>
                <input type="checkbox" value="${product.getId()}" id="${product.getId()}" name="selectedProducts">
                <label for="${product.getId()}">${product.getTitle()}</label>
            </div>
        </c:forEach>
    </ul>
    <input type="submit" value="Select Products">
</form>
</body>
</html>
