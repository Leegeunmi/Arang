<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Arang</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">
<link rel="stylesheet" type="text/css" href="/fake_resources/css/default/normalize.css">
<link rel="stylesheet" type="text/css" href="/fake_resources/css/default/default.css">
<link rel="stylesheet" type="text/css" href="/fake_resources/css/default/header.css">
<link rel="stylesheet" type="text/css" href="/fake_resources/css/storage/storage_list.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<div id="wrap">
	<jsp:include page="/WEB-INF/views/header/header_main.jsp"/>
    <div class="board_wrapper">
      <h3 class="sub_title">My Storage</h3>
      <div>
        <form>
          <fieldset>
            <div class="field_inner">
              <label>검색어</label>
              <input type="text">
              <a href="#"><button class="board_btn" type="button">검색</button></a>
              <a href="/arang/storage_page/storage_main"><button class="board_btn service"  type="button">작품보관신청</button></a>
            </div>
          </fieldset>
        </form>
      </div>
      <table class="storage_list artist">
        <tr>
          <td>작품코드</td>
          <td>신청자</td>
          <td>지역</td>
          <td>보관소</td>
          <td>보관 일정</td>
          <td>운송 서비스</td>
          <td>결제금액</td>
          <td>신청일</td>
          <td>승인상태</td>
          <td>관리자</td>
        </tr>
        <c:forEach var="view" items="${storageList}">
        <tr>
          <td>${view.sid}</td>
          <td>${view.artistId}</td>
          <td>${view.myAddress}</td>
          <td>${view.locationArea}</td>
          <td>${view.storagePeriodStart} ~ ${view.storagePeriodEnd}</td>
          <td>${view.transport}</td>
          <td>${view.charge}</td>
          <td>${view.regDate}</td>
          <td>${view.approvalStatus}</td>
          <td><a href="storage_update?sid=${view.sid}">관리</a></td>
        </tr>
        </c:forEach>
      </table>
    </div>
  </div>
</body>
</html>
