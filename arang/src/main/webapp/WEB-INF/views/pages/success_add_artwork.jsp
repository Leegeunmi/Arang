<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="ko">

<head>
  <title>아티스트상세페이지</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">
<link rel="stylesheet" type="text/css" href="/fake_resources/css/default/normalize.css"/>
<link rel="stylesheet" type="text/css" href="/fake_resources/css/default/default.css"/>
<link rel="stylesheet" href="/fake_resources/css/artwork/artwork_focus.css">
<link rel="stylesheet" href="/fake_resources/css/mypage/artwork_upload.css">
<script type="text/javascript" src="/fake_resources/js/common.js"></script>
</head>

<body>
  <div id="wrap">
    <jsp:include page="/WEB-INF/views/header/header.jsp"/>
    <!-- 아티스트상세페이지 -->
<div id="artwork">
      <div id="artwork_detail">
        <div class="container">
          <div class="artwork_simul">
            <div class="artwork_wrapper">
              <div class="artwork_view">
                <div class="img_wrapper">
                  <div class="paintings">
                    <img class="artwork" src="${artwork.artworkImgPath}" onload="JavaScript:artwork_large(this)">
                  </div>
                </div>
              </div>
              <div class="artwork_info_wrap">
                <div class="artwork_info">
                  <h2>${artwork.name}</h2>
                  <div class="info">
                    <div class="info_block">
                      <div class="first">장르(Genre)</div>
                      <div class="last">
                        <a href="../html_artist/artist.html">${artwork.genre}</a>
                      </div>
                    </div>
                    <div class="info_block">
                      <div class="first">기법(Technique)</div>
                      <div class="last">${artwork.technique}</div>
                    </div>
                    <div class="info_block">
                      <div class="first">크기(Size)</div>
                      <div class="last">${artwork.size}</div>
                    </div>
                    <div class="info_block">
                      <div class="first">년도(Year)</div>
                      <div class="last">2018</div>
                    </div>
                    <div class="info_block2">
                      <div class="first">설명(Description)</div>
                      <div class="last">${artwork.description}</div>
                    </div>
                  </div>
                </div>
                
              </div>
            </div>
          </div>
          <!-- 상세 내용 -->
          <section>
            <div class="a_title">
              <div class="first">
                ${artworkInfo.mainTitle }
              </div>
              <div class="second">
                ${artworkInfo.subTitle }
              </div>
            </div>
            <div class="a_artwork">
            	<img class="artwork" src="${artworkInfo.workInfoImgPath}" alt="오브제1">
            </div>
          </section>
      		<div class="btn_group2">
         		<button href="/arang/mypage/mypage_artist" class="btn1" type="button">마이페이지</button>
      		</div>
        </div>
      </div>
    </div>
    </div>
</body>
</html>