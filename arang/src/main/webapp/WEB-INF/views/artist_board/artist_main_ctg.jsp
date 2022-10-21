<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="ko">

<head>
  <title>아티스트페이지</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">
  <link rel="stylesheet" type="text/css" href="/fake_resources/css/default/normalize.css"/>
  <link rel="stylesheet" type="text/css" href="/fake_resources/css/default/default.css"/>
  <link rel="stylesheet" type="text/css" href="/fake_resources/css/artist/artist.css"/>
  <link rel="stylesheet" type="text/css" href="/fake_resources/css/swiper/swiper.css"/>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper/swiper-bundle.min.css"/>
  <script type="text/javascript" src="/fake_resources/js/jquery.js"></script>
  <script type="text/javascript" src="/fake_resources/js/slidebanner.js"></script>
  
</head>

<body>
<div id="wrap">
  <jsp:include page="/WEB-INF/views/header/header.jsp"/>
  	<button href="#" class="testBtn">테스트버튼</button>
    <div id="artist">
      <form id="artist_form">
        <div class="container">
          <!-- 아티스트 -->
          <div class="sub_page_context">
            <div class="grid_wrapper">
              <h5 class="sub_title">Artists<small>${artistCount}</small></h5>
              <div class="row artist_list">
              
                <c:forEach var="artworkPage" items="${artistPagingList.content}">
                <div class="col artist_item ${artworkPage.genre}">
                  <div class="artist_info d-flex flex-row">
                    <div class="artist_avatar">
                      <a href="/arang/artist_board/artist_depth?id=${artworkPage.aid}"><img src="${artworkPage.imgPath}"></a>
                    </div>
                    <div class="artist_text">
                      <div class="first">
                        <span>${artworkPage.name_kor}</span>
                        <c:forTokens var="genre" items="${artworkPage.genre}" delims=";">
                        <span class="genre_tag">${genre}</span>
                        </c:forTokens>
                      </div>
                      <div class="second d-flex flex-row">
                        <div>날 것 그대로의 본질에 우연적 효과를 불어넣다.</div>
                      </div>
                    </div>
                  </div>
                  <div class="banner_wrap">
                    <a href="/arang/artwork_board/artwork_info?id=${artworkPage.aid}&wid=${artworkPage.wid}">
                      <div class="artwork_banner">
  							<img class="artwork" src="${artworkPage.artworkImgPath}">
                      </div>
                    </a>
                  </div>
                </div>
                </c:forEach>
              </div>
              <!-- ===================== 페이징 처리 부분 ========================== -->
              <div class="toolbox">
      <ul class="pagination">
         <!-- 시작 -->
         <c:choose>
            <c:when test="${artistPagingList.first}"></c:when>
            <c:otherwise>
               <li class="page_item"><a class="page_link" href="<c:url value='/artist_board/artist_main?page=0'/>">처음</a></li>
					<li class="page_item"><a class="page_link" href="<c:url value='/artist_board/artist_main?page=${artistPagingList.number-1}'/>">&larr;</a></li>
            </c:otherwise>
         </c:choose>
         <!-- 페이지 그룹 -->
         <c:forEach begin="${startBlockPage}" end="${endBlockPage}" var="i">
            <c:choose>
               <c:when test="${artistPagingList.pageable.pageNumber+1 == i}">
                  <li class="page_item disabled"><a class="page_link pick_num" href="<c:url value='/artist_board/artist_main?page=${i-1}'/>">${i}</a></li>
               </c:when>
               <c:otherwise>
                  <li class="page_item"><a class="page_link" href="<c:url value='/artist_board/artist_main?page=${i-1}'/>">${i}</a></li>
               </c:otherwise>
            </c:choose>
         </c:forEach>
         <!-- 끝 -->
         <c:choose>
            <c:when test="${artistPagingList.last}"></c:when>
            <c:otherwise>
               <li class="page_item"><a class="page_link" href="<c:url value='/artist_board/artist_main?page=${artistPagingList.number+1}'/>">&rarr;</a></li>
					<li class="page_item"><a class="page_link" href="<c:url value='/artist_board/artist_main?page=${artistPagingList.totalPages-1}'/>">마지막</a></li>
            </c:otherwise>
         </c:choose>
      </ul>
   </div>
   
              
              
              <!-- ===================== 페이징 처리 부분 ========================== -->
            </div>
          </div>

        </div>
      </form>
    </div>

    <!-- 작가 -->

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
      
      
      
      
      
    </script>
</body>

</html>
