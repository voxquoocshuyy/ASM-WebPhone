<%-- 
    Document   : update
    Created on : Mar 12, 2021, 8:31:22 PM
    Author     : Quoc Huy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Update Iphone</h1>
        <form action="MainController" method="POST">
            Product ID: <input type="text" name="txtProductID" value="${requestScope.DTO.productID}" readonly="true"/>
            <br/>
            Product Name: <input type="text" name="txtName" value="${requestScope.DTO.name}"/>
            <font color="red">
            ${requestScope.INVALID.productIDError}
            </font>
            <br/>
            Price: <input type="text" name="txtPrice" 
                          <c:if test="${requestScope.DTO.price == 0}" var="price">
                              value="${param.txtPrice}"
                          </c:if>
                          <c:if test="${!price}">
                              value="${requestScope.DTO.price}"
                          </c:if>
                          />
            <font color="red">
            ${requestScope.INVALID.priceError}
            </font>
            <br/>
            Quantity: <input type="text" name="txtQuantity" 
                             <c:if test="${requestScope.DTO.quantity == 0}" var="quantity">
                                 value="${param.txtQuantity}"
                             </c:if>
                             <c:if test="${!quantity}">
                                 value="${requestScope.DTO.quantity}"
                             </c:if>
                             />
            <font color="red">
            ${requestScope.INVALID.quantityError}
            </font>
            <br/>
            Category ID: <input type="text" name="txtCategoryID" value="${requestScope.DTO.categoryID}"/>
            <font color="red">
            ${requestScope.INVALID.categoryIDError}
            </font>
            <br/>
            <input type="hidden" name="txtSearch" value="${param.txtSearch}"/>
            <input type="submit" name="action" value="Update"/>
        </form>
    </body>
</html>
