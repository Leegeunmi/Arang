<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<h3>상품 추가 페이지</h3>
<form:form class="list_form" method="post" modelAttribute="item" enctype="multipart/form-data">

	<label>카테고리 분류(대)</label>
	<select name="cateCode">
	<c:forEach var="view" items="${shopCategoryList}">
	<option value="${view.cateCode}">${view.cateName}</option>						
	</c:forEach>
	</select>
	
	<label>카테고리 분류(소)</label><select name="cateCodeRef">
	<c:forEach var="view" items="${shopCategoryList}">
	<option value="${view.cateCodeRef}">${view.cateName}</option>					
	</c:forEach>
	</select>
	
<label>상품이름</label><form:input path="itemName"/>

<label>상품가격</label><form:input path="itemPrice"/>

<label>상품번호</label><form:input path="itemNum"/>

<label>상품정보</label><form:input path="itemInfo"/>

<label>상품재고</label><form:input path="itemStock"/>

<label>상품 이미지</label>
<input type="file" name="imgUpload"/>

<input type="submit" value="메뉴추가">
</form:form>

</div>
</body>
</html>