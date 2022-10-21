<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Arang</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">
<link rel="stylesheet" type="text/css" href="/fake_resources/css/default/normalize.css">
<link rel="stylesheet" type="text/css" href="/fake_resources/css/default/default.css">
<link rel="stylesheet" type="text/css" href="/fake_resources/css/default/header.css">
<link rel="stylesheet" type="text/css" href="/fake_resources/css/storage/storage.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<div id="wrap">
	<!-- Header -->
	<jsp:include page="/WEB-INF/views/header/header_main.jsp"/>
	<!-- /Header -->
<div class="headline">
      <h3>STORAGE</h3>
      <nav id="sub-nav">
        <ul>
          <li>Keeping your artworks conveniently and safely!</li>
        </ul>
      </nav>
    </div>
    <div class="contents">
    <div class="contents_box">
      <div class="contents_inner">
        <div class="about_txt">
          <h3>당신의 소중한 작품 한 점 한 점을 안전하게 보관할 수 있는 최적의 보관 공간을 제공해 드립니다.</h3>
          <div class="about_box">
            <div class="about_box1">
              <div class="left">
                <img src="/fake_resources/img/icon/calendar.png">
                <p>원하는 지역 및 장소 선택</p>
                <p>원하는 기간 동안 보관</p>
                <p>운송서비스 선택</p>
              </div>
              <div class="right">
                <img src="/fake_resources/img/icon/warehouse.png">
                <p>항온.항습 수장고</p>
                <p>24시간 CCTV 운영</p>
                <p>전문가들의 보관 관리</p>
              </div>
            </div>
            <div class="about_box2">
              <img src="/fake_resources/img/storage/작품보관5.jpg">
              <img src="/fake_resources/img/storage/작품보관3.jpg">
              <img src="/fake_resources/img/storage/작품보관1.jpg">
            </div>
            <div class="about_box2 box3">
              <img src="/fake_resources/img/storage/작품운송4.jpg">
              <img src="/fake_resources/img/storage/작품운송2.jpg">
              <img src="/fake_resources/img/storage/작품운송.jpg">
            </div>
          </div>
          <!-- <p>지금 바</p> -->
        </div>
    <div class="btn2_group">
    <form class="form_inline" action="storage_add" method="get">
     <button class="btn2" type="submit">보관신청</button>
    </form>
	<form class="form_inline" action="storage_artist" method="post">
    <button class="btn2" type="submit">내 보관리스트</button>
    </form>      
    <form class="form_inline" action="storage_admin" method="post">
    <button class="btn2" type="submit">관리자페이지(임시)</button>
    </form>
    </div>
      </div>
    </div>
    </div>
</body>
</html>
