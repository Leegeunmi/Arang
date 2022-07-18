<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
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
			<jsp:param name="subtitle" value="SELECT TEST"/>
		</jsp:include>
	</div>
	<ul>
			<c:forEach var="test" items="${userList}">
				<li>==================</li>
				<li>ID : ${test.userId}</li>
				<li>PASSWD : ${test.passwd}</li>
				<li>USERNAME : ${test.koreanName}</li>
				<li>SSN : ${test.ssn}</li>
				<li>EMAIL : ${test.email}</li>
				<li>ADDR : ${test.addr}</li>				
			</c:forEach>	
	</ul>
	<div id="footer">
		<%@ include file="/incl/footer.jsp" %>
	</div>
</div>

</body>
</html>