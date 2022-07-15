<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html class="js canvas draggable fileAPI geolocation matchMedia picture pushState placeholder no-touchCapable transitions">
<head>
    <title>Home</title>
    <link type="text/css" rel="stylesheet" href="assets/css/style.css">
</head>
<body class="homepage en desktop w1024">
    <div class="wrapper">
        <section class="page-container">
            <%@ include file="WEB-INF/headers.jsp" %>
            <%@ include file="WEB-INF/leftbar.jsp" %>
            <div id="center">
                <div class="center">
                    <div id="sss" class="col">
                        <h3 class="ban"><a href="product" class="sss" data-alltitle="all for sale" data-cat="sss"><span class="txt">for sale<sup class="c"></sup></span></a></h3>
                        <div class="cats">
                            <%--<ul id="sss0" class="left">
                                <li><a href="/search/ata" class="ata" data-cat="ata"><span class="txt">antiques<sup class="c"></sup></span></a></li>
                            </ul>--%>
                            <ul id="sss1" class="mc">
                                <li><a href="product" class="gra" data-cat="gra"><span class="txt">products<sup class="c"></sup></span></a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <%@ include file="WEB-INF/rightbar.jsp" %>
        </section>
    </div>
</body>
</html>