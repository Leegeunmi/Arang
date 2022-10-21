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
  <link rel="stylesheet" type="text/css" href="/fake_resources/css/join/join.css"/>
  <script type="text/javascript" src="/fake_resources/js/jquery.js"></script>
</head>
<body>
<div id="wrap">
<jsp:include page="/WEB-INF/views/header/header_main.jsp"/>

<div class="container join">
      <div class="artwork_simul">
        <div id="join_wrapper">
          <div id="artist_join">
            <div class="inner">
              <img class="job" src="/fake_resources/img/icon/artist_join2.png" alt="artist_join">
              <p class="title">I'm an Artist</p>
              <div class="btn_group">
                <a href="/arang/user/add_artist"><button class="btn1">아티스트 가입</button></a>
              </div>
            </div>
          </div>
          <div id="gallerist_join">
            <div class="inner">
              <img class="job" src="<c:url value ='/resources/img/icon/gallerist_join2.png'/>" alt="gallerist_join">
              <p class="title">I'm a Gallerist</p>
              <div class="btn_group">
                <a href="/arang/gallery/join_gallerist"><button class="btn1">갤러리스트 가입</button></a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
</div>    
</body>
</html>