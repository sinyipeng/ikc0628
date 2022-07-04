<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="UTF-8">

<style type="text/css">
	table {
	font-family: "Lucida Sans Unicode", "Lucida Grande", Sans-Serif;
	font-size: 12px;
	margin: 45px;
	width: 480px;
	text-align: left;
	border-collapse: collapse;
	position: relative;
	left: 50px; 
}
th {
	font-size: 13px;
	font-weight: normal;
	padding: 8px;
	background: #b9c9fe;
	border-top: 4px solid #aabcfe;
	border-bottom: 1px solid #fff;
	color: #039;
}
td {
	padding: 8px;
	background: #e8edff; 
	border-bottom: 1px solid #fff;
	color: #669;
	border-top: 1px solid transparent;
}
tr:hover td {
	background: #d0dafd;
	color: #339;
}
</style>

<title>OrderDetails</title>

</head>
<body>
	<c:if test="${not empty select}">
<table>
	<thead>
	<tr>
		<th>OrderDetailID </th>
		<th>OrderID</th>
		<th>ProductID</th>
		<th>unitPrice</th>
		<th>OrderQuantity</th>
		<th>Discount</th>
	</tr>
	</thead>
	<tbody>
	
	<c:forEach var="row" items="${select}">
		<c:url value="/pages/product.jsp" var="path">
			<c:param name="orderDetailID" value="${row.orderDetailID}" />
			<c:param name="orderID" value="${row.orderID}" />
			<c:param name="productID" value="${row.productID}" />
			<c:param name="unitPrice" value="${row.unitPrice}" />
			<c:param name="orderQuantity" value="${row.orderQuantity}" />
			<c:param name="discount" value="${row.discount}" />
		</c:url>
	<tr>
		<td><a href="${path}">${row.orderDetailID}</a></td>
		<td>${row.orderID}</td>
		<td>${row.productID}</td>
		<td>${row.unitPrice}</td>
		<td>${row.orderQuantity}</td>
		<td>${row.discount}</td>
	</tr>
	</c:forEach>
	
	</tbody>
</table>
</c:if>

<h3><a href="<c:url value="/pages/OrdersServlet.controller?prodaction=Select" />">回訂單表</a></h3>
</body>
</html>