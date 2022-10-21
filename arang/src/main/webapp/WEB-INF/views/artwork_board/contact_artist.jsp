<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix ="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아티스트가입</title>
<link rel="stylesheet" type="text/css" href="/fake_resources/css/default/normalize.css"/>
  <link rel="stylesheet" type="text/css" href="/fake_resources/css/default/default.css"/>
  <link rel="stylesheet" type="text/css" href="/fake_resources/css/login/input_style.css"/>
  <link rel="stylesheet" type="text/css" href="/fake_resources/css/join/join_artist.css"/>
  <script type="text/javascript" src="/fake_resources/js/jquery.js"></script>
</head>
<body>
<jsp:include page="/WEB-INF/views/header/header_main.jsp"/>
<div id="input_wrap">
      <div class="title">
        <h1>ARTIST CONTACT</h1>
      </div>
      <form action="contact_artist" method="post">
        <table class="table_a">
          <tr>
            <td>
              <input name="exhibitionTitle" class="big" placeholder="갤러리 전시명"/>
            </td>
          </tr>
          <tr>
            <td>
              <input name="comment" class="big" placeholder="갤러리 간단소개" style="width: 500px;"/>
            </td>
          </tr>
          <tr>
            <td>
              <input name="startDate" type="date" class="big" placeholder="시작날짜"/>
            </td>
          </tr>
          <tr>
            <td>
              <input name="endDate" type="date" class="big" placeholder="종료날짜"/>
            </td>
          </tr>
      
        </table>
        <div class="button-group">
          <button type="submit" class="gbtn normal">CONTACT 신청</button>
          <button class="gbtn normal" type="button" onclick="location.href='/arang/main'">취소</button>
        </div>
      </form>
    </div>
</body>
</html>