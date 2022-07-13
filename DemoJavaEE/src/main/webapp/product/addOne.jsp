<%--
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
    <title>Add product</title>
    <link rel="stylesheet" href="../assets/css/style.css">
</head>
<h1>Add new product</h1>
<form action="<%=request.getContextPath()%>/product/add" method="post">
    <div>
        <label for="name">name:</label></br>
        <% String name = request.getParameter("name"); %>
        <input type="text" id="name" name="name" value="<%= name == null ? "" : name %>">
    </div>
    <div>
        <label for="brand">brand:</label></br>
        <% String brand = request.getParameter("brand"); %>
        <input type="text" id="brand" name="brand" value="<%= brand == null ? "" : brand %>">
    </div>
    <div>
        <label for="category">category:</label></br>
        <% String category = request.getParameter("category"); %>
        <input type="text" id="category" name="category" value="<%= category == null ? "" : category %>">
    </div>
    <div>
        <label for="price">price:</label></br>
        <% String price = request.getParameter("price"); %>
        <input type="number" id="price" name="price" value="<%= price == null ? "" : Double.parseDouble(category) %>">
    </div>
    <button type="submit" id="submit">Add</button>
</form>
</br>
<div>
    <a href="../">Go back to "Product list"</a>
</div>
</body>
</html>
