<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
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
			<jsp:param name="subtitle" value="TEST SUBTITLE"/>
		</jsp:include>
	</div>
	<div id="content-wrapper">
		<h3>회원가입 되었습니다.</h3>
		<jsp:useBean id="user" class="com.arang.medici.signup.domain.User" scope="request"/>
		아이디 : <jsp:getProperty property="userId" name="user"/>
		이름 : <jsp:getProperty property="koreanName" name="user"/>
    </div>
	<div id="footer">
	<a href='<c:url value="/signup/mypage.jsp"/>'>메인으로</a>
		<%@ include file="/incl/footer.jsp" %>
	</div>
</div>

</body>
</html>