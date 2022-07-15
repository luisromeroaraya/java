<%@ page import="demo.javaee.demojavaee.services.ProductService" %>
<%@ page import="demo.javaee.demojavaee.models.Product" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: JAVA
  Date: 12-07-22
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%!
    ProductService service = ProductService.getInstance(); // this is not a variable but a field. it's instantiated once and not everytime that we reload this page
%>
<%
    List<Product> products = service.getAll();
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html class="js canvas draggable fileAPI geolocation matchMedia picture pushState placeholder no-touchCapable transitions">
<head>
    <title>Product list</title>
    <link rel="stylesheet" href="../assets/css/style.css">
</head>
<body class="homepage en desktop w1024">
    <div class="wrapper">
        <section class="page-container">
            <%@ include file="../WEB-INF/headers.jsp" %>
            <%@ include file="../WEB-INF/leftbar.jsp" %>
            <div id="center">
                <div class="center">
                    <div id="sss" class="col">
                        <h3 class="ban"><a href="/search/sss" class="sss" data-alltitle="all for sale" data-cat="sss"><span class="txt">for sale<sup class="c"></sup></span></a></h3>
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
                                    <p><span>product page:</span> <a href="../product?id=<%= product.getId() %>">link</a></p>
                                </div>
                            </li>
                            <% } %>
                        </ul>
                    </div>
                </div>
            </div>
            <%@ include file="../WEB-INF/rightbar.jsp" %>
        </section>
    </div>
</body>
</html>
