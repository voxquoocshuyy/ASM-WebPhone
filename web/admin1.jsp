<%-- 
    Document   : admin
    Created on : 12-Mar-2021, 15:08:06
    Author     : QuocHuy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Shop Phone | QuocHuy</title>
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/prettyPhoto.css" rel="stylesheet">
        <link href="css/price-range.css" rel="stylesheet">
        <link href="css/animate.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
        <link href="css/responsive.css" rel="stylesheet">
        <!--[if lt IE 9]>
        <script src="js/html5shiv.js"></script>
        <script src="js/respond.min.js"></script>
        <![endif]-->       
        <link rel="shortcut icon" href="images/ico/favicon.ico">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
    </head><!--/head-->

    <body>
        <header id="header"><!--header-->
            <div class="header_top"><!--header_top-->
                <div class="container">
                    <div class="row">
                        <div class="col-sm-6 ">
                            <div class="contactinfo">
                                <ul class="nav nav-pills">
                                    <li><a href=""><i class="fa fa-phone"></i> +84 88888888888</a></li>
                                    <li><a href=""><i class="fa fa-envelope"></i> quochuy@assignment.com</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="social-icons pull-right">
                                <ul class="nav navbar-nav">
                                    <li><a href=""><i class="fa fa-facebook"></i></a></li>
                                    <li><a href=""><i class="fa fa-twitter"></i></a></li>
                                    <li><a href=""><i class="fa fa-linkedin"></i></a></li>
                                    <li><a href=""><i class="fa fa-dribbble"></i></a></li>
                                    <li><a href=""><i class="fa fa-google-plus"></i></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!--/header_top-->

            <div class="header-middle"><!--header-middle-->
                <div class="container">
                    <div class="row">

                        <div class="col-sm-8">
                            <div class="shop-menu pull-right">
                                <ul class="nav navbar-nav">
                                    <li><a href="#"><i class="fa fa-user"></i>Hi: ${sessionScope.LOGIN_USER.name}</a></li>								
                                    <li><a href="DisplayController"><i class="fa fa-star"></i> Manager Product</a></li>
                                    <!--<li><a href="viewCart.jsp"><i class="fa fa-shopping-cart"></i> Cart</a></li>-->
                                    <li><a href="LogoutController"><i class="fa fa-lock"></i> Logout</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!--/header-middle-->
            <form action="MainController" method="POST">


                <div class="container">

                    <div class="row col-md-12 custyle">

                        <c:if test="${requestScope.LIST != null}">
                            <c:if test="${not empty requestScope.LIST}" var="checkList">
                                <table class="table table-striped custab">
                                    <thead>
                                    <a href="insert.jsp" class="btn btn-sm btn-primary btn-create"><b>+</b> Add new products</a>
                                    <tr>
                                        <th>No</th>
                                        <th>Product ID</th>
                                        <th>Product Name</th>
                                        <th>Price</th>
                                        <th>Quantity</th>
                                        <th>Category ID</th>
                                        <th>Delete</th>
                                        <th>Update</th>
                                    </tr>                      
                                    </thead>
                                    <tbody>
                                        <c:forEach var="dto" items="${requestScope.LIST}" varStatus="counter">
                                            <tr>
                                                <td>${counter.count}</td>
                                                <td>${dto.productID}</td>
                                                <td>${dto.name}</td>
                                                <td>${dto.price}</td>
                                                <td>${dto.quantity}</td>
                                                <td>${dto.categoryID}</td>
                                                <td>
                                                    <c:url var="delete" value="MainController">
                                                        <c:param name="action" value="Delete"></c:param>
                                                        <c:param name="search" value="${param.search}"></c:param>
                                                        <c:param name="productID" value="${dto.productID}"></c:param>
                                                    </c:url>
                                                    <a href="${delete}">Delete</a>
                                                </td>
                                                <td> 
                                                    <c:url var="edit" value="MainController">
                                                        
                                                       <c:param name="action" value="Edit"></c:param>
                                                        <c:param name="productID" value="${dto.productID}"></c:param>
                                                    </c:url>
                                                    <a href="${edit}">Edit</a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>

                            </c:if>
                            <c:if test="${!checkList}">
                            </c:if>
                        </c:if >
                    </div>
                </div>
            </form>
        </header>

        <section id="advertisement">
            <div class="container">
                <img src="images/shop/ava.gif" alt="" />
            </div>
        </section>


    </footer><!--/Footer-->



    <script src="js/jquery.js"></script>
    <script src="js/price-range.js"></script>
    <script src="js/jquery.scrollUp.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.prettyPhoto.js"></script>
    <script src="js/main.js"></script>
</body>
</html>