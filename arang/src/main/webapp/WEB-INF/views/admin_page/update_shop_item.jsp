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
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>	
<script type="text/javascript" src=<c:url value='/resources/js/update_shop_item.js'/>></script>
</head>
<body>
  <div id="header_wrap">
  <jsp:include page="/WEB-INF/views/header/header_main.jsp"/>
  </div>
  <div id="body_wrap6">
		<h3>선택한 아이템 정보 수정/삭제</h3>
	<form:form class="list_form" method="post" modelAttribute="shopItem" enctype="multipart/form-data">
	<c:forEach var="view" items="${updateList}">
		<li><label>sid</label>
		<input name="sid" value="${view.sid}"></li>
		<li><label>상위 카테고리</label>
		<input name="cateCodeRef" value="${view.cateCodeRef}"></li>
		<li><label>하위 카테고리</label>
		<input name="cateCode" value="${view.cateCode}"></li>
		<li><label>상품 이름</label>
		<input name="itemName" value="${view.itemName}"></li>
		<li><label>상품 가격</label>
		<input name="itemPrice" value="${view.itemPrice}"></li>
		<li><label>상품 정보</label>
		<input name="itemInfo" value="${view.itemInfo}"></li>
		 <li><label id="imgChange">상품 이미지</label>
		 <input type="file" name="imgUpload"></li>
		 <button type="submit">수정하기</button>
		<a href="delete_shop_itme?sid1=${view.sid}">삭제하기</a>
	</c:forEach>
		<button class="btn" type="button" onclick='location.href="<c:url value='admin_main'/>"'>취소</button>
	</form:form>
	<!-- <button id="imgBtn">이미지 변경하기</button> -->
	</div>
</body>
</html>