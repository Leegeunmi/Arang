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
  <div id="body_wrap3">
  	<h3>카테고리 조회</h3>
	<c:forEach var="view" items="${shopCategoryList}">
	<ul>
		<li>=========================</li>
		<li>카테고리 이름 : ${view.cateName}</li>
		<li>상위 카테고리 : ${view.cateCodeRef}</li>
		<li>하위카테고리 : ${view.cateCode}</li>
	</ul>
	</c:forEach>
	</div>
</body>
</html>