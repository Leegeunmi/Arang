<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">
  <title>갤러리페이지</title>
  <link rel="stylesheet" href="/fake_resources/css/default/normalize.css">
  <link rel="stylesheet" href="/fake_resources/css/default/default.css">
  <link rel="stylesheet" href="/fake_resources/css/default/header.css">
  <link rel="stylesheet" href="/fake_resources/css/artist/artist.css">
</head>

<body>
  <div id="wrap">
  
  <jsp:include page="/WEB-INF/views/header/header_main.jsp"/>

    <div class="headline">
      <h3>GALLERYS</h3>
      <nav id="sub-nav">
        <ul>
          <li><a href="/arang/gallery/gallery">All</a></li>
          <li><a href="/arang/gallery/gallery">Seoul</a></li>
          <li><a href="/arang/gallery/gallery">Gyeonggi</a></li>
          <li><a href="/arang/gallery/gallery">Deajeon</a></li>
          <li><a href="/arang/gallery/gallery">Daegu</a></li>
          <li><a href="/arang/gallery/gallery">Busan</a></li>
          <li><a href="/arang/gallery/gallery">Jeju</a></li>
          <li><a href="/arang/gallery/gallery">Other</a></li>
        </ul>
      </nav>
    </div>

    <!-- 갤러리 -->
    <div id="artist">
      <form id="artist_form">
        <div class="container">
          <div class="sub_page_context">
            <div class="grid_wrapper">
              <h5 class="sub_title">Gallerys<small>${galleryCount}</small></h5>
              <div class="row artist_list">
              <c:forEach var="gallery" items="${galleryPagingList.content}">
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
              <!-- ===================== 페이징 처리 부분 ========================== -->
              <div class="toolbox">
      <ul class="pagination">
         <!-- 시작 -->
         <c:choose>
            <c:when test="${galleryPagingList.first}"></c:when>
            <c:otherwise>
               <li class="page_item"><a class="page_link" href="<c:url value='/gallery/gallery?page=0'/>">처음</a></li>
					<li class="page_item"><a class="page_link" href="<c:url value='/gallery/gallery?page=${galleryPagingList.number-1}'/>">&larr;</a></li>
            </c:otherwise>
         </c:choose>
         <!-- 페이지 그룹 -->
         <c:forEach begin="${startBlockPage}" end="${endBlockPage}" var="i">
            <c:choose>
               <c:when test="${galleryPagingList.pageable.pageNumber+1 == i}">
                  <li class="page_item disabled"><a class="page_link pick_num" href="<c:url value='/gallery/gallery?page=${i-1}'/>">${i}</a></li>
               </c:when>
               <c:otherwise>
                  <li class="page_item"><a class="page_link" href="<c:url value='/gallery/gallery?page=${i-1}'/>">${i}</a></li>
               </c:otherwise>
            </c:choose>
         </c:forEach>
         <!-- 끝 -->
         <c:choose>
            <c:when test="${galleryPagingList.last}"></c:when>
            <c:otherwise>
               <li class="page_item"><a class="page_link" href="<c:url value='/gallery/gallery?page=${galleryPagingList.number+1}'/>">&rarr;</a></li>
					<li class="page_item"><a class="page_link" href="<c:url value='/agallery/gallery?page=${galleryPagingList.totalPages-1}'/>">마지막</a></li>
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

  </div>
</body>

</html>
