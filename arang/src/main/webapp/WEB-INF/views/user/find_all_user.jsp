<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="view" items="${artistList}">
		<li>=========================</li>
		<li>회원코드 : ${view.aid}</li>
		<li>이메일 : ${view.email}</li>
		<li>비밀번호 : ${view.passwd}</li>
		<li>전화번호 : ${view.phone}</li>
		<li>이름 : ${view.name}</li>
		<li>나이 : ${view.age}</li>
		<li>장르 : ${view.genre}</li>
		<li>경력 : ${view.career}</li>
		<li>가입날짜 : ${view.regDate}</li>
	</c:forEach>
</body>
</html>