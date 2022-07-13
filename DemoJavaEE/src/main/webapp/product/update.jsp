<%@ page import="demo.javaee.demojavaee.models.Product" %><%--
  Created by IntelliJ IDEA.
  User: JAVA
  Date: 12-07-22
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update product</title>
    <link rel="stylesheet" href="../assets/css/style.css">
</head>
<h1>Add new product</h1>
<%
    Product product = (Product) request.getAttribute("product");
%>
<form action="<%=request.getContextPath()%>/product/update" method="post">
    <div>
        <input type="hidden" name="id" value="<%= product.getId() %>">
    </div>
    <div>
        <label for="name">name:</label></br>
        <input type="text" id="name" name="name" value="<%= product.getName() %>">
    </div>
    <div>
        <label for="brand">brand:</label></br>
        <input type="text" id="brand" name="brand" value="<%= product.getBrand() %>">
    </div>
    <div>
        <label for="category">category:</label></br>
        <input type="text" id="category" name="category" value="<%= product.getCategory() %>">
    </div>
    <div>
        <label for="price">price:</label></br>
        <input type="number" id="price" name="price" value="<%= product.getPrice() %>">
    </div>
    <button type="submit" id="submit">Update</button>
</form>
</br>
<div>
    <a href="../product">Go back to "Product list"</a>
</div>
</body>
</html>