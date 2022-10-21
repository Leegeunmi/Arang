<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">
  <title>갤러리상세업로드</title>
	<link rel="stylesheet" type="text/css" href="/fake_resources/css/default/normalize.css"/>
  <link rel="stylesheet" type="text/css" href="/fake_resources/css/default/default.css"/>
  <link rel="stylesheet" type="text/css" href="/fake_resources/css/artist/artist_focus.css">
  <link rel="stylesheet" type="text/css" href="/fake_resources/css/gallery/gallery_focus.css">
  <link rel="stylesheet" type="text/css" href="/fake_resources/css/mypage/artwork_upload.css">
  <link rel="stylesheet" type="text/css" href="/fake_resources/css/mypage/gallery_upload.css">
</head>
<style>
  .ck-editor__editable { height: 300px; width: 815px; }
</style>
<script>
cnt = 0;
const add_textbox = () => {
	if ( cnt < 2 ) {
		const box = document.getElementById("box2");
		const newP = document.createElement('tr');
		newP.innerHTML = "<div class='upload_box'> <input type='file' id='input-file' name='imgName2' multiple>"
		+ "</div> <br> <input type='button' value='삭제' onclick='remove(this)'>";
		box.appendChild(newP);
		cnt++;
	}
}
const remove = (obj) => {
    document.getElementById('box2').removeChild(obj.parentNode);
    cnt--;
}
</script>

<body>
  <div id="wrap">
  
  <jsp:include page="/WEB-INF/views/header/header_main.jsp"/>

    <div class="headline_artworks">
      <h3>GALLERY PAGE</h3>
      <div class="sub-txt">
        아래 양식을 채워 갤러리 페이지를 만드세요!
      </div>
    </div>

    <!-- 갤러리상세페이지 -->
    <form action="gallery_upload" method="post" enctype="multipart/form-data">
    <div id="artist">
      <div id="artist_detail">
        <div class="container">
          <div class="detail_wrapper d-flex">
            <div class="side_block">
              <div class="artist_info">
                <div class="input_box_left">
                  <input type="text" placeholder="갤러리이름(한글)" name="galleryName_kor">
                  <input type="text" placeholder="갤러리이름(영문)" name="galleryName_eng">
                  <input type="text" placeholder="년도 ex)2002" name="since">
                  <div class="artist_avatar">
                    <input type="file" id="input-file" name="imgName2" multiple>
                    <!-- <img src="../resources/img/gallerys/2.jpg" alt="2"> -->
                  </div>
                </div>
              </div>
            </div>
            <div class="content_block">
              <div class="review">
                <p><textarea id="editor" class="textarea_box" placeholder="갤러리 소개" cols="43" rows="7" name="description"></textarea></p>
                <p><br></p>
                <p>
                <div id="box2">
              	<input type="button" value="추가" onclick="add_textbox()">
              		<div class="upload_box">
         		  		 <input type="file" id="input-file" name="imgName2" multiple>
              		</div>
        		</div>
                </p>
              </div>
              <div class="product">
                <h4 class="sub_title">Gallery Infomation</h4>
                <div class="artwork_simul">
                  <div class="artwork_wrapper">
                    <div class="artwork_info_wrap">
                      <div class="artwork_info">
                        <div class="info">
                          <div class="info_block">
                            <div class="first">주소(Address)</div>
                            <div class="last">
                              <input type="text" placeholder="주소" name="address">
                            </div>
                          </div>
                          <div class="info_block">
                            <div class="first">크기(Size)</div>
                            <div class="last">
                              <input type="text" placeholder="ex) 전시면적 900㎡ / 9층" name="area">
                            </div>
                          </div>
                          <div class="info_block">
                            <div class="first">시간(Hours)</div>
                            <div class="last">
                              <input type="text" placeholder="ex) 오전 11시 ~ 오후 6시 (월요일 휴관)" name="openClose">
                            </div>
                          </div>
                          <div class="info_block">
                            <div class="first">이메일(Email)</div>
                            <input type="text" placeholder="이메일" name="galleryEmail">
                          </div>
                          <div class="info_block">
                            <div class="first">전화번호(Phone)</div>
                            <input type="text" placeholder="전화번호" name="galleryPhone">
                           </div>
                            <br>
                           <div class="info_block">
                            <div class="first">사업주명</div>
                            <input type="text" placeholder="사업자명" name="representer">
                           </div>
                            <br>
                           <div class="info_block">
                            <div class="first">사업자등록번호</div>
                            <input type="text" placeholder="사업자등록번호(ex)123-45-67890)" name="representerNum">
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    <div class="btn_group2">
      <input type="submit" class="btn2" value="완료">
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
