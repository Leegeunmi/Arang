<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<%@page import="java.util.*"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%-- 개시판 목록(메인) --%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
	<hr width="500" color="blue" size="1" />
	<h3> 리스트</h3>
	<hr width="500" color="blue" size="1" />
	<div>
	<form>
	<fieldset>
		<legend>글 검색 필드</legend>
			<label>검색 분류</label>
			<select name="f">
				<option value="title">제목</option>
				<option value="writerId">작성자</option>
			</select>
			<label>검색어</label>
			<input type="text" name="q" value=""/>
			<input type="submit" value="검색"/>
			<a href='<c:url value="/signup/mypage.jsp"/>'>HOME TEST</a><br>
	</fieldset>
	</form>
	</div>

  <table width="800" cellpadding="0" cellspacing="0" border=1>
  	<!-- 제목 -->
  	<tr>
  		<td align="center" width=100>번호</td>
  		<td align="center">이름</td>
  		<td align="center" width=350>제목</td>
  		<td align="center">날짜</td>
  		<td align="center">조회</td>  		
  	</tr>
  	  	
  	<c:forEach items="${list}" var="dto"> 
  	<tr>
  		<td>${dto.bId}</td>
  		<td>${dto.bName}</td>
	<td>
  		    <c:forEach begin ="1" end="${dto.bIndent}"></c:forEach>
  			<a href ="view.do?bId=${dto.bId}">${dto.bTitle}</a>
  		</td>
  		<td>${dto.bDate}</td>
  		<td>${dto.bHit}</td>
  	</tr>
  	</c:forEach> 	
  	<tr>
  		<td colspan="5" align="right"><a href="/medici/write_view.do">글쓰기</a></td>
  	</tr>
  </table>

</center>

</body>
</html>