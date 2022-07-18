<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>결제성공페이지</h3>
${wallet.sucessMsg}<br>
결제 후 잔액 : ${wallet.resultBalance}<br>
결제 된 금액 : ${wallet.balance}<br>

</body>
</html>