<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<c:url value ='/resources/css/default/normalize.css'/>"/>
<link rel="stylesheet" type="text/css" href="<c:url value ='/resources/css/default/default.css'/>"/>
<link rel="stylesheet" type="text/css" href="<c:url value ='/resources/css/default/header.css'/>"/>
<script type="text/javascript" src="<c:url value ='/resources/js/jquery.js'/>"></script>
</head>
<body>


    <header id="header">
      <div class="inner">
        <!-- 로고 -->
        <h1 id="top-logo">
          <a href="/arang/main">ARANG</a>
        </h1>
        <!-- 메인메뉴 -->
        <nav id="top-nav">
          <ul class="center_menu">
            <li><a href="/arang/artist_board/artist_main">Artists</a></li>
            <li><a href="/arang/gallery/gallery">Gallerys</a></li>
            <li><a href="/arang/exhibitions/exhibitions_main">Exhibitions</a></li>
            <li><a href="/arang/storage_page/storage_main">Storage</a></li>
            <li><a href="/arang/notice/notice">Notice</a></li>
            <li><a href="/arang/customer_page/customer_main">Shop</a></li>
          </ul>
          <ul class="side_menu">
            <li><a href="/arang/main"><img src="<c:url value ='/resources/img/icon/find.png'/>" alt="find"></a></li>
            <c:if test="${artistLogin != null}">
            	<li><a href="/arang/mypage/mypage_artist"><img src="<c:url value ='/resources/img/icon/mypage.png'/>" alt="mypage"></a></li>
            </c:if>
            <c:if test="${galleristLogin != null}">
            	<li><a href="/arang/mypage/mypage_gallerist"><img src="<c:url value ='/resources/img/icon/mypage.png'/>" alt="mypage"></a></li>
            </c:if>
            <c:if test="${galleristLogin == null && artistLogin == null}">
            	<li><a href="/arang/login"><img src="<c:url value ='/resources/img/icon/mypage.png'/>" alt="mypage"></a></li>
            </c:if>
            <li><a href="/arang/mypage/wish_list"><img src="<c:url value ='/resources/img/icon/like.png'/>" alt="like"></a></li>
            <li><a href="/arang/mypage/mypage_gallerist"><img src="<c:url value ='/resources/img/icon/cart.png'/>" alt="cart"></a></li>
            <c:if test="${email == null}">
            	<li><a href="/arang/login">Login</a></li>
            </c:if>
            <c:if test="${email != null}">
            	<li><a href="/arang/user/logout">logout</a></li>
            </c:if>
          </ul>
        </nav>
      </div>
    </header>

    <div class="headline">
      <h3>ARTISTS</h3>
      <nav id="sub-nav">
        <ul>
          <li><a href="/arang/artist_board/artist_main" class="testBtn">All</a></li>
          <li><a href="/arang/artist_board/artist_main" class="testBtn">Sculptor</a></li>
          <li><a href="/arang/artist_board/artist_main" class="testBtn">Painter</a></li>
          <li><a href="/arang/artist_board/artist_main" class="testBtn">OrientalPainter</a></li>
          <li><a href="/arang/artist_board/artist_main" class="testBtn">DrawingArtist</a></li>
          <li><a href="/arang/artist_board/artist_main" class="testBtn">Illustator</a></li>
          <li><a href="/arang/artist_board/artist_main" class="testBtn">DigitalArtist</a></li>
          <li><a href="/arang/artist_board/artist_main" class="testBtn">Photographer</a></li>
        </ul>
      </nav>
    </div>
<script>
$('.testBtn').click(function(event) {
	event.preventDefault();
	console.log(this.innerText);
	let clickCategory = this.innerText;
	$.ajax({
    	type:"post",
    	url:"<c:url value ='/clickCategory'/>",
    	contentType: 'application/json; charset:UTF-8"',
    	dataType: "html",
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
    			console.log($('#artist').children().remove());
    			location.href="/arang/artist_board/artist_main?genre=" + data;
   	 		}
   		 }
	})
});
</script>
</body>
</html>