<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>购物车</title>
</head>
<body>

<table border="1" cellspacing="0">
    <tr>
        <td>商品名称</td>
        <td>单价</td>
        <td>数量</td>
        <td>小计</td>
        <td>delete</td>
    </tr>
    <c:forEach items="${orderItems}" var="orderItem" varStatus="st">
        <tr>
            <td>${orderItem.product.name}</td>
            <td>${orderItem.product.price}</td>
            <td>${orderItem.num}</td>
            <td>${orderItem.product.price * orderItem.num}</td>
            <%--<td><a href="deleteOrderItem?pid=${orderItem.pid}">delete</a></td>--%>
            <td><a href="deleteOrderItem?pid=${orderItem.product.id}">delete</a></td>
        </tr>
    </c:forEach>

    <c:if test="${!empty orderItems}">
        <tr>
            <td colspan="4" align="right">
                <a href="/createOrder">生成订单</a>
            </td>
        </tr>
    </c:if>

</table>

</body>
</html>