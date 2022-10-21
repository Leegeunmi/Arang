<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix ="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아티스트가입</title>
<link rel="stylesheet" type="text/css" href="/fake_resources/css/default/normalize.css"/>
  <link rel="stylesheet" type="text/css" href="/fake_resources/css/default/default.css"/>
  <link rel="stylesheet" type="text/css" href="/fake_resources/css/login/input_style.css"/>
  <link rel="stylesheet" type="text/css" href="/fake_resources/css/join/join_artist.css"/>
  <script type="text/javascript" src="/fake_resources/js/jquery.js"></script>
  <script type="text/javascript">
  	function test_checkbox() {  		
  	var flag = false;
  	// checkbox 접근 후 체크된 개수 파악
  	var values = document.getElementsByName("selectGenre");
  	alert(values.length);
  	for(var i=0; i<values.length; i++){
  		if ( values[i].checked ){
  			alert(values[i].value);
  		}
  	}
  	return flag;
  	}
  	
  	function test_checkbox() {  		
  	  	var flag = false;
  	  	// checkbox 접근 후 체크된 개수 파악
  	  	var values = document.getElementsByName("inputCareer");
  	  	alert(values.length);
  	  	for(var i=0; i<values.length; i++){
  	  		if ( values[i].checked ){
  	  			alert(values[i].value);
  	  		}
  	  	}
  	return flag;
  	}
  	
  	cnt = 0;
  	const add_textbox = () => {
  		if ( cnt < 2 ) {
        const box = document.getElementById("box");
        const newP = document.createElement('tr');
        newP.innerHTML = "<td> <input name='inputCareer' type='text' class='big' placeholder='경력'> "
        + "</td> <input type='button' value='삭제' onclick='remove(this)'>";
        box.appendChild(newP);
  		cnt++;
  		}
    }
    const remove = (obj) => {
        document.getElementById('box').removeChild(obj.parentNode);
        cnt--;
    }
  </script>
</head>
<body>
<jsp:include page="/WEB-INF/views/header/header_main.jsp"/>
<div id="input_wrap">
      <div class="title">
        <h1>ARTIST JOIN</h1>
      </div>
      <form:form method="post" modelAttribute="artistCommand" enctype="multipart/form-data">
        <table class="table_a">
          <tr>
            <td>
              <form:input path="email1" class="small" placeholder="이메일(아이디)"/> @
              <form:select path="email2" class="box">
             	<option value="unknown">--선택--</option>
                <form:options itemValue="emailHost"
	 							itemLabel="emailCode"
	 							items="${emailProviderList}"/>
              </form:select>
            </td>
          </tr>
          <tr>
            <td>
              <form:input path="passwd" type="password" class="big" placeholder="비밀번호"/>
            </td>
          </tr>
          <tr>
            <td>
              <form:input path="name_kor" class="big" placeholder="이름(한글)"/>
            </td>
          </tr>
          <tr>
            <td>
              <form:input path="name_eng" class="big" placeholder="이름(영문)"/>
            </td>
          </tr>
          <tr>
            <td>
              <form:input path="ssn" class="big" placeholder="주민등록번호"/>
            </td>
          </tr>
          <tr>
            <td>
              <form:input path="phone" class="big" placeholder="전화번호"/>
            </td>
          </tr>
          <tr>
            <td>
              <div class="check_wrap">
                <span class="check_title">장르(중복선택가능)</span>
                <span>조각가(Sculptor)<input class="check_btn" type="checkbox" name="selectGenre" value="Sculptor"></span>
                <span>회화가(Painter)<input class="check_btn" type="checkbox" name="selectGenre" value="Painter"></span>
                <span>동양화가(OrientalPainter)<input class="check_btn" type="checkbox" name="selectGenre" value="OrientalPainter"></span>
                <span>소묘화가(DrawingArtist)<input class="check_btn" type="checkbox" name="selectGenre" value="DrawingArtist"></span>
                <span>일러스트레이터(Illustrator)<input class="check_btn" type="checkbox" name="selectGenre" value="Illustrator"></span>
                <span>디지털아티스트(DigtalArtist)<input class="check_btn" type="checkbox" name="selectGenre" value="DigtalArtist"></span>
                <span>포토그래퍼(Photographer)<input class="check_btn" type="checkbox" name="selectGenre" value="Photographer"></span>
              </div>
            </td>
          </tr>
          <tr>
            <td>
          		<div id="box">
         		   <input name="inputCareer" type="text" class="big" placeholder="경력">
         		   <input type="button" value="추가" onclick="add_textbox()">
        		</div>
          	</td>
          </tr>
          
          <tr>
            <td>
              <div class="select_file">
                <input type="file" name="imgFile" class="big" placeholder="이미지등록"/>
              </div>
            </td>
          </tr>
        </table>
        <div class="button-group">
          <button type="submit" class="gbtn normal">회원가입</button>
          <button class="gbtn normal" type="button" onclick="location.href='/arang/main'">취소</button>
        </div>
        <div class="btn_other">
          <p>이미 계정이 있으신가요?&nbsp;&nbsp;</p>
          <a href="/arang/login"><strong>로그인</strong></a>
        </div>
      </form:form>
    </div>




</body>
</html>