<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/fake_resources/css/default/normalize.css"/>
<link rel="stylesheet" type="text/css" href="/fake_resources/css/default/default.css"/>
<link rel="stylesheet" type="text/css" href="/fake_resources/css/login/input_style.css"/>
<link rel="stylesheet" type="text/css" href="/fake_resources/css/join/join_artist.css"/>
<link rel="stylesheet" href="/fake_resources/css/main/main.css">
<link rel="stylesheet" href="/fake_resources/css/artist/artist.css">
<link rel="stylesheet" href="/fake_resources/css/exhibition/exhibition.css">
</head>
<body>

<div id="wrap">
  
<jsp:include page="/WEB-INF/views/header/header_main.jsp"/>
      
<div class="exhibition">
      <div class="exhibition_wrapper">
      <c:forEach var="exhibitions" items="${exhibitionList}">
        <div class="exhibition_view">
          <div class="img_wrapper">
            <a href="/arang/exhibitions/exhibition_focus">
            <img src="${exhibitions.artworkImgPath}"></a>
          </div>
          <p>${exhibitions.exhibitionTitle }</p>
          <p class="date">${exhibitions.startDate} ~ ${exhibitions.endDate}</p>
        </div>
      </c:forEach>
    </div>
    
</div>
</div>
</body>
</html>