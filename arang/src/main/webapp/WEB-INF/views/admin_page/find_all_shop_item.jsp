<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<c:url value='/resources/css/admin/admin.css'/>">
</head>
<body>
  <div id="header_wrap">
 <jsp:include page="/WEB-INF/views/header/header_main.jsp"/>
  </div>
	<div id="body_wrap5">
	<h3>상품 조회</h3>
	<div id="cate_wrap1">
	<c:forEach var="view" items="${shopItemList}">
	<div id="cate_wrap2">
		<ul>
		<li><img style="width: 300px; height: 300px;" alt="img_area"
		 src="<c:url value='/resources/img/shop/${view.itemImg}'/>">		 
		 </li>
		<li>상위 카테고리 : ${view.cateCodeRef}</li>
		<li>하위카테고리 : ${view.cateCode}</li>
		<li>상품 이름 : ${view.itemName}</li>
		<li>상품 가격 : ${view.itemPrice}</li>
		<li>상품 정보 : ${view.itemInfo}</li>
		</ul>
		<a href="update_shop_item?sid1=${view.sid}">수정하기</a>
	</div>
	</c:forEach>
	</div>
	</div>
</body>
</html>