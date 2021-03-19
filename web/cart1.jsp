<%-- 
    Document   : cart
    Created on : 10-Mar-2021, 14:32:15
    Author     : QuocHuy
--%>

<%@page import="CartProducts.OrderDTO"%>
<%@page import="CartProducts.CartDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Cart | Quochuy</title>
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
                        <div class="col-sm-6">
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
                                        <li><a href="CheckoutController"><i class="fa fa-crosshairs"></i> Checkout</a></li>
                                        <li><a href="cart1.jsp" class="active"><i class="fa fa-shopping-cart"></i> Cart</a></li>



                                    </ul>
                                </div>
                            </div>
                        
                    </div>
                </div><!--/header-middle-->

                <div class="header-bottom"><!--header-bottom-->
                    <div class="container">
                        <div class="row">
                            <div class="col-sm-9">
                                <div class="navbar-header">
                                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                                        <span class="sr-only">Toggle navigation</span>
                                        <span class="icon-bar"></span>
                                        <span class="icon-bar"></span>
                                        <span class="icon-bar"></span>
                                    </button>
                                </div>
                                <div class="mainmenu pull-left">
                                    <ul class="nav navbar-nav collapse navbar-collapse">
                                        <li><a href="SearchUSController">Home</a></li>
                                        <li class="dropdown"><a href="#">Shop<i class="fa fa-angle-down"></i></a>
                                            <ul role="menu" class="sub-menu">
                                                <li><a href="SearchUSController">Products</a></li>
                                                <li><a href="cart1.jsp" class="active">Cart</a></li> 
                                            </ul>
                                        </li> 
                                    </ul>
                                </div>
                            </div>

                        </div>
                    </div>
                </div><!--/header-bottom-->
        </header><!--/header-->
        <form action="MainControllerCart" method="POST">

            <%
                CartDTO cart = (CartDTO) session.getAttribute("CART");
            %>
            <section id="cart_items">
                <div class="container">
                    <div class="table-responsive cart_info">
                        <table class="table table-condensed">
                            <thead>
                                <tr class="cart_menu">
                                    <td class="image">Item</td>
                                    <td class="description">Name</td>
                                    <td class="price">Price</td>
                                    <td class="quantity">Quantity</td>
                                    <td class="total">Total</td>
                                    <td></td>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    if (cart != null) {
                                %>
                                <%
                                    for (OrderDTO dto : cart.getCart().values()) {
                                %>
                                <tr>
                                    <td class="cart_product">
                                        <a href=""><img src="images/cart/Iphone.jpg" alt=""></a>
                                    </td>
                                    <td class="cart_description">
                                        <p><%= dto.getName()%></p>
                                    </td>
                                    <td class="cart_price">
                                        <p><%= dto.getPrice()%></p>
                                    </td>
                                    <td class="cart_quantity">
                                        <div class="cart_quantity_button">
                                            <input class="cart_quantity_input" type="text" name="quantity" value="<%= dto.getQuantity()%>" autocomplete="off" size="2">
                                        </div>
                                    </td>
                                    <td class="cart_total">
                                        <p class="cart_total_price"><%= dto.getQuantity() * dto.getPrice()%></p>
                                    </td>
                                    <td class="cart_delete">

                                        <input type="hidden" name="id" value="<%= dto.getProductID()%>"/>

                                        <button type="submit" name="action" value="Delete">

                                            <a class="cart_quantity_delete" href=""><i class="fa fa-times"></i></a>
                                    </td>
                                </tr>
                                <%
                                    }
                                %>
                                <%
                                    }
                                %>

                             <button  type="submit" name="action" value="Update" class="active"><i class="fa fa-ambulance"></i>

                                </button> Update Cart

                            </tbody>
                        </table>
                    </div>
                </div>
        </form>
    </section> <!--/#cart_items-->
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.scrollUp.min.js"></script>
    <script src="js/jquery.prettyPhoto.js"></script>
    <script src="js/main.js"></script>
</body>
</html>

