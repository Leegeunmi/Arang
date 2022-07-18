<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.net.URLEncoder" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<p>MENU</p>
<a href='<c:url value="/signup/logout"/>'>로그아웃</a><br>
<a href='<c:url value="/signup/login"/>'>로그인</a><br>
<a href='<c:url value="/signup/add_user_db.jsp"/>'>유저추가</a><br>
<a href='<c:url value="/signup/delete_user.jsp"/>'>유저삭제</a><br>
<a href='<c:url value="/signup/select_user.do"/>'>모든가입유저조회</a><br>
<a href='<c:url value="/signup/update_user.jsp"/>'>유저수정</a><br>
