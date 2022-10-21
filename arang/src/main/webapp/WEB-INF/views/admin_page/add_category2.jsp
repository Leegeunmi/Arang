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
<div id="body_wrap4">
<h3>신규 카테고리 추가</h3>
<form:form class="list_form" method="post" modelAttribute="shopCategory">
	<label>카테고리 상위분류명</label>
	<select name="cateCodeRef">
	<c:forEach var="view" items="${shopCategoryList}">
	<option value="${view.cateCode}">${view.cateName}</option>	
	</c:forEach>					
	</select>
	<label>카테고리 하위분류명</label>
	<form:input path="cateCode"/>
	<label>카테고리 이름</label>
	<form:input path="cateName"/>
	<input type="submit" value="완료">
</form:form>
</div>

</body>
</html>