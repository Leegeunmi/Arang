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
<label>작품 카테고리 : </label>${artwork.genre}
<br>
<label>작품이름 : </label>${artwork.name}
<br>
<label>작품소개 : </label>${artwork.description}
<br>
<label>작품이미지 : </label>
<img alt="artwork_img" src="${artwork.artworkImgPath}" style="width: 300px; height: 300px;">
<br>
</body>
</html>