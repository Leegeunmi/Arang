<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/fake_resources/css/default/normalize.css"/>
<link rel="stylesheet" type="text/css" href="/fake_resources/css/default/default.css"/>
<link rel="stylesheet" href="/fake_resources/css/artwork/artwork_focus.css">
<link rel="stylesheet" href="/fake_resources/css/mypage/artwork_upload.css">
<script>
cnt = 0;
const add_textbox = () => {
	if ( cnt < 2 ) {
		const box = document.getElementById("box2");
		const newP = document.createElement('tr');
		newP.innerHTML = "<div class='upload_box'> <input type='file' name='imgFile'>"
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
<style>
  .ck-editor__editable { height: 220px; }
</style>
</head>
<body>
<div id="wrap">
	<jsp:include page="/WEB-INF/views/header/header_main.jsp"/>

	<div class="headline_artworks">
      <h3>ARTWORK UPLOAD</h3>
      <div class="sub-txt">
        작품 등록을 위해 아래 양식을 채워주세요!
      </div>
	</div>
<!-- 아트워크 상세 -->
<form:form method="post" modelAttribute="artwork" enctype="multipart/form-data">
    <div id="artwork">
      <div id="artwork_detail">
        <div class="container">
        
          <div class="artwork_simul">
            <div class="artwork_wrapper">
              <div class="artwork_view">
                <div class="img_wrapper">
                  <div class="paintings">
                    <input type="file" name="imgFile">
                  </div>
                </div>
              </div>
              <div class="artwork_info_wrap">
                <div class="artwork_info">
                  <h2><form:input path="name" placeholder="작품명"/></h2>
                  <div class="info">
                    <div class="info_block">
                      <div class="first">작가명(Name)</div>
                      <div class="last">
                        ${artist.name_kor} ${artist.name_eng}
                      </div>
                    </div>
                    <div class="info_block">
                      <div class="first">장르(Genre)</div>
                      <div class="last">
                        <form:select class="box" path="genre">
							<option value="unknown">장르선택</option>
							<form:options items="${artCategoryProvicerList}"/>
						</form:select>
                      </div>
                    </div>
                    <div class="info_block">
                      <div class="first">기법(Technique)</div>
                      <form:input path="technique" placeholder="ex) 아크릴(Acrylic)"/>
                    </div>
                    <div class="info_block">
                      <div class="first">크기(Size)</div>
                      <form:input path="size" placeholder="ex) 21x11cm"/>
                    </div>
                    <div class="info_block">
                      <div class="first">년도(Year)</div>
                      <form:input path="publicationDate" placeholder="ex) 2018"/>
                    </div>
                    <div class="info_block2">
                      <div class="first">설명(Description)</div>
                      <div class="last">
                        <form:textarea id="editor" path="description"  placeholder="작품설명 300자 이내" cols="43" rows="7"/>
                      </div>
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
                <input type="text" name="mainTitle" placeholder="ex) 물성을 살려 단순함을 끌어내는 것 (메인 타이틀)">
              </div>
              <div class="second">
                <input type="text" name="subTitle" placeholder="ex) 날 것 그대로의 본질에 우연적 효과를 불어넣다. (서브 타이틀)">
              </div>
            </div>
            <div class="a_artwork">
              	<div id="box2">
              	<input type="button" value="추가" onclick="add_textbox()">
              		<div class="upload_box">
         		  		 <input type="file" name="imgFile">
              		</div>
        		</div>
            </div>
            <div class="a_desc">
              <h4 class="sub_title">Artist</h4>
              <h3>${artist.name_kor}</h3>
              <p class="e_name">${artist.name_eng}</p>
              <p class="born">1984</p>
              <p class="txt">${artist.description}</p>
            </div>
          </section>
      <div class="btn_group2">
        <button class="btn2" type="submit">완료</button>
      <a href="/arang/mypage/mypage_artist">
        <button class="btn2" type="button">취소</button>
      </a>
      </div>
    </div>
        </div>
      </div>


</form:form>
</div>
<script src="https://cdn.ckeditor.com/ckeditor5/35.0.1/classic/ckeditor.js"></script>
<script>
  ClassicEditor.create( document.querySelector( '#editor' ) );
</script>
</body>
</html>