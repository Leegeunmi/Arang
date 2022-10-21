<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
        <table class="table_a">
          <tr>
            <td>
            <label>아이디</label>
              <form:input type="text" class="big" value="${email}" path="artistId" placeholder="이메일"/>
            </td>
          </tr>
          <tr>
            <td>
            <label>신청자 주소</label>
              <form:select path="myAddress">
                <option disabled="disabled" selected="selected">지역</option>
                <option value="서울/경기">서울/경기</option>
                <option value="대전">대전</option>
                <option value="광주">광주</option>
                <option value="대구">대구</option>
                <option value="부산">부산</option>
                <option value="울산">울산</option>
                <option value="강원">강원</option>
                <option value="충청">충청</option>
                <option value="경상">경상</option>
                <option value="전라">전라</option>
                <option value="제주">제주</option>
              </form:select>
            </td>
          </tr>
          <tr>
            <td>
              <form:select path="locationArea">
                <option disabled="disabled" selected="selected">보관소</option>
                <option value="강남구 남부순환로 3104 SETEC컨벤션센터">강남구 남부순환로 3104 SETEC컨벤션센터</option>
                <option value="마포구 대흥로20길 28 마포아트센터">마포구 대흥로20길 28 마포아트센터</option>
                <option value="광진구 아차산로 710 서울창작센터">광진구 아차산로 710 서울창작센터</option>
              </form:select>
            </td>
          </tr>
          <tr>
            <td class="date_td">
              <p>보관시작</p>
              <p>보관종료</p>
              <form:input type="date" value="${myToday}" min="${myToday}" path="storagePeriodStart"/>
              <form:input type="date" min="${myToday}" path="storagePeriodEnd"/>
            </td>
          </tr>
          <tr>
            <td>
              <form:select path="transport">
                  <option disabled="disabled" selected="selected">운송서비스</option>
                  <option value="0">No</option>
                  <option value="1">Yes</option>
              </form:select>
            </td>
          </tr>
          <tr>
            <td>
              <form:select path="artworkType">
              	<option disabled="disabled" selected="selected">작품 타입</option>
                  <option value="조각">조각</option>
                  <option value="그림">그림</option>
              </form:select>
            </td>
          </tr>
          <tr>
            <td>
              <form:input class="big" type="text" path="artworkSize" placeholder="작품 사이즈"/>
            </td>
          </tr>
            <tr>
            <td>
              <form:input class="big" type="text" path="artworkWeight" placeholder="작품 무게(kg)"/>
            </td>
          </tr>
          <tr>
            <td>
              <form:input type="text" class="big" value="100" path="charge" readonly="readonly" placeholder="결제금액"/>
            </td>
            <td>
              <form:input type="hidden" class="big" path="approvalStatus" value="관리자 승인 대기"/>
            </td>
          </tr>
        </table>
        <div class="button-group">
          <a href="./storage_service.html"><button class="btn2">결제</button></a>
          <button class="btn2" type="button" onclick='location.href="<c:url value='/storage_page/storage_main'/>"'>취소</button><br>
        </div>
      </form:form>
    </div>
  </div>
</body>
</html>