<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix ="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" type="text/css" href="/fake_resources/css/default/normalize.css"/>
  <link rel="stylesheet" type="text/css" href="/fake_resources/css/default/default.css"/>
  <link rel="stylesheet" type="text/css" href="/fake_resources/css/login/input_style.css"/>
  <script type="text/javascript" src="/fake_resources/js/jquery.js"></script>
</head>
<body>
<jsp:include page="/WEB-INF/views/header/header_main.jsp"/>

<div id="input_wrap">
      <div class="title">
        <h1>LOGIN</h1>
      </div>
      <form action="login" method="post">
        <table class="table_a">
          <tr>
            <td>
              <input type="text" name="email" class="middle" placeholder="이메일(아이디)">
            </td>
          </tr>
          <tr>
            <td>
              <input type="password" name="passwd" class="middle" placeholder="비밀번호">
            </td>
          </tr>
        </table>
        <div class="button-group">
          <button class="gbtn normal" type="submit">로그인</button>
          <button class="gbtn normal" type="button" onclick="location.href='main'">취소</button>
        </div>
        <div class="btn_other">
          <p>아직 회원이 아니신가요?&nbsp;&nbsp;</p>
          <a href="/arang/user/select_user_type"><strong>회원가입<strong></a>
        </div>
      </form>
    </div>



</body>
</html>