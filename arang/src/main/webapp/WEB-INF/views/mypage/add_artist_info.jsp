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
<link rel="stylesheet" href="/fake_resources/css/mypage/artwork_upload.css">
<link rel="stylesheet" href="/fake_resources/css/mypage/gallery_upload.css">
<link rel="stylesheet" href="/fake_resources/css/artist/artist_focus.css">
<script type="text/javascript" src="/fake_resources/js/common.js"></script>
<style>

.ck-editor__editable { 
  height: 300px; 
  width: 815px; 
  background-color: #f5f5f5;
}
</style>
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
<form action="add_artist_info" method="post" enctype="multipart/form-data">
    <div id="artist">
      <div id="artist_detail">
        <div class="container">
          <div class="detail_wrapper d-flex">
            <div class="side_block">
              <div class="artist_info">
              </div>
            </div>
            <div class="content_block">
              <div class="review">
                <h2><input type="text" name="title" placeholder="타이틀"></h2>
                <p><textarea id="editor" class="textarea_box" name="description" placeholder="작가 소개" cols="43" rows="7"></textarea></p>
                <p><br></p>
                <p>
                <div class="upload_box">
                  <input type="file" id="input-file" name="imgFile"/>
                </div>
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
          <div class="btn_group2 artist">
            <a href="../../html_mypage/artist/artist_checkpage.html"><button class="btn2" type="submit">저장</button></a>
            <a href="../../html_mypage/artist/artist_checkpage.html"><button class="btn2">취소</button></a>
          </div>
        </div>
      </div>
    </div>
    </form>
    </div>
<script src="https://cdn.ckeditor.com/ckeditor5/35.0.1/classic/ckeditor.js"></script>
<script>
  ClassicEditor.create( document.querySelector( '#editor' ) );
</script>
</body>
</html>