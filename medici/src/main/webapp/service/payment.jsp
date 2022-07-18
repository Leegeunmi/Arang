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
<h3>결제페이지</h3>
<form action="payment" method="post">
결제할아이디 : <input type="text" name="userId"/><br>
보관금액 : 5000원<br>
결제금액 : <input type="number" name="inputBalance"/>
<input type="submit" value="확인"/>
</form>

</body>
</html>