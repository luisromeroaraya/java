<%@ page import="demo.javaee.demojavaee.services.ProductService" %>
<%@ page import="demo.javaee.demojavaee.models.Product" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: JAVA
  Date: 12-07-22
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    ProductService service = ProductService.getInstance(); // this is not a variable but a field. it's instantiated once and not everytime that we reload this page
%>
<%
    List<Product> products = service.getAll();
%>
<html>
<head>
    <title>Product list</title>
</head>
<body>
<h1>Product list</h1>
<ul>
<% for (Product product : products) { %>
    <li>
        <div>
            <p><span>id:</span> <%= product.getId() %></p>
            <p><span>name:</span> <%= product.getName() %></p>
            <p><span>brand:</span> <%= product.getBrand() %></p>
            <p><span>category:</span> <%= product.getCategory() %></p>
            <p><span>price:</span> $<%= product.getPrice() %></p>
            <p><span>product page:</span> <a href="getOne.jsp?id=<%= product.getId() %>">link</a></p>
        </div>
    </li>
<% } %>
</ul>
<a href="addOne.jsp">Add product</a>
</body>
</html>
