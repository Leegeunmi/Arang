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
</head>
<body>
<div id="wrap">

<jsp:include page="/WEB-INF/views/header/header_main.jsp"/>
<div class="container">
      <h4 class="sub_title">My Information</h4>
      <div class="info_simul">
        <div class="info_wrapper first">
            <div class="my_info center gallerist">
                <table class="table_a">
                  <tr>
                    <td>
                    <strong>장르</strong>
                    </td>
                    <td>
                    <strong>프로필</strong>
                    </td>
                    <td>
                    <strong>신청인</strong>
                    </td>
                    <td>
                    <strong>활동작품</strong>
                    </td>
                    <td>
                    <strong>신청날짜</strong>
                    </td>
                    <td>
                    <strong>상태</strong>
                    </td>
                    <td>
                    <strong>승낙/거절</strong>
                    </td>
                  </tr>
                  <c:forEach var="contact" items="${contactList}">
                  <tr>
                    <td>${contact.genre }</td>
                    <td>
                    <a href="/arang/artist_board/artist_depth?id=${artworkPage.aid}">
                    <img src="${contact.imgPath}" style="width: 100px; height:100px;">
                    </a>
                    </td>
                    <td>${contact.name_kor }</td>
                    <td>${contact.name }</td>
                    <td>${contact.regDate}</td>
                    <c:if test="${contact.accept == 'U'}">
                   	  <td>미확인</td>
                    </c:if>
                    <c:if test="${contact.accept == 'Y'}">
                   	  <td>승낙</td>
                    </c:if>
                    <c:if test="${contact.accept == 'N'}">
                   	  <td>거절</td>
                    </c:if>
                    <td>
                    <form action="yesda" method="post">
                      <input type="hidden" name="contactId" value="${contact.contactId}"/>
                      <input type="hidden" name="yesBtn" value="Y"/>
                      <button type="submit">승낙</button>
                    </form>
                    <form action="noda" method="post">
                      <input type="hidden" name="contactId" value="${contact.contactId}"/>
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
      <div class="btn2_group">
        <a href="/arang/mypage/mypage_gallerist"><button class="btn2">내 정보</button></a>
      </div>
    </div>

</div>
</body>
</html>