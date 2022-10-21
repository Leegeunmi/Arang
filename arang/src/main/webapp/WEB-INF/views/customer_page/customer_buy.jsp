<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <link rel="stylesheet" href="<c:url value='/resources/css/customer/customer_buy.css'/>">
  <style type="text/css">
    * {
      list-style: none;
    }
    
    #body_wrap {
    	margin-top: 10%;
    }
  </style>
</head>

<body>
  <div id="header_wrap">
  <jsp:include page="/WEB-INF/views/header/header_main.jsp"/>
  </div>
  <div id="table_wrap">
  		<h3>Order</h3>
  		<table>
  		<thead>
  			<tr>
  				<th></th>
  				<th>상품명</th>
  				<th>상품 수량</th>
  				<th>상품 가격</th>
  				<th>주문 관리</th>
  				<th>배송 관리</th>
  			</tr>
  		</thead>
	  	</table>
  		<c:forEach var="view" items="${cartItemList}">
  		<table>
  		<tbody>
  			<tr>
  				<td><img style="width: 100px; height: 100px;" alt="img_area"
				 src="<c:url value='/resources/img/shop/${view.itemImg}'/>"></td>
  				<td>${view.itemName}</td>
  				<td>${view.itemStock}</td>
  				<td>${view.itemPrice}</td>
  				<td><a href="delete_cart_item?deleteItem=${view.cid}">삭제하기</a></td>
  				<td>배송 관리</td>
  			</tr>
  		</tbody>
  		</table>
  		<c:set var= "total" value="${total + view.itemPrice}"/>
  		</c:forEach>
  	<div class="total">
    	<c:out value=" total: ${total}원" />
    	<button class="buy_button">구매하기</button>
    </div>
  </div>
</body>

</html>