<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>스토리지 신청완료</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">
  <link rel="stylesheet" href="../design/css_default/normalize.css">
  <link rel="stylesheet" href="../design/css_default/default.css">
  <link rel="stylesheet" href="../design/css_default/header.css">
  <link rel="stylesheet" href="../design/css_storage_success/storage_success.css">
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
    <div id="storage_service_wrap">
      <div class="title">
        <h1>결제완료</h1>
      </div>
      <form>
        <p>보관서비스 신청내역</P>
        <table class="table_a">
          <tr>
            <td>
              <p>작품코드 : A1205</p>
            </td>
          </tr>
          <tr>
            <td>
              <p>지역 : 대구</p>
            </td>
          </tr>
          <tr>
            <td>
              <p>지역 : 서울</p>
            </td>
          </tr>
          <tr>
            <td>
              <p>보관소 : 강남구 남부순환로 3104 SETEC컨벤션센터</p>
            </td>
          </tr>
          <tr>
            <td>
              <p>보관 일정 : 2022-07-18 ~ 2022.07.25</p>
            </td>
          </tr>
          <tr>
            <td>
              <p>배송서비스 : YES</p>
            </td>
          </tr>
          <tr>
            <td>
              <p>결제금액 : 150,000</p>
            </td>
          </tr>
        </table>
        <div class="button-group">
          <button class="gbtn normal">돌아가기</button>
        </div>
      </form>
    </div>
  </div>
</body>
</html>