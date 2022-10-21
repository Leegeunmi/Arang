<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">
<title>Insert title here</title>
<link rel="stylesheet" href="/fake_resources/css/default/normalize.css">
<link rel="stylesheet" href="/fake_resources/css/default/default.css">
<link rel="stylesheet" href="/fake_resources/css/default/header.css">
<link rel="stylesheet" href="/fake_resources/css/main/main.css">
<link rel="stylesheet" href="/fake_resources/css/artist/artist.css">
<link rel="stylesheet" href="/fake_resources/css/exhibition/exhibition.css">
<link rel="stylesheet" href="/fake_resources/css/exhibition/exhibition_focus.css">
</head>
<body>
  <div id="wrap">
  
  <jsp:include page="/WEB-INF/views/header/header_main.jsp"/>
<div class="headline">
      <h3>EXHIBITIONS</h3>
      <nav id="sub-nav">
        <ul>
          <li>Enjoy the exhibition of artists!</li>
        </ul>
      </nav>
    </div>
    <div class="exhibition">
      <div class="exhibition_wrapper1">
        <img class="first" src="/fake_resources/img-2/exhibition/KimBoHei/1.jpg">
      </div>
      <div class="info_txt">
        <h3>THE DAYS</h3>
        <p class="title">김보희 개인전</p>
        <p class="date">2022.08.20~09.20</p>
      </div>
      <div class="exhibition_wrapper2">
        <img src="/fake_resources/img-2/exhibition/KimBoHei/2.jpg">
        <div class="sub_box">
          <p class="sub">쉼에서 움트는 생명력 가득한 풍경들</p>
          <p class="sub">The lifelike landscapes of rest</p>
        </div>
      </div>
      <div class="exhibition_wrapper3">
        <div class="sub_box">
          <p class="sub">정적이면서도 흐르는 분위기 속 느껴지는 깊은 고요</p>
          <p class="sub">The deep silence felt in the flowing mood is still</p>
          <div class="info_txt second">
            <h3>Kim, Bo Hei</h3>
            <p class="date">김보희 개인전 2022.08.20~09.20 제주현대미술관</p>
          </div>
        </div>
        <img src="/fake_resources/img-2/exhibition/KimBoHei/3.jpg">
      </div>
      <img class="work6" src="/fake_resources/img-2/exhibition/KimBoHei/4.jpg">
      <div class="exhibition_wrapper4">
        <img src="/fake_resources/img-2/exhibition/KimBoHei/5.jpg">
        <img src="/fake_resources/img-2/exhibition/KimBoHei/6.jpg">
      </div>
      <div class="exhibition_wrapper5">
        <div class="info_txt">
          <h3>THE DAYS</h3>
          <p class="title">김보희 개인전</p>
          <p class="date">Kim, Bo Hie</p>
        </div>
        <div class="info_txt">
          <h3 class="middle">2022.08.20~09.20</h3>
        </div>
        <div class="info_txt">
          <h3 class="middle">제주현대미술관</h3>
          <p class="date">Jeju museum of contemporary art</p>
        </div>
      </div>
      <div id="artist">
        <form id="artist_form">
          <div class="container">
            <div class="sub_page_context">
              <div class="grid_wrapper">
                <h5 class="sub_title">INVOLVED</h5>
                <div class="row artist_list">
                  <div class="col artist_item">
                    <div class="artist_info d-flex flex-row">
                      <div class="artist_avatar">
                        <a href="#"><img src="/fake_resources/img-2/artist/KimBoHei/profile.jpg" alt="김보희"></a>
                      </div>
                      <div class="artist_text">
                        <div class="first">
                          <span>김보희</span>
                          <span class="futuraM">Kim, Bo Hei</span>
                          <span class="genre_tag">Painter</span>
                        </div>
                        <div class="second d-flex flex-row">
                          <div>모성애를 담은 자연</div>
                        </div>
                      </div>
                    </div>
                    <div class="banner_wrap">
                      <a href="#">
                        <div class="artwork_banner">
                          <img src="/fake_resources/img-2/artist/KimBoHei/artist_detail.jpg">
                        </div>
                      </a>
                    </div>
                  </div>
                  <div class="col artist_item">
                    <div class="artist_info d-flex flex-row">
                      <div class="artist_avatar">
                        <a href="#"><img src="/fake_resources/img-2/gallery/jeju_museum/profile.jpg"></a>
                      </div>
                      <div class="artist_text">
                        <div class="first">
                          <span>Jeju museum of contemporary art</span>
                        </div>
                        <div class="second d-flex flex-row">
                          <div>제주도 제주시 한경면 저지14길 35</div>
                        </div>
                      </div>
                    </div>
                    <div class="banner_wrap">
                      <a href="#">
                        <div class="artwork_banner">
                          <img src="/fake_resources/img-2/gallery/jeju_museum/detail.jpg">
                        </div>
                      </a>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </form>
      </div>
    </div>
</div>
</body>
</html>