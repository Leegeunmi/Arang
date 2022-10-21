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
<h3>전체 작품조회 페이지</h3>
<label>Category</label>
<br>
<a href="" class="category">Sulptor</a>
<a href="" class="category">Painter</a>
<a href="" class="category">OrientalPainter</a>
<a href="" class="category">DrawingArtist</a>
<a href="" class="category">Illustator</a>
<a href="" class="category">DigitalArtist</a>
<a href="" class="category">Photographer</a>
<br>
<c:forEach var="findArtwork" items="${findArtworkList}">
----------------------------------------------------------------------<br>
<label>작품 카테고리 : </label>${findArtwork.genre}
<br>
<label>작품이름 : </label>${findArtwork.name}
<br>
<label>작품소개 : </label>${findArtwork.description}
<br>
<label>작품 사이즈 : </label>${findArtwork.size}
<br>
<label>제작년도 : </label>${findArtwork.publicationDate}
<br>
<label>기법 : </label>${findArtwork.technique}
<br>
<label>작품이미지 : </label>
<img alt="artwork_img" src="${findArtwork.artworkImgPath}" style="width: 300px; height: 300px;">
<br>

</c:forEach>

</body>
</html>