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
<link rel="stylesheet" href="/fake_resources/css/artist/artist.css">
<link rel="stylesheet" href="/fake_resources/css/storage/storage_list.css">
<link rel="stylesheet" href="/fake_resources/css/mypage/mypage_default.css">
<link rel="stylesheet" href="/fake_resources/css/mypage/mypage_gallerist.css">
</head>
<body>
<div id="wrap">
<jsp:include page="/WEB-INF/views/header/header_main.jsp"/>
<div class="container">
      <h4 class="sub_title">My Information</h4>
      <div class="info_simul">
        <div class="info_wrapper first">
          <div class="info_left gallerist">
            <div class="my_info">
              <form>
                <table class="table_a">
                  <tr>
                    <td>
                      <div class="artist_avatar gallerist">
                        <img src="${gallerist.imgPath}" alt="2">
                      </div>
                    </td>
                  </tr>
                  <tr>
                    <td>
                      <h3>${gallerist.name}</h3>
                      <p>Gallerist</p>
                    </td>
                  </tr>
                </table>
              </form>
            </div>
          </div>
          <div class="info_center">
            <div class="my_info center gallerist">
              <form>
                <table class="table_a">
                  <tr>
                    <td class="a_category">
                    <strong>이메일(아이디)</strong>
                    </td>
                  </tr>
                  <tr>
                    <td class="a_data">
                      ${gallerist.email}
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
                </table>
              </form>
            </div>
          </div>
          <div class="info_right">
            <div class="my_info right">
              <form>
                <table class="table_a">
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
                    ${gallerist.phone}
                  </td>
                </tr>
                </table>
              </form>
            </div>
          </div>
        </div>
      </div>
      <div class="btn2_group">
      	<!--
      	<a href="/arang/mypage/mypage_request_list"><button class="btn2">신청한 아티스트 목록</button></a>
      	  -->
        <a href="/arang/mypage/mypage_gallerist_modify"><button class="btn2">내 정보 수정</button></a>
        <a href="/arang/gallery/gallery_upload"><button class="btn2">갤러리 등록</button></a>
      </div>
    </div>
	<div id="gallerist">
      <form id="artist_form">
        <div class="container my_gallery2">
          <div class="sub_page_context">
            <div class="grid_wrapper">
              <h5 class="sub_title">My Gallerys<small></small></h5>
              <div class="row artist_list">
              <c:forEach var="gallery" items="${myGalleryList}">
                <div class="col artist_item">
                  <div class="artist_info d-flex flex-row">
                    <div class="artist_avatar">
                      <a href="/arang/gallery/gallery_focus?code=${gallery.code}"><img src="${gallery.galleryImgPath}" alt="g1"></a>
                    </div>
                    <div class="artist_text">
                      <div class="first">
                        <span>${gallery.galleryName_eng}</span>
                      </div>
                      <div class="second d-flex flex-row">
                        <div>${gallery.address}</div>
                      </div>
                    </div>
                  </div>
                  <div class="banner_wrap">
                    <a href="#">
                      <div class="artwork_banner">
                        <a href="/arang/gallery/gallery_focus?code=${gallery.code}">
                        <img src="${gallery.infoImgPath}"></a>
                      </div>
                    </a>
                  </div>
                </div>
              </c:forEach>
                
              </div>
            </div>
          </div>
        </div>
      </form>
      <!-- 컨택팅 >>  -->
      <div class="container my_gallery2">
        <!-- <h4 class="sub_title other">Contacting</h4> -->
        <div class="board_wrapper">
          <h3 class="sub_title contacting">Contacting</h3>
          <img class="arrow" src="/fake_resources/img/icon/right.png">
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
        <table class="storage_list mypage gallerist_contact_first">
        <c:forEach var="contacting" items="${contactingList}">
            <tr>
            <td>${contacting.regDate}</td>
            <td>
              <div class="artist_avatar">
                <a href="/arang/artist_board/artist_depth?id=${contacting.artistId}">
                <img class="contacting_img" src="${contacting.imgPath}">
                </a>
              </div>
            </td>
            <td><a class="name_hover" href="/arang/artist_board/artist_depth?id=${contacting.artistId}">${contacting.name_kor} ${contacting.name_eng}</a></td>
            <td>${contacting.startDate}~${contacting.endDate}</td>
            <td>${contacting.exhibitionTitle}</td>
            <td class="YES">
            <c:if test="${contacting.accept == 'U'}">
            <td><p><strong>YET</p></td>
            </c:if>
            <c:if test="${contacting.accept == 'Y'}">
            <td><p><strong style="color: tomato;">YES</p></td>
            </c:if>
            <c:if test="${contacting.accept == 'N'}">
            <td><p><strong>NO</p></td>
            </c:if>
            </td>
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
            <table class="storage_list mypage gallerist_contact_last">
            <c:forEach var="artist" items="${artistList}">
              <tr>
                <td>${artist.regdate}</td>
                <td><img src="${artist.galleryImgPath}"></td>
                <td>${artist.galleryName_eng}</td>
                <td>
                  <div class="artist_avatar">
                    <a href="/arang/artist_board/artist_depth?id=${artist.artistId}">
                    <img class="contacting_img" src="${artist.imgPath}">
                    </a>
                  </div>
                </td>
                <td><a class="name_hover" href="/arang/artist_board/artist_depth?id=${artist.artistId}">
                ${artist.name_kor} ${name_eng}</a></td>
                <td><span class="genre_tag">${artist.genre}</span></td>
                <td>
                <form action="yesda" method="post">
                  <input type="hidden" name="contactId" value="${artist.contactId}"/>
                  <input type="hidden" name="yesBtn" value="Y"/>
                  <button type="submit">승낙</button>
                </form>
                </td>
                <td>
                <form action="noda" method="post">
                  <input type="hidden" name="contactId" value="${artist.contactId}"/>
                  <input type="hidden" name="noBtn" value="N"/>
                  <button type="submit">거절</button>
                </form>
                </td>
              </tr>
              </c:forEach>
            </table>
          </div>
        </div>
    </div>
</div>
</body>
</html>