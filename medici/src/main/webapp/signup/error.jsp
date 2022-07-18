<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.net.URLDecoder" %>
<%@page import="java.util.*"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
	<div id="content-wrapper">
		<c:if test="${not empty errorMsgs}">
			<h3>Error, 다시 입력해주세요</h3>
			<ul>
			<c:forEach var="errorMsg" items="${errorMsgs}">
				<li>${errorMsg}</li>
			</c:forEach>
			</ul>
		</c:if>
    </div>
</div>
</body>
</html>
