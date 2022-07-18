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
  <link rel="stylesheet" href="../design/css_artists/style.css">
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

    <!-- 작가페이지 -->
    <div class="headline_artworks">
      <h3>ARTISTS</h3>
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
          <a href="#"><img src="../design/img/JoJeongA/some_night.jpg" alt="some_night"></a>
          <a href="#"><img src="../design/img/JoJeongA/life_colour.jpg" alt="life_colour"></a>
          <a href="#"><img src="../design/img/JoJeongA/love_your_self.jpg" alt="love_your_self"></a>
          <a href="#"><img src="../design/img/JoJeongA/성냥줍는사람.jpg" alt="성냥줍는사람"></a>
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
          <a href="#"><img src="../design/img/BobTakes/Brut1.JPG" alt="Brut1"></a>
          <a href="#"><img src="../design/img/BobTakes/Dividivi.JPG" alt="Dividivi"></a>
          <a href="#"><img src="../design/img/BobTakes/N15W88.JPG" alt="N15W88"></a>
          <a href="#"><img src="../design/img/BobTakes/OceanSlice.JPG" alt="OceanSlice"></a>
        </div>
      </div>
    </div>
  </div>
</body>
</html>