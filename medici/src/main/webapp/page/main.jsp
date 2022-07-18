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
  <link rel="stylesheet" href="../design/css_default/initial.css">
  <link rel="stylesheet" href="../design/css_default/initial.min.css">
  <link rel="stylesheet" href="../design/css_default/default.css">
  <link rel="stylesheet" href="../design/css_default/header.css">
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

    <!-- 상단배너 -->
    <div class="">

    </div>

    <!-- 작품섹션(슬라이드배너) -->
    <div class="headline artworks">
      <p>Promising artworks</p>
      <p>Look at the amazing artworks of the new artists of the month</P>
    </div>
    <div id="slidebanner">
      <div id="carousel-wrap">
        <p id="carousel-prev" class="button"><img src="../design/img/artworks/btn_prev.png" alt="prev"></p>
        <p id="carousel-next" class="button"><img src="../design/img/artworks/btn_next.png" alt="next"></p>
        <div id="carousel">
          <!--화면에 보여지는 영역-->
          <div id="carousel-inner">
            <!-- li*4>a[href="#"]>img[src=./img/photo$_thum.jpg] -->
            <ul class="column">
              <li><a href="#"><img src="../design/img/artworks/1.png" alt=""></a></li>
              <li><a href="#"><img src="../design/img/artworks/2.png" alt=""></a></li>
              <li><a href="#"><img src="../design/img/artworks/3.png" alt=""></a></li>
              <li><a href="#"><img src="../design/img/artworks/4.png" alt=""></a></li>
              <li><a href="#"><img src="../design/img/artworks/5.png" alt=""></a></li>
              <li><a href="#"><img src="../design/img/artworks/6.png" alt=""></a></li>
              <li><a href="#"><img src="../design/img/artworks/7.png" alt=""></a></li>
              <li><a href="#"><img src="../design/img/artworks/photo9_thum.jpg" alt=""></a></li>
              <li><a href="#"><img src="../design/img/artworks/photo10_thum.jpg" alt=""></a></li>
              <li><a href="#"><img src="../design/img/artworks/photo11_thum.jpg" alt=""></a></li>
              <li><a href="#"><img src="../design/img/artworks/photo12_thum.jpg" alt=""></a></li>
              <li><a href="#"><img src="../design/img/artworks/photo13_thum.jpg" alt=""></a></li>
              <li><a href="#"><img src="../design/img/artworks/photo14_thum.jpg" alt=""></a></li>
              <li><a href="#"><img src="../design/img/artworks/photo15_thum.jpg" alt=""></a></li>
              <li><a href="#"><img src="../design/img/artworks/photo16_thum.jpg" alt=""></a></li>
            </ul>
          </div>
        </div>
      </div>
    </div>

    <!-- 갤러리섹션 -->
    <div class="headline gallerys">
      <p>Creative space</p>
      <p>The best place for artists and people to communicate through their artworks</P>
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
  </div>
</body>

</html>