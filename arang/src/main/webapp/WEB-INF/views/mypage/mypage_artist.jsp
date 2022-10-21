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
<link rel="stylesheet" href="/fake_resources/css/login/input_style.css">
<link rel="stylesheet" href="/fake_resources/css/join/join_artist.css">
<link rel="stylesheet" href="/fake_resources/css/artist/artist_focus.css">
<link rel="stylesheet" href="/fake_resources/css/storage/storage_list.css">
<link rel="stylesheet" href="/fake_resources/css/mypage/mypage_default.css">
<link rel="stylesheet" href="/fake_resources/css/mypage/mypage_artist.css">
<script type="text/javascript" src="/fake_resources/js/jquery.js"></script>
<script type="text/javascript" src="/fake_resources/js/common.js"></script>
</head>
<body>
<div id="wrap">
<jsp:include page="/WEB-INF/views/header/header_main.jsp"/>
<div class="container padding_zero">
      <h4 class="sub_title">My Information</h4>
      <div class="info_simul">
        <div class="info_wrapper first">
          <div class="info_left">
            <div class="my_info">
              <form>
                <table class="table_a">
                  <tr>
                    <td>
                      <div class="artist_avatar artist">
                        <img class="my_info_img" src="${artist.imgPath}">
                      </div>
                    </td>
                  </tr>
                  <tr>
                    <td>
                      <h3>${artist.name_kor}</h3>
                      <p class="e_name">${artist.name_eng}</p>
                    </td>
                  </tr>
                </table>
              </form>
            </div>
          </div>
          <div class="info_center">
            <div class="my_info mypage">
              <form>
                <table class="table_a">
                  <tr>
                    <td class="a_category">
                    <strong>이메일(아이디)</strong>
                    </td>
                  </tr>
                  <tr>
                    <td class="a_data">
                      ${artist.email}
                    </td>
                  </tr>
                  <tr>
                    <td class="a_category">
                      <strong>비밀번호</strong>
                    </td>
                  </tr>
                  <tr>
                    <td class="a_data">
                      ********
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
                    </td>
                  </tr>
                  <tr>
                    <td class="a_category">
                      <strong>전화번호</strong>
                    </td>
                  </tr>
                  <tr>
                    <td class="a_data">
                      ${artist.phone}
                    </td>
                  </tr>
                </table>
              </form>
            </div>
          </div>
          <div class="info_right">
            <div class="my_info mypage">
              <form>
                <table class="table_a">
                  <tr>
                    <td class="a_category">
                      <strong>경력</strong>
                    </td>
                  </tr>
                  <c:forTokens var ="career" items="${artist.career}" delims=";">
                  <tr>
                    <td>
                      ${career}
                    </td>
                  </tr>
                  </c:forTokens>
                </table>
              </form>
            </div>
          </div>
        </div>
      </div>
      <div class="btn2_group">
        <a href="/arang/mypage/mypage_artist_modify"><button class="btn2 first">내 정보 수정</button></a>
        <c:if test="${infoCheck == 0}">
      	<a href="/arang/mypage/add_artist_info"><button class="btn2 first" style="width: 160px;">내 페이지 등록</button></a>
      	</c:if>
      	<a href="#"><button class="btn2 first">내 페이지 수정</button></a>
      	<!-- 
      	<a href="/arang/mypage/mypage_request_list2"><button class="btn2 first">신청 아티스트 목록</button></a>
      	 -->
      </div>
      <h4 class="sub_title other">MY ArtWorks</h4>
      <div class="product">
        <div id="product2" class="item_list1">
          <div class="slick_list">
            <div class="slick_trak mypage">
            <c:forEach var="artwork" items="${artworkList}">
              <div class="item">
                  <div class="artwork_wrap">
                    <a href="/arang/artwork_board/artwork_info?id=${artwork.artistId}&wid=${artwork.wid}">
                    <img class="artwork" src="${artwork.artworkImgPath}" onload="JavaScript:artwork_small_middle(this)"></a>
                  </div>
                <figcaption>
                  <h5>${artwork.name}</h5>
				<p>${artwork.technique}</p>
				</figcaption>
			</div>
		</c:forEach>
				</div>
            </div>
          </div>
        </div>      
      <div class="btn2_group">
      <c:if test="${infoCheck == 1}">
        <a href="/arang/pages/add_artwork"><button class="btn2 first">작품 등록</button></a>
      </c:if>
      <c:if test="${infoCheck == 0}">
       <button id="alert1" class="btn2 first">작품 등록</button>
      </c:if>
        <!-- <a href="../html_mypage/artwork_upload.html"><button class="btn2">작품 수정</button></a> -->
        <a href="./artwork_upload.html"><button class="btn2">작품 삭제</button></a>
      </div>
      <!-- 컨택팅 >>  -->
     <div class="container my_gallery2">
        <div class="board_wrapper">
          <h3 class="sub_title contacting">Contacting</h3>
          <img class="arrow" src="/fake_resources/img/icon/right.png">
          <div>
              <fieldset>
                <div class="field_inner">
                  <label>검색어</label>
                  <input type="text">
                  <a href="#"><button class="board_btn" type="button">검색</button></a>
                </div>
              </fieldset>
        </div>
        <table class="storage_list mypage artist_contact_first">
           <c:forEach var="contacting" items="${contactingList}">
            <tr>
            <td>${contacting.regDate}</td>
            <td>
              <div class="artist_avatar">
                <a href="/arang/gallery/gallery_focus?code=${contacting.galleryCode}"><img class="contacting_img" src="${contacting.galleryImgPath}"></a>
              </div>
            </td>
            <td><a class="name_hover" href="/arang/gallery/gallery_focus?code=${contacting.galleryCode}">${contacting.galleryName_eng}</a></td>
            <td>${contacting.address}</td>
            <c:if test="${contacting.accept == 'U'}">
            <td><p><strong>YET</p></td>
            </c:if>
            <c:if test="${contacting.accept == 'Y'}">
            <td><p><strong style="color: tomato;">YES</p></td>
            </c:if>
            <c:if test="${contacting.accept == 'N'}">
            <td><p><strong>NO</p></td>
            </c:if>
            </tr>
           </c:forEach>
              </table>
            </div>
          </div>
          
      <!-- 컨택팅 <<  -->
      <div class="container my_gallery2">
            <!-- <h4 class="sub_title other">Contacting</h4> -->
            <div class="board_wrapper">
              <h3 class="sub_title contacting">Contacting</h3>
              <img class="arrow" src="/fake_resources/img/icon/left.png">
              <div>
                <form>
                  <fieldset>
                    <div class="field_inner">
                      <label>검색어</label>
                      <input type="text">
                      <a href="#"><button class="board_btn" type="button">검색</button></a>
                    </div>
                  </fieldset>
                </form>
            </div>
		<table class="storage_list mypage artist_contact_last">
            <c:forEach var="contact" items="${contactList}">
              <tr>
                <td>${contact.regDate}</td>
                <td>
                  <div class="artist_avatar">
                    <a href="/arang/gallery/gallery_focus?code=${contact.galleryCode}">
                    <img class="contacting_img" src="${contact.galleryImgPath}" style="width: 40px; height: 40px; margin-top:0;">
                    </a>
                  </div>
                </td>
                <td><a class="name_hover" href="/arang/gallery/gallery_focus?code=${contact.galleryCode}">
                ${contact.galleryName_eng}</a></td>
                <td>${contact.startDate} ~ ${contact.endDate}</td>
                <td>${contact.exhibitionTitle }</td>
                <form action="yesga" method="post">
                  <input type="hidden" name="contactId" value="${contact.contactId}"/>
                  <input type="hidden" name="yesBtn" value="Y"/>
                  <td><button class="board_btn" type="submit">승낙</button></td>
                </form>
                <form action="nodga" method="post">
                  <input type="hidden" name="contactId" value="${contact.contactId}"/>
                  <input type="hidden" name="noBtn" value="N"/>
                  <td style="padding-right: 40px;"><button class="board_btn" type="submit">거절</button></td>
                </form>
              </tr>
              </c:forEach>
            </table>
          </div>
        </div>
      <div class="btn2_group">      	       
      </div>
    </div>
   </div>
   <script>
   $("#alert1").on("click", function(){
		alert("아티스트 페이지를 먼저 등록해주세요.");
	});
   </script>
</body>
</html>