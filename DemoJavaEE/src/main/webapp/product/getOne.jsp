<%@ page import="demo.javaee.demojavaee.services.ProductService" %>
<%@ page import="demo.javaee.demojavaee.models.Product" %>
<%--
  Created by IntelliJ IDEA.
  User: JAVA
  Date: 12-07-22
  Time: 13:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    ProductService service = ProductService.getInstance(); // this is not a variable but a field. it's instantiated once and not everytime that we reload this page
%>
<%
    String id = request.getParameter("id"); // these variables change everytime we load this page
    if(id == null) {
        response.setStatus(404);
        return;
    }
    Product product = service.getOne(Integer.parseInt(id));
%>
<html>
<head>
    <title>Product details</title>
</head>
<body>
    <h1>Product details</h1>
    <div>
        <p><span>id:</span> <%= product.getId() %></p>
        <p><span>name:</span> <%= product.getName() %></p>
        <p><span>brand:</span> <%= product.getBrand() %></p>
        <p><span>category:</span> <%= product.getCategory() %></p>
        <p><span>price:</span> $<%= product.getPrice() %></p>
    </div>
    <a href="getAll.jsp">Go back to Product list</a>
</body>
</html>