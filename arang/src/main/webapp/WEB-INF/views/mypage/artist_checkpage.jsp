<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/fake_resources/css/default/normalize.css">
<link rel="stylesheet" href="/fake_resources/css/default/default.css">
<link rel="stylesheet" href="/fake_resources/css/default/header.css">
<link rel="stylesheet" href="/fake_resources/css/mypage/gallery_upload.css">
<link rel="stylesheet" href="/fake_resources/css/artist/artist_focus.css">
<script type="text/javascript" src="/fake_resources/js/common.js"></script>
</head>
<body>
<div id="wrap">
<jsp:include page="/WEB-INF/views/header/header_main.jsp"/>


<div class="headline">
      <h3>ARTIST PAGE</h3>
      <div class="sub-txt">
        샘플과 같은 자신만의 페이지를 만들어보세요!
      </div>
    </div>

    <!-- 아티스트상세페이지 -->
    <div id="artist">
      <div id="artist_detail">
        <div class="container">
          <div class="detail_wrapper d-flex">
            <div class="side_block">
            </div>
            <div class="content_block">
              <div class="review">
                <h2>${artistInfo.title}</h2>
                <p>${artistInfo.description}</p>
                <p><br></p>
                <p>
                  <img src="${artistInfo.infoImgPath}" alt="artist_main">
                </p>
              </div>
            </div>
            <div class="side_block hidden">
              <div class="a_list">
                <!-- <h3>추천작가</h3> -->
                <ul>
                  <li>
                    <!-- <a href="#">신수희</a> -->
                  </li>
                  <li>
                    <!-- <a href="#">최선호</a> -->
                  </li>
                </ul>
              </div>
              <div class="a_banner">
                <!-- <h3>이달의 전시</h3>
                <a href="#"><img class="exhibition_banner" src="../../resources/img/김선배너.jpg" alt="exhibition_banner"></a> -->
              </div>
            </div>
          </div>
              <div class="btn_group2">
                <a href="/arang/mypage/mypage_artist"><button class="btn2 modify">확인</button></a>
              </div>
        </div>
      </div>
      

    </div>

</div>
</body>
</html>