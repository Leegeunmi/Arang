<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ko">
<head>
  <title>main</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">
  <link rel="stylesheet" href="../design/css_main/normalize.css">
  <link rel="stylesheet" href="../design/css_main/default.css">
  <link rel="stylesheet" href="../design/css_main/style.css">
  <script type="text/javascript" src="../design/js_main/jquery.js"></script>
  <script type="text/javascript" src="../design/js_main/slidebanner.js"></script>
</head>

<body>
  <div id="wrap">
    <header id="header">
      <div class="inner">
        <!-- 로고 -->
        <h1 id="top-logo">
          <a href="/medici/signup/mypage.jsp">ARANG</a>
        </h1>
        <!-- 메인메뉴 -->
        <nav id="top-nav">
          <ul class="center_menu">
            <li><a href="../artists/all.html">Artists</a></li>
            <li><a href="../gallerys/gallerys.html">Gallerys</a></li>
            <li><a href="../exhibitions/exhibitions.html">Exhibitions</a></li>
            <li><a href="../storage/storage.html">Storage</a></li>
            <li><a href="../notice/notice.html">Notice</a></li>
          </ul>
          <ul class="side_menu">
            <li><a href="./find/find.html"><img src="../design/img/icon/find.png" alt="find"></a></li>
            <li><a href="./mypage/mypage.html"><img src="../design/img/icon/mypage.png" alt="mypage"></a></li>
            <li><a href="./like/like.html"><img src="../design/img/icon/like.png" alt="like"></a></li>
            <li><a href="./cart/cart.html"><img src="../design/img/icon/cart.png" alt="cart"></a></li>
          </ul>
        </nav>
      </div>
    </header>
    <!-- 작가페이지 -->
    <div class="headline_artworks">
      <h4>ARTISTS</h4>
      <nav id="sub-nav">
        <ul>
          <li><a href="./artists/all.html">All</a></li>
          <li><a href="./artists/Sculptor.html">Sculptor</a></li>
          <li><a href="./artists/Painter.html">Painter</a></li>
          <li><a href="./artists/OrientalPainter.html">OrientalPainter</a></li>
          <li><a href="./artists/DrawingArtist.html">DrawingArtist</a></li>
          <li><a href="./artists/Illustator.html">Illustator</a></li>
          <li><a href="./artists/DigitalArtist.html">DigitalArtist</a></li>
          <li><a href="./artists/Photographer.html">Photographer</a></li>
        </ul>
      </nav>
    </div>
    <div class="artists_box">
      <div class="header">
        <div class="header_inner">
          <h4>Jeong-a Jo</h4>
          <button type="button">Painter</button>
        </div>
      </div>
      <div class="works_inner">
        <div class="img_inner">
          <a href="#"><img src="./img/JoJeongA/some_night.jpg" alt="some_night"></a>
          <a href="#"><img src="./img/JoJeongA/life_colour.jpg" alt="life_colour"></a>
          <a href="#"><img src="./img/JoJeongA/love_your_self.jpg" alt="love_your_self"></a>
          <a href="#"><img src="./img/JoJeongA/성냥줍는사람.jpg" alt="성냥줍는사람"></a>
        </div>
      </div>
    </div>
    <div class="artists_box">
      <div class="header">
        <div class="header_inner">
          <h4>Bob-Takes</h4>
          <button type="button">Sculptor</button>
        </div>
      </div>
      <div class="works_inner">
        <div class="img_inner">
          <a href="#"><img src="./img/BobTakes/Brut1.jpg" alt="Brut1"></a>
          <a href="#"><img src="./img/BobTakes/Dividivi.jpg" alt="Dividivi"></a>
          <a href="#"><img src="./img/BobTakes/N15W88.jpg" alt="N15W88"></a>
          <a href="#"><img src="./img/BobTakes/OceanSlice.jpg" alt="OceanSlice"></a>
        </div>
      </div>
    </div>
  </div>
</body>

</html>