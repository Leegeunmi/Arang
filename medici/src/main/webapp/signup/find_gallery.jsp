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
			<c:forEach var="gl" items="${galleryList}">
				<li>==================</li>
				<li>ID : ${gl.galleryId}</li>
				<li>PASSWD : ${gl.passwd}</li>
				<li>galleryName : ${gl.galleryName}</li>
				<li>galleryScale : ${gl.galleryScale}</li>
				<li>galleryAddr : ${gl.galleryAddr}</li>
				<li>galleryNumber : ${gl.galleryNumber}</li>
				<li>galleryEmail : ${gl.galleryEmail}</li>
				<li>gallerySns : ${gl.gallerySns}</li>			
			</c:forEach>	
	</ul>
	<div id="footer">
		<%@ include file="/incl/footer.jsp" %>
	</div>
</div>

</body>
</html>