<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>artists_all</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">
  <link rel="stylesheet" href="../design/css_main/normalize.css">
  <link rel="stylesheet" href="../design/css_main/default.css">
  <link rel="stylesheet" href="../design/css_default/header.css">
  <link rel="stylesheet" href="../design/css_gallerys/style.css">
</head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
        <!-- 갤러리페이지 -->
    <div class="headline_artworks">
      <h3>Gallerys</h3>
      <nav id="sub-nav">
        <ul>
          <li><a href="./gallerys/all.html">All</a></li>
          <li><a href="#">서울/경기</a></li>
          <li><a href="#">강원</a></li>
          <li><a href="#">대전</a></li>
          <li><a href="#">광주</a></li>
          <li><a href="#">대구</a></li>
          <li><a href="#">부산</a></li>
          <li><a href="#">울산</a></li>
          <li><a href="#">제주</a></li>
        </ul>
      </nav>
    </div>
    <div id="gallerys_wrap">
      <div class="box">
        <div class="photobox">
          <img src="../design/img/gallerys/g1.png" alt="ArarioGallery">
          <p>ARARIO Gallery</p>
          <p>Jongno-gu,Seoul,Korea</p>
        </div>
        <div class="photobox">
          <img src="../design/img/gallerys/g3.png" alt="LeeSeoulGallery">
          <p>LeeSeoul Gallery</p>
          <p>Mapo-gu,Seoul,Korea</p>
        </div>
        <div class="photobox">
          <img src="../design/img/gallerys/g2.png" alt="BaudoinLebon">
          <p>Baudoin Lebon</p>
          <p>Jongno-gu,Seoul,Korea</p>
        </div>
        <div class="photobox">
          <img src="../design/img/gallerys/g4.png" alt="GallerySunContemporary">
          <p>Gallery Sun contemporary</p>
          <p>Mapo-gu,Seoul,Korea</p>
        </div>
      </div>
    </div>
  </div>
</body>
</html>