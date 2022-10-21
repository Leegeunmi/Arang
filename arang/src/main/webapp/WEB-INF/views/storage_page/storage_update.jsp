<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">
<link rel="stylesheet" type="text/css" href="/fake_resources/css/default/normalize.css">
<link rel="stylesheet" type="text/css" href="/fake_resources/css/default/default.css">
<link rel="stylesheet" type="text/css" href="/fake_resources/css/default/header.css">
<link rel="stylesheet" type="text/css" href="/fake_resources/css/join/join_artist.css">
<link rel="stylesheet" type="text/css" href="/fake_resources/css/login/input_style.css">
<link rel="stylesheet" type="text/css" href="/fake_resources/css/storage/storage_service.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<div id="wrap">
    <jsp:include page="/WEB-INF/views/header/header_main.jsp"/>
    <div id="input_wrap">
      <div class="title">
        <h1>STORAGE SERVICE</h1>
      </div>
      <form:form method="post" modelAttribute="storage">
      <c:forEach var="view" items="${storageList}">
        <table class="table_a">
          <tr>
            <td>
        	<label>아이디</label>
              <form:input type="text" class="big" value="${email}" path="artistId" placeholder="아이디"/>
            </td>
          </tr>
          <tr>
            <td>
	        <label>신청자 주소</label>
              <form:input path="myAddress" value="${view.myAddress}"/>
            </td>
          </tr>
          <tr>
            <td>
            <label>보관지역</label>
              <form:input path="locationArea" value="${view.locationArea}"/>
            </td>
          </tr>
          <tr>
            <td class="date_td">            	
          <label>보관 일자</label>
              	<form:input path="storagePeriodStart" value="${view.storagePeriodStart}"/>
		 		<form:input path="storagePeriodEnd" value="${view.storagePeriodEnd}"/>
            </td>
          </tr>
          <tr>
            <td>
            <label>운송서비스</label>
              <form:input path="transport" value="${view.transport}"/>
            </td>
          </tr>
          <tr>
            <td>
            <label>작품 타입</label>
              <form:input path="artworkType" value="${view.artworkType}"/>
            </td>
          </tr>
          <tr>
            <td>
            <label>작품 무게</label>
              <form:input path="artworkSize" value="${view.artworkSize}"/>
            </td>
          </tr>
          <tr>
            <td>
            <label>이용 요금</label>
              <form:input path="charge" value="${view.charge}"/>
            </td>
            <td>   
            </td>
          </tr>
        </table>       	
			<li><form:radiobutton class="form_inline input_small" path="approvalStatus" value="승인완료" label="승인완료"/></li>
			<li><form:radiobutton class="form_inline input_small" path="approvalStatus" value="관리자 승인대기" label="관리자 승인대기" checked="checked"/></li>
			<li><form:radiobutton class="form_inline input_small" path="approvalStatus" value="수정요청" label="수정요청"/></li>
        <div class="button-group">
		<button class="btn2" type="submit">변경</button>
		<button class="btn2">
		<a class="color_white" href="storage_delete?sid=${view.sid}&approvalStatus=${view.approvalStatus}">삭제하기</a>		
		</button>
        </div>
        </c:forEach>
      </form:form>
    </div>
  </div>
</body>
</html>
