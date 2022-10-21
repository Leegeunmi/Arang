<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <link rel="stylesheet" href="<c:url value='/resources/css/admin/admin.css'/>">
</head>

<body>
  <div id="header_wrap">
  <jsp:include page="/WEB-INF/views/header/header_main.jsp"/>
  </div>
  <div id="body_wrap3">
      <h3>신규 카테고리 추가</h3>
      <form:form class="list_form" method="post" modelAttribute="shopCategory">
        <!-- <div class="div_input"> -->
          <label>카테고리 이름</label>
          <form:input path="cateName"/>
        <!-- </div> -->
        <!-- <div class="div_input"> -->
          <label>카테고리 분류 코드1</label>
          <form:input path="cateCode"/>
        <!-- </div> -->
        <input type="submit" value="완료">
      </form:form>
</div>
</body>

</html>