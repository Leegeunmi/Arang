<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
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
			<jsp:param name="subtitle" value="TEST SUBTITLE"/>
		</jsp:include>
	</div>
	<div id="content-wrapper">
		<h3>회원가입 되었습니다.</h3>
		<jsp:useBean id="gallery" class="com.arang.medici.signup.domain.Gallery" scope="request"/>
		갤러리 아이디 : <jsp:getProperty property="galleryId" name="gallery"/>
		갤러리 이름 : <jsp:getProperty property="galleryName" name="gallery"/>
    </div>
	<div id="footer">
		<%@ include file="/incl/footer.jsp" %>
	</div>
</div>

</body>
</html>