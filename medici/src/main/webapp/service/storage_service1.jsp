<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
  <title>스토리지 리스트</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">
  <link rel="stylesheet" href="../design/css_default/normalize.css">
  <link rel="stylesheet" href="../design/css_default/default.css">
  <link rel="stylesheet" href="../design/css_default/header.css">
  <link rel="stylesheet" href="../design/css_storage_service1/storage_service1.css">
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
    <div class="board_wrapper">
      <h3 class="board_top">My Storage</h3>
      <div>
        <form>
          <fieldset>
            <div class="field_inner">
              <label>검색어</label>
              <input type="text">
              <a href="#"><button type="button">검색</button></a>
              <a href="/medici/service/storage_service2.jsp"><button type="button">작품보관신청</button></a>
            </div>
          </fieldset>
        </form>
      </div>
      <table class="storage_list">
        <tr>
          <td>No.</td>
          <td>작품코드</td>
          <td>지역</td>
          <td>보관소</td>
          <td>일정</td>
          <td>배송</td>
          <td>결제금액</td>
        </tr>
        <tr>
          <td>1</td>
          <td>A1205</td>
          <td>대구</td>
          <td>북구 검단로 50 Arario아트센터</td>
          <td>2022-07-18 ~ 2022.07.25</td>
          <td>YES</td>
          <td>150,000</td>
        </tr>
      </table>
    </div>
  </div>
</body>

</html>