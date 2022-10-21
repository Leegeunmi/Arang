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
<div id="body_wrap2">
	<h3>Admin</h3>
	<nav id="sub_nav">
          <ul>
            <li><button class="btn" type="button" onclick='location.href="<c:url value='add_category'/>"'>최상위 메뉴 추가</button></li>
            <li><button class="btn" type="button" onclick='location.href="<c:url value='add_category2'/>"'>하위 메뉴 추가</button></li>
            <li><button class="btn" type="button" onclick='location.href="<c:url value='add_item'/>"'>상품 추가</button></li>
            <li><form action="find_all_category" method="post"><button class="btn" type="submit" class="btn btn-outline-secondary">모든 등록 카테고리 찾기</button></form></li>
            <li><form action="find_all_shop_item" method="post"><button class="btn" type="submit" class="btn btn-outline-secondary">모든 등록 상품 찾기</button></form></li>
          </ul>
        </nav>
</div>
</body>
</html>