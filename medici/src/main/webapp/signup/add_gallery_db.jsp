<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.net.URLEncoder" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div id="wrapper">
	<div id="header">
		<jsp:include page="/incl/banner.jsp">
			<jsp:param name="subtitle" value="mod009 : 0706 Connection TEST"/>
		</jsp:include>
	</div>
	<div id="signup_wrapper">
		<h3>갤러리 회원가입</h3>
	<form action="add_gallery_db.do" method="post">
		<div class="container">
			<div class="input">
		사용자 아이디  <input type ="text" name="galleryId"/>
			</div>
			<div class="input">
		비밀번호  <input type ="password" name="passwd"/>
			</div>
			<div class="input">
		갤러리 이름  <input type ="text" name="galleryName"/>
			</div>
			<div class="input">
		갤러리 규모  <input type ="text" name="galleryScale"/>
			</div>
			<div class="input">
		갤러리 주소  <input type ="text" name="galleryAddr"/>
			</div>
			<div class="input">
		대표 전화번호  <input type ="text" name="galleryNumber"/>
			<div class="input">
		이메일1  <input type ="text" name="galleryEmail"/>		 
   		이메일2<select name="galleryEmail2">
	    	<option value="google.com">google.com</option>
    		<option value="naver.com">naver.com</option>
    		<option value="daum.com">daum.net</option>
	    	<option value="korea.com">koreait.com</option>
		</select>
			</div>
			</div>
			<div class="input">
		SNS <input type ="text" name="GallerySns"/>
			</div>						
    </div>
    <input type ="submit" value="회원가입하기"/>		 
</form>
	</div>
	<div id="footer">
		<%@ include file="/incl/footer.jsp" %>
	</div>
</div>

</body>
</html>