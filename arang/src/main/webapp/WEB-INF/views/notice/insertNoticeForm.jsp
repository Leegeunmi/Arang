<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="/fake_resources/css/default/normalize.css"/>
  <link rel="stylesheet" type="text/css" href="/fake_resources/css/default/default.css"/>
  <link rel="stylesheet" type="text/css" href="/fake_resources/css/artist/artist_focus.css"/>
  <link rel="stylesheet" type="text/css" href="/fake_resources/css/notice/notice_CreateUpdate.css">
<script type="text/javascript" src="/fake_resources/js/jquery.js"></script>
<script type="text/javascript">function gomain() { location.href="notice"}</script>
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
<style>
  .ck-editor__editable { height: 300px; width: 881px; }
</style>
</head>
<body>
  <jsp:include page="/WEB-INF/views/header/header_main.jsp"/>
  
  <div id="wrap">
<form:form method="post" modelAttribute="noticeCommand" enctype="multipart/form-data">
    <div id="notice">
      <div id="notice_detail">
        <div class="container notice">
          <div class="detail_wrapper notice d-flex">
            <div class="content_block">
            <div class="headline">
   				<h3>Writing</h3>
  			</div>
              <div class="review">
                <p class="sub_txt title">제목</p>
                <form:input path="title" class="title" type="text" size="100" maxlength="100" />
                <input type="hidden" value="${email}">
                <p class="sub_txt inner">내용</p>
                <form:textarea id="editor" path="content" class="content" cols="100" rows="100" />
              </div>
            </div>
          </div>
          <div class="btn_group2">
            <button type="submit" class="btn2">등록</button>
            <button type="button" onclick="gomain()" class="btn2">취소</button>
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