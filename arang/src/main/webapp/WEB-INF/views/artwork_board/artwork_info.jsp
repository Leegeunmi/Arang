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
<link rel="stylesheet" type="text/css" href="/fake_resources/css/swiper/swiper.css"/>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper/swiper-bundle.min.css"/>
<script type="text/javascript" src="/fake_resources/js/jquery.js"></script>
<script type="text/javascript" src="/fake_resources/js/common.js"></script>
</head>
<body>
<div id="wrap">
<jsp:include page="/WEB-INF/views/header/header.jsp"/>
	<!-- 아트워크 상세 -->
    <div id="artwork">
      <div id="artwork_detail">
        <div class="container">
          <div class="artwork_simul">
            <div class="artwork_wrapper">
              <div class="artwork_view">
                <div class="img_wrapper">
                  <div class="paintings">
                    <img class="artwork" src="${artworkInfo.artworkImgPath}" onload="JavaScript:artwork_large(this)">
                  </div>
                </div>
              </div>
              <div class="artwork_info_wrap">
                <div class="artwork_info">
                  <h2>${artworkInfo.name}</h2>
                  <div class="info">
                    <div class="info_block">
                      <div class="first">작가명(Name)</div>
                      <div class="last">
                        <a href="/arang/artist_board/artist_depth?id="${artistInfo.aid}">${artistInfo.name_kor} ${artistInfo.name_eng}</a>
                      </div>
                    </div>
                    <div class="info_block">
                      <div class="first">장르(Genre)</div>
                      <div class="last">
                        <a href="../html_artist/artist.html">${artworkInfo.genre}</a>
                      </div>
                    </div>
                    <div class="info_block">
                      <div class="first">기법(Technique)</div>
                      <div class="last">${artworkInfo.technique}</div>
                    </div>
                    <div class="info_block">
                      <div class="first">크기(Size)</div>
                      <div class="last">${artworkInfo.size}</div>
                    </div>
                    <div class="info_block">
                      <div class="first">년도(Year)</div>
                      <div class="last">2018</div>
                    </div>
                    <div class="info_block2">
                      <div class="first">설명(Description)</div>
                      <div class="last">${artworkInfo.description}</div>
                    </div>
                  </div>
                </div>
                <div class="button_wrap">
                  <div class="btn_group">
                    <form action="testbtn" method="get">
                      <input type="hidden" id="aid" name="artistId" value="${artistInfo.aid}" />
                      <button id="contactBtn" class="btn1" type="submit">Contacting</button>
                    </form>
                      <button class="like likeButton" value="${wid}">
                      <c:if test="${likeNum == 0}">
                      <img class="like_img" src="/fake_resources/img/icon/like_2.png" alt="like">
						</c:if>
						<c:if test="${likeNum == 1}">
                      <img class="like_img" src="/fake_resources/img/icon/like.png" alt="like">
						</c:if>
                      </button>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <!-- 상세 내용 -->
          <section>
            <div class="a_title">
              <div class="first">
                ${artworkInfo.mainTitle }
              </div>
              <div class="second">
                ${artworkInfo.subTitle }
              </div>
            </div>
            <div class="a_artwork">
            	<c:forTokens var="infoImg" items="${artworkInfo.workInfoImgPath}" delims=";">
            		<img src="${infoImg}">
            	</c:forTokens>
            </div>
            <div class="a_desc">
              <h4 class="sub_title">Artist</h4>
              <h3>${artistInfo.name_kor}</h3><p class="e_name">${artistInfo.name_eng}</p><p class="born">1984</p>
              <p class="txt">${artistInfo.description}</p>
            </div>
            <div class="product">
              <h4 class="sub_title">This artist's work</h4>
              <div id="product2" class="item_list1">
                <div class="slick_list swiper mySwiper">
                    <div class="slick_trak swiper-wrapper">
                    <c:forEach var="artwork" items="${artworkList}">
                      <div class="item swiper-slide">
                        <div class="artwork_wrap">
                          <a href="/arang/artwork_board/artwork_info?id=${artwork.artistId}&wid=${artwork.wid}">
                            <img class="artwork" src="${artwork.artworkImgPath}" onload="JavaScript:artwork_middle(this)"></a>
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
          </section>
        </div>
      </div>

    </div>
    </div>
    
    <!-- Swiper JS -->
    <script src="https://cdn.jsdelivr.net/npm/swiper/swiper-bundle.min.js"></script>

    <!-- Initialize Swiper -->
    <script>
      var swiper = new Swiper(".mySwiper", {
    	autoplay: {
    		  delay: 2000,
    		  disableOnInteraction: false,
    		},
        slidesPerView: 3,
        spaceBetween: 30,
        pagination: {
          el: ".swiper-pagination",
          clickable: true,
        },
        navigation: {
          nextEl: ".swiper-button-next",
          prevEl: ".swiper-button-prev",
        },
      });
      
      
      
      $("#contactBtn").click(function() {
		var aid = $("#aid").val();
		var wid = $("#wid").val();
		console.log(aid);
		console.log(wid);
	})
     
	$(".likeButton").click(function() {
		//해당 Value값 가져와서 할당
		let userId = '<c:out value="${email}"/>';
		let targetValue = $(this).attr('value');
		console.log(userId);
		console.log(targetValue);
		$.ajax({
			type :'post',
			url : '<c:url value ="/likeUp"/>',
			contentType: 'application/json',
			data : JSON.stringify(
					{
						"userId" : userId,
						"targetValue" : targetValue,
						"likeNum" : 1
					}
				),
			context: this, 
			success : function(data) {
				alert(data.msg);
				let likeCheck = data.likeCheck;
				if(likeCheck == 1){
					$(this).children("img").attr('src','../resources/img/icon/like_2.png');
					console.log($(this));
				}else{
					$(this).children("img").attr('src','../resources/img/icon/like.png');
					console.log($(this));
				}
			},
			error : function(error) {
				alert(error);
			}
		})

	});//like
      
    </script>
</body>
</html>