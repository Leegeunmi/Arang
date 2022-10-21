<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">
  <title>아티스트가입</title>
  <link rel="stylesheet" type="text/css" href="/fake_resources/css/default/normalize.css"/>
  <link rel="stylesheet" type="text/css" href="/fake_resources/css/default/default.css"/>
  <link rel="stylesheet" type="text/css" href="/fake_resources/css/login/input_style.css"/>
  <link rel="stylesheet" type="text/css" href="/fake_resources/css/join/join_artist.css"/>
</head>
<script type='text/javascript'> 
var cnt = ''; 
function upfileAdd() 
{ 
    eval('upfileAddArea' + cnt).innerHTML += "<input type='file' name='imgPath' multiple size='60'><div id='upfileAddArea" + (cnt+1) + "'></div>"; 
    cnt++; 
} 
</script> 

<body>
  <div id="wrap">
  
  <jsp:include page="/WEB-INF/views/header/header_main.jsp"/>
  
    <div id="input_wrap">
      <div class="gallerist_input_wrap">
        <div class="title">
          <h1>GALLERIST JOIN</h1>
        </div>
        <form:form method="post" modelAttribute="galleristCommend" enctype="multipart/form-data">
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
                <form:input path="passwd" type="password" class="big" placeholder="비밀번호" />
              </td>
            </tr>
            <tr>
              <td>
                <form:input path="name" class="big" placeholder="이름" />
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
                <div class="select_file">
                  <input type="file" class="big" placeholder="이미지등록" name="imgName1">
                </div>
              </td>
            </tr>
          </table>
          <div class="button-group">
            <input type="submit" value="회원가입" class="gbtn normal" name="button"/>
            <button class="gbtn normal" type="button" onclick="location.href='/arang/main'">취소</button>
          </div>
          <div class="btn_other">
            <p>이미 계정이 있으신가요?&nbsp;&nbsp;</p>
            <a href="/arang/login"><strong>로그인</strong></a>
            </div>
          </form:form>
      </div>
   </div>
   </div>
</body>

</html>
