<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
  <title>갤러리상세페이지</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">
  <link rel="stylesheet" type="text/css" href="/fake_resources/css/default/normalize.css"/>
  <link rel="stylesheet" type="text/css" href="/fake_resources/css/default/default.css"/>
  <link rel="stylesheet" type="text/css" href="/fake_resources/css/artist/artist_focus.css">
  <link rel="stylesheet" type="text/css" href="/fake_resources/css/gallery/gallery_focus.css">
</head>

<body>
  <div id="wrap">
    
    <jsp:include page="/WEB-INF/views/header/header_main.jsp"/>
    
    <div class="headline">
      <h3>Gallery</h3>
      <nav id="sub-nav">
        <ul>
          <li><a href="../html_gallery/gallery.html">All</a></li>
          <li><a href="../html_gallery/Seoul.html">Seoul</a></li>
          <li><a href="../html_gallery/Gyeonggi.html">Gyeonggi</a></li>
          <li><a href="../html_gallery/Deajeon.html">Deajeon</a></li>
          <li><a href="../html_gallery/Daegu.html">Daegu</a></li>
          <li><a href="../html_gallery/Busan.html">Busan</a></li>
          <li><a href="../html_gallery/Jeju.html">Jeju</a></li>
          <li><a href="../html_gallery/Other.html">Other</a></li>
        </ul>
      </nav>
    </div>

    <!-- 갤러리상세페이지 -->
    <div id="artist">
      <div id="artist_detail">
        <div class="container">
          <div class="detail_wrapper d-flex">
            <div class="side_block">
              <div class="artist_info">
                <h3>${galleryCommand.galleryName_kor}</h3>
                <p class="e_name">${galleryCommand.galleryName_eng}</p>
                <p class="born">${galleryCommand.since}</p>
                <div class="artist_avatar">
                  <img src="${galleryCommand.galleryImgPath}" alt="2">
                </div>
              </div>
            </div>
            <div class="content_block">
              <div class="review">
                <h2>${galleryCommand.galleryName_eng}</h2>
                <p>${galleryCommand.description}</p>
                <p><br></p>
                <p>
                <c:forTokens var="infoImg" items="${galleryCommand.infoImgPath}" delims=";">
            		<img src="${infoImg}">
            	</c:forTokens>
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
                              ${galleryCommand.address}
                            </div>
                          </div>
                          <div class="info_block">
                            <div class="first">크기(Size)</div>
                            <div class="last">
                              ${galleryCommand.area}
                            </div>
                          </div>
                          <div class="info_block">
                            <div class="first">시간(Hours)</div>
                            <div class="last">
                              ${galleryCommand.openClose}
                            </div>
                          </div>
                          <div class="info_block">
                            <div class="first">이메일(Email)</div>
                            <div class="last">${galleryCommand.galleryEmail}</div>
                          </div>
                          <div class="info_block">
                            <div class="first">전화번호(Phone)</div>
                            <div class="last">${galleryCommand.galleryPhone}</div>
                          </div>
                        </div>
                      </div>
                      <div class="button_wrap">
                        <div class="btn_group">
                        <form action="gallery_focus" method="post">
                          <a href="#"><button class="btn1" type="submit">Contacting</button></a>
                          <input type="hidden" name="galleryCode" value="${galleryCommand.code}" />
                        </form>
                          <button class="like likeButton" value="${galleryCommand.code}">
                      <c:if test="${likeNum == 4}">
                      <img class="like_img" src="/fake_resources/img/icon/like_2.png" alt="like">
						</c:if>
						<c:if test="${likeNum == 5}">
                      <img class="like_img" src="/fake_resources/img/icon/like.png" alt="like">
						</c:if>
                      </button>
                          <p>76</p>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div class="side_block">
              <div class="a_list">
                <h3>추천작가</h3>
                <ul>
                  <li>
                    <a href="#">신수희</a>
                  </li>
                  <li>
                    <a href="#">최선호</a>
                  </li>
                </ul>
              </div>
              <div class="a_banner">
                <h3>이달의 전시</h3>
                <a href="#"><img class="exhibition_banner" src="/upload_img/banner/김선배너.jpg" alt="exhibition_banner"></a>
              </div>
            </div>
          </div>
        </div>
      </div>

    </div>
  </div>
  <script>
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
