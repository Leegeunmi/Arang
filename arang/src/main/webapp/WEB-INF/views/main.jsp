<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix ="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">
<link rel="stylesheet" href="/fake_resources/css/default/normalize.css">
<link rel="stylesheet" href="/fake_resources/css/default/default.css">
<link rel="stylesheet" href="/fake_resources/css/artist/artist.css">
<link rel="stylesheet" href="/fake_resources/css/main/main.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper/swiper-bundle.min.css"/>
<script type="text/javascript" src="/fake_resources/js/jquery.js"></script>
<script type="text/javascript" src="/fake_resources/js/common.js"></script>
</head>
<body>
  <div id="wrap">
    <jsp:include page="/WEB-INF/views/header/header_main.jsp"/>

<div class="headline top">
      <p>Promising artworks</p>
      <p>Look at the amazing artworks of the new artists of the month.</P>
    </div>
    <div id="slidebanner">
      <div id="carousel-wrap">
        <div id="carousel">
          <!--화면에 보여지는 영역-->
          <div  class="swiper mySwiper2">
            <ul class=" swiper-wrapper">
            <c:forEach var="artistL" items="${artistList1}">
              <c:forEach var="artworkL" items="${artworkList}" begin="1">
                  <li class="swiper-slide">
                    <a href="/arang/artwork_board/artwork_info?id=${artistL.aid}&wid=${artworkL.wid}">
                    	<img src="${artworkL.artworkImgPath}" style="width: 200px; height: 200px">
                    </a>
                  </li>
  				</c:forEach>
  			</c:forEach>
            </ul>
          </div>
        </div>
      </div>
    </div>
    <!-- 아티스트섹션 -->
    <div id="artist">
      <form id="artist_form">
        <div class="container artists">
          <div class="sub_page_top">
            <div class="headline">
              <p>Artist of the month</p>
              <p>Artist of the month! Look at their artworks.</P>
            </div>
            <div class="row">
            
            <c:forEach var="artistL" items="${artistList1}" begin="0" end="1">
            <div class="col_wrap"> 
  			<div class="swiper mySwiper col col-1">
                <div class="artist_info d-flex flex-row">
                  <div class="artist_avatar">
                    <a href="/arang/artist_board/artist_depth?id=${artistL.aid}"><img src="${artistL.imgPath}" ></a>
                  </div>
                  <div class="artist_text">
                    <div class="first">
                      <span>${artistL.name_kor}</span>
                      <span class="futuraM">${artistL.name_eng}</span>
                      <c:forTokens var="genre" items="${artistL.genre}" delims=";">
                        <span class="genre_tag">${genre}</span>
                      </c:forTokens>
                    </div>
                    <div class="second d-flex flex-row">
                      <div>${artistL.title}</div>
                    </div>
                  </div>
                </div>
                <div class="row artwork_wrap swiper-wrapper">
  				<c:forEach var="artworkL" items="${artworkList}">
  				<c:if test="${artistL.aid == artworkL.artistId}">
                  <div class="col swiper-slide">
                    <a href="/arang/artwork_board/artwork_info?id=${artistL.aid}&wid=${artworkL.wid}">
                    	<img class="artwork small" src="${artworkL.artworkImgPath}">
                    </a>
                  </div>
  				</c:if>
  				</c:forEach>
                </div>
              	</div>
              </div>
  			</c:forEach>
              
            </div>
          </div>
        </div>
      </form>
    </div>

    <!-- 전시섹션 -->
    <div class="headline">
      <p>EXHIBITIONS</p>
      <p>Enjoy the exhibition of artists!</P>
    </div>
    <div class="exhibition">
      <div class="exhibition_wrapper">
        <div class="exhibition_view">
          <div class="img_wrapper">
            <a href="/arang/main"><img src="/fake_resources/img/exhibition/exhibition2.jpg" alt="exhibition2"></a>
          </div>
          <p>김보희 개인전</p>
          <p class="date">2022.08.20~09.20</p>
        </div>
        <div class="exhibition_view">
          <div class="img_wrapper">
            <a href="/arang/main"><img src="/fake_resources/img/exhibition/exhibition1.jpg" alt="exhibition1"></a>
          </div>
          <p>He was Just a funny Boy</p>
          <p class="date">2022.08.20~09.20</p>
        </div>
        <div class="exhibition_view">
          <div class="img_wrapper">
            <a href="/arang/main"><img src="/fake_resources/img/exhibition/exhibition3.jpg" alt="exhibition3"></a>
          </div>
          <p>유영국 개인전</p>
          <p class="date">2022.08.20~09.20</p>
        </div>
      </div>
    </div>

    <!-- 갤러리섹션 -->
    <div class="headline gallery">
      <p>GALLERYS</p>
      <p>The best place for artists and people to communicate through their artworks.</P>
    </div>
    <div id="artist">
      <form id="artist_form">
        <div class="container gallerys">
          <!-- 아티스트 -->
          <div class="sub_page_context">
            <div class="grid_wrapper">
              <div class="row artist_list">
              <c:forEach var="gallery" items="${galleryList}" begin="0" end="2">
                <div class="col artist_item">
                  <div class="artist_info d-flex flex-row">
                    <div class="artist_avatar">
                      <a href="/arang/gallery/gallery_focus?code=${gallery.code}">
                      	<img src="${gallery.galleryImgPath}">
                      </a>
                    </div>
                    <div class="artist_text">
                      <div class="first">
                        <span>${gallery.galleryName_eng}</span>
                      </div>
                      <div class="second d-flex flex-row">
                        <div>${gallery.address}</div>
                      </div>
                    </div>
                  </div>
                  <div class="banner_wrap">
                    <a href="#">
                      <div class="artwork_banner">
                        <a href="/arang/gallery/gallery_focus?code=${gallery.code}">
                        	<img src="${gallery.infoImgPath}" alt="2">
                        </a>
                      </div>
                    </a>
                  </div>
                </div>
              </c:forEach>
                </div>
            </div>
          </div>

        </div>
      </form>
    </div>
    

  </div>
  <!-- Swiper JS -->
    <script src="https://cdn.jsdelivr.net/npm/swiper/swiper-bundle.min.js"></script>

    <!-- Initialize Swiper -->
    <script>
      var swiper = new Swiper(".mySwiper", {
    	autoplay: {
    		  delay: 5000,
    		  disableOnInteraction: false,
    		},
        slidesPerView: 3,
        spaceBetween: 0,
        pagination: {
          el: ".swiper-pagination",
          clickable: true,
        },
        navigation: {
          nextEl: ".swiper-button-next",
          prevEl: ".swiper-button-prev",
        },
      });
      
      var swiper = new Swiper(".mySwiper2", {
      	autoplay: {
      		  delay: 5000,
      		  disableOnInteraction: false,
      		},
          slidesPerView: 6,
          spaceBetween: 1,
          pagination: {
            el: ".swiper-pagination",
            clickable: true,
          },
        });
      
      
      
    </script>
</body>
</html>