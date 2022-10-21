<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<c:url value ='/resources/css/default.css'/>"/>
</head>
<body>
<h3>내 작품조회 페이지</h3>
<c:forEach var="findArtwork" items="${findArtworkList}">
----------------------------------------------------------------------<br>
<label>작품 카테고리 : </label>${findArtwork.genre}
<br>
<label>작품이름 : </label>${findArtwork.name}
<br>
<label>작품소개 : </label>${findArtwork.description}
<br>
<label>작품이미지 : </label>
<img alt="artwork_img" src="/artwork_img/${findArtwork.imgPath}" style="width: 300px; height: 300px;">
<br>

<form action="find_artwork" method="post">
    <input type="hidden" name="id" value="${findArtwork.wid}"/>
	<input type="submit" value="삭제하기"/>
</form>
<a href="update_artwork?id=${findArtwork.wid}">메뉴변경</a>
<br>
</c:forEach>

</body>
</html>