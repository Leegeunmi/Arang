<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.net.URLEncoder" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="update_user.do" method="post">
	<h3>갤러리 업데이트</h3>
		<ul>
			<li>변경 비밀번호: <input type="text" name="passwd"/></li>
			<li>변경 닉네임: <input type="text" name="galleryName"/></li>
			<li>변경자의 ID: <input type="text" name="galleryId"/></li>			
			<li><input type="submit" value="확인"/></li>				
		</ul>
	</form>
</body>
</html>