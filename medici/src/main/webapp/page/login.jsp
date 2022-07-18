<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">

<head>
  <title>login</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">
  <link rel="stylesheet" href="../design/css_login/normalize.css">
  <link rel="stylesheet" href="../design/css_login/default.css">
  <link rel="stylesheet" href="../design/css_login/style.css">
</head>

<body>
  <div id="wrap">
    <header id="header">
      <div class="inner">
        <!-- 로고 -->
        <h1 id="top-logo">
          <a href="/medici/page/main.jsp">ARANG</a>
        </h1>
        <!-- 메인메뉴 -->
        <nav id="top-nav">
          <ul class="center_menu">
            <li><a href="/medici/page/artists_all.jsp">Artists</a></li>
            <li><a href="/medici/page/gallerys.jsp">Gallerys</a></li>
            <li><a href="../exhibitions/exhibitions.html">Exhibitions</a></li>
            <li><a href="/medici/service/storage_service1.jsp">Storage</a></li>
            <li><a href="../notice/notice.html">Notice</a></li>
          </ul>
          <ul class="side_menu">
            <li><a href="./find/find.html"><img src="../design/img/icon/find.png" alt="find"></a></li>
            <li><a href="/medici/page/login.jsp"><img src="../design/img/icon/mypage.png" alt="mypage"></a></li>
            <li><a href="./like/like.html"><img src="../design/img/icon/like.png" alt="like"></a></li>
            <li><a href="./cart/cart.html"><img src="../design/img/icon/cart.png" alt="cart"></a></li>
          </ul>
        </nav>
      </div>
    </header>
    <div id="login_wrap">
      <div class="title">
        <h1>ARANG 로그인</h1>
      </div>
      <form>
        <table class="table_a">
          <tr>
            <td>
              <input type="text" class="middle" placeholder="이메일(아이디)">
            </td>
          </tr>
          <tr>
            <td>
              <input type="password" class="middle" placeholder="비밀번호">
            </td>
          </tr>
        </table>
        <div class="button-group">
          <button class="gbtn normal">로그인</button>
          <button class="gbtn normal gray">취소</button>
        </div>
        <div class="join">
          <p>아직 회원이 아니신가요?&nbsp;&nbsp;</p>
          <a href="/medici/page/join.jsp"><strong>회원가입<strong></a>
        </div>
      </form>
    </div>
  </div>
</body>
</html>