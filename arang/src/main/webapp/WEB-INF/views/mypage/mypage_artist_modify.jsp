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
<link rel="stylesheet" href="/fake_resources/css/login/input_style.css">
<link rel="stylesheet" href="/fake_resources/css/join/join_artist.css">
<link rel="stylesheet" href="/fake_resources/css/mypage/mypage_default.css">
<script>
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

<div id="wrap">

<jsp:include page="/WEB-INF/views/header/header_main.jsp"/>
<div class="container">
      <h4 class="sub_title">My Information</h4>
      <div class="info_simul">
        <div class="info_wrapper second">
          <div class="info_left">
            <div class="my_info">
                <table class="table_a">
                  <tr>
                    <td>
                      <div class="artist_avatar">
                        <form action="uploadAjaxAction2" method="post" enctype="multipart/form-data">
                        <img id="changeImg" src="${artist.imgPath}" class="click">
                        <input id="uploadFile" type="file" name="uploadFile" style="display: none;" onchange="imgchange(this)">
                        <button id="uploadBtn" style="display: none;"></button>
                      </form>
                      </div>
                    </td>
                  </tr>
                  <tr>
                    <td>
                      <h3>${artist.name_kor}</h3>
                      <input type="hidden" value="${artist.name_kor}" name="name_kor"/>
                      <p class="e_name">${artist.name_eng}</p>
                      <input type="hidden" value="${artist.name_eng}" name="name_eng"/>
                    </td>
                  </tr>
                </table>
            </div>
          </div>
          <form action="mypage_artist_modify" method="post">
          <div class="info_center">
            <div class="my_info">
                <table class="table_a">
                  <tr>
                    <td class="a_category">
                    <strong>이메일(아이디)</strong>
                    </td>
                  </tr>
                  <tr>
                    <td class="a_data">
                      ${artist.email}
                      <input type="hidden" value="${artist.email}" name="email"/>
                    </td>
                  </tr>
                  <tr>
                    <td class="a_category">
                      <strong>비밀번호</strong>
                    </td>
                  </tr>
                  <tr>
                    <td class="a_data">
                      <input type="text" class="small" placeholder="새 비밀번호" name="passwd"/>
                    </td>
                  </tr>
                  <tr>
                    <td class="a_category">
                      <strong>주민등록번호</strong>
                    </td>
                  </tr>
                  <tr>
                    <td class="a_data">
                      ${ssn}
                      <input type="hidden" value="${ssn}" name="ssn"/>
                    </td>
                  </tr>
                  <tr>
                    <td class="a_category">
                      <strong>전화번호</strong>
                    </td>
                  </tr>
                  <tr>
                    <td class="a_data">
                      <input type="text" class="small" value="${artist.phone}" name="phone"/>
                    </td>
                  </tr>
                </table>
            </div>
          </div>
          <div class="info_right">
            <div class="my_info">
                <table class="table_a">
                  <tr>
                    <td class="a_category">
                      <strong>경력</strong>
                    </td>
                  </tr>
                  <c:forTokens var="career" items="${artist.career}" delims=";">
                  <tr>
                    <td>
         			${career}
         			<input type="hidden" class="small" value="${career};" name="career"/>
                    </td>
                  </tr>
                  </c:forTokens>
                </table>
            </div>
          </div>
          </form>
        </div>
      </div>
      <div class="btn2_group">
        <a href="/arang/mypage/mypage_artist"><button class="btn2" type="submit">저장</button></a>
        <a href="/arang/mypage/mypage_artist"><button class="btn2" type="button">취소</button></a>
      </div>
    </div>
</div>


<script>
$('#uploadBtn').click(function(event) {
	   console.log(this.innerText);
	   let clickCategory = this.innerText;
	   $.ajax({
	       type:"post",
	       url : '/uploadAjaxAction',
	       contentType: false,
	       dataType: "file",
	       data : JSON.stringify(
	             {
	             <!-- 보내지는 데이터 영역 -->
	             "categoryValue" : clickCategory
	             }
	             ),
	       success: function(data){
	          if(data == "error"){
	                alert("데이터 전송 실패!!");
	          }else{                 
	             console.log("데이터 전송 성공!!");
	             console.log(data);
	             alert(data);
	             }
	          }
	   })
	});

	let click = document.querySelector(".click");
	let clickTarget = document.querySelector("#uploadFile");
	let btnTarget = document.querySelector("#uploadBtn");
	click.addEventListener("click", function() {
	   alert("이미지를 선택해주세요.");
	   clickTarget.click();
	});

	function imgchange(e) {
	   btnTarget.click();
	}
</script>
</body>
</html>