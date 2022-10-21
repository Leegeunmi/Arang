<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<c:url value ='/resources/css/default/normalize.css'/>"/>
<link rel="stylesheet" type="text/css" href="<c:url value ='/resources/css/default/default.css'/>"/>
<link rel="stylesheet" type="text/css" href="<c:url value ='/resources/css/default/header.css'/>"/>
<script type="text/javascript" src="<c:url value ='/resources/js/jquery.js'/>"></script>
</head>
<body>
<header id="header">
	<div class="inner">
		<!-- 로고 -->
		<h1 id="top-logo">
          <a href="/arang/main">ARANG</a>
        </h1>
        <!-- 메인메뉴 -->
        <nav id="top-nav">
          <ul class="center_menu">
            <li><a href="/arang/artist_board/artist_main">Artists</a></li>
            <li><a href="/arang/gallery/gallery">Gallerys</a></li>
            <li><a href="/arang/exhibitions/exhibitions_main">Exhibitions</a></li>
            <li><a href="/arang/storage_page/storage_main">Storage</a></li>
            <li><a href="/arang/notice/notice">Notice</a></li>
            <li><a href="/arang/customer_page/customer_main">Shop</a></li>
          </ul>
          <ul class="side_menu">
            <li><a href="/arang/main"><img src="<c:url value ='/resources/img/icon/find.png'/>" alt="find"></a></li>
            <c:if test="${artistLogin != null}">
            	<li><a href="/arang/mypage/mypage_artist"><img src="<c:url value ='/resources/img/icon/mypage.png'/>" alt="mypage"></a></li>
            </c:if>
            <c:if test="${galleristLogin != null}">
            	<li><a href="/arang/mypage/mypage_gallerist"><img src="<c:url value ='/resources/img/icon/mypage.png'/>" alt="mypage"></a></li>
            </c:if>
            <c:if test="${galleristLogin == null && artistLogin == null}">
            	<li><a href="/arang/login"><img src="<c:url value ='/resources/img/icon/mypage.png'/>" alt="mypage"></a></li>
            </c:if>
            <li><a href="/arang/mypage/wish_list"><img src="<c:url value ='/resources/img/icon/like.png'/>" alt="like"></a></li>
            <li><a href="/arang/mypage/mypage_gallerist"><img src="<c:url value ='/resources/img/icon/cart.png'/>" alt="cart"></a></li>
            <c:if test="${email == null}">
            	<li><a href="/arang/login">Login</a></li>
            </c:if>
            <c:if test="${email != null}">
            	<li><a href="/arang/user/logout">logout</a></li>
            </c:if>
          </ul>
        </nav>
	</div>
</header>
</body>
</html>