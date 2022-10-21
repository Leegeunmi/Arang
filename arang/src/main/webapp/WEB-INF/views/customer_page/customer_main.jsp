<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="">
  <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
  <meta name="generator" content="Hugo 0.101.0">
  <link rel="stylesheet" href="<c:url value='/resources/css/customer/customer.css'/>">
  
  <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
  <script type="text/javascript" src=<c:url value='/resources/js/customer_main.js'/>></script>
</head>

<body class="bgwh">
  <div id="header_wrap">
  <jsp:include page="/WEB-INF/views/header/header_main.jsp"/>
  </div>
  <div id="wrapper body_wrap2">
  	<div id="products" class="content">
  	<h3 class="headline_shop">Shop</h3>
    <c:set var="total" value="0"></c:set>
      <ul class="ro clearfix">
    <c:forEach var="view" items="${shopItemList}">
        <li class="up">
          <a href="#">
            <div><img width="800" height="800" class="attachment-full size-full wp-post-image vertical_bottom" loading="lazy" src="<c:url value='/resources/img/shop/${view.itemImg}'/>"></div>
            <h2>${view.itemName}</h2>
            <p class="price">${view.itemPrice}<span> with tax</span>
              <div class="actionBtn1">
                <button value="${view.itemName}" onclick="location.href ='customer_buy?itemName1=${view.itemName}'">구매하기</button>

                <button value="${view.itemName}" onclick=cart("${view.itemName}")>담기</button>
              </div>
          </a>
        </li>
    </c:forEach>
      </ul>
    </div>
  </div>
</body>

</html>