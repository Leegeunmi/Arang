<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <link rel="stylesheet" type="text/css" href="/fake_resources/css/default/normalize.css"/>
  <link rel="stylesheet" type="text/css" href="/fake_resources/css/default/default.css"/>
  <link rel="stylesheet" type="text/css" href="/fake_resources/css/storage/storage_list.css">
  <link rel="stylesheet" type="text/css" href="/fake_resources/css/artist/artist_focus.css"/>
  <link rel="stylesheet" type="text/css" href="/fake_resources/css/notice/notice_CreateUpdate.css">
  <link rel="stylesheet" type="text/css" href="/fake_resources/css/notice/notice_one.css">
  <script type="text/javascript" src="/fake_resources/js/jquery.js"></script>
<script type="text/javascript">
	function gomain() { location.href="notice"}
	function goupdate() { location.href="updateNoticeForm?num=${noticeCommand.num}"}
	function godelete() { location.href="deleteNoticeForm?num=${noticeCommand.num}"}
</script>
</head>

<body>
  <jsp:include page="/WEB-INF/views/header/header_main.jsp"/>
  
  <div id="wrap">
	
	<form:form method="post">
      <div class="board_wrapper">
      <div>
      <table class="storage_list artist">
        <c:forEach var="findOne" items="${noticeFindOne}">
          <tr>
            <td class="findOne_td"><strong>No.</strong> ${findOne.num}</td>
            <td class="findOne_td"><strong>작성자</strong> ${findOne.writer}</td>
            <td class="findOne_td"><strong>조회</strong> ${findOne.readCnt}</td>
            <td class="findOne_td"><strong>작성일</strong> ${findOne.regDate}</td>
          </tr>
      </table>
      <div class="review">
        <p class="sub_txt inner">제목</p>
			${findOne.title}
        <input type="hidden" value="${noticeCommand.writer}">
        <p class="sub_txt inner">내용</p>
        	${findOne.content}
      </div>
      </c:forEach>
      <div class="btn_group2">
        <button type="button" onclick="gomain()" class="btn2">메인으로</button>
        <button type="button" onclick="godelete()" class="btn2">삭제</button>
      </div>
    </div>
    </div>
    </form:form>
    </div>
</body>
</html>
