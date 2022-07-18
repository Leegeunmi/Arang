<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.net.URLEncoder" %>
<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
  <title>작가 등록 신청</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">
  <link rel="stylesheet" href="../design/css_add_user/normalize.css">
  <link rel="stylesheet" href="../design/css_add_user/default.css">
  <link rel="stylesheet" href="../design/css_add_user/style.css">
  <script type="text/javascript" src="../design/js_add_user/jquery.min.js"></script>
  <script type="text/javascript" src="../design/js_add_user/common.js"></script>
</head>
<body>
  <div id="wrap">
    <header id="header">
      <div class="inner">
        <!-- 로고 -->
        <h1 id="top-logo">
          <a href="index.html">ARANG</a>
        </h1>
        <!-- 메인메뉴 -->
        <nav id="top-nav">
          <ul class="center_menu">
            <li><a href="./artists/artists.html">Artists</a></li>
            <li><a href="./gallerys/gallerys.html">Gallerys</a></li>
            <li><a href="./exhibitions/exhibitions.html">Exhibitions</a></li>
            <li><a href="./storage/storage.html">Storage</a></li>
            <li><a href="./notice/notice.html">Notice</a></li>
          </ul>
          <ul class="side_menu">
            <li><a href="#"><img class="top-img" src="./img/find.png"></a></li>
            <li><a href="#"><img class="top-img" src="./img/mypage.png"></a></li>
            <li><a href="#"><img class="top-img" src="./img/like.png"></a></li>
            <li><a href="#"><img class="top-img" src="./img/cart.png"></a></li>
          </ul>
        </nav>
      </div>
    </header>
    <div class="title">
      <h1>작가 등록 신청</h1>
    </div>
    <form action="add_user_db.do" method="post">
      <table class="table_a">
        <tr>
          <td>
            <em>&ast;</em>아이디
          </td>
          <td>
            <input type="text" class="middle" placeholder="8~12자까지" name="userId"/>
            <button class="gbtn transparent">중복확인</button>
          </td>
        </tr>
        <tr>
          <td>
            <em>&ast;</em>비밀번호
          </td>
          <td>
            <input type="password" class="middle" placeholder="8~12자까지" name="passwd"/>
          </td>
        </tr>
        <tr>
          <td>
            <em>&ast;</em>이름
          </td>
          <td>
            <input type="text" class="middle" placeholder="주민등록상 이름을 입력해주세요." name="koreanName"/>
          </td>
        </tr>
        <tr>
          <td>
            <em>&ast;</em>영문성명
          </td>
          <td>
            <input type="text" class="middle" name="englishName"/>
          </td>
        </tr>
        <tr>
          <td>
            <em>&ast;</em>생년월일
          </td>
          <td>
            <select id="yearBox" class="middle" name="ssnYear"></select><p>&nbsp;년&nbsp;</p>
            <select class="middle" name="ssnMonth">
              <option value="1월">1</option>
              <option value="2월">2</option>
              <option value="3월">3</option>
              <option value="4월">4</option>
              <option value="5월">5</option>
              <option value="6월">6</option>
              <option value="7월">7</option>
              <option value="8월">8</option>
              <option value="9월">9</option>
              <option value="10월">10</option>
              <option value="11월">11</option>
              <option value="12월">12</option>
            </select><p>&nbsp;월&nbsp;</p>
            <select class="middle" name="ssnDay">
              <option value="1일">1</option>
              <option value="2일">2</option>
              <option value="3일">3</option>
              <option value="4일">4</option>
              <option value="5일">5</option>
              <option value="6일">6</option>
              <option value="7일">7</option>
              <option value="8일">8</option>
              <option value="9일">9</option>
              <option value="10일">10</option>
              <option value="11일">11</option>
              <option value="12일">12</option>
              <option value="13일">13</option>
              <option value="14일">14</option>
              <option value="15일">15</option>
              <option value="16일">16</option>
              <option value="17일">17</option>
              <option value="18일">18</option>
              <option value="19일">19</option>
              <option value="20일">20</option>
              <option value="21일">21</option>
              <option value="22일">22</option>
              <option value="23일">23</option>
              <option value="24일">24</option>
              <option value="25일">25</option>
              <option value="26일">26</option>
              <option value="27일">27</option>
              <option value="28일">28</option>
              <option value="29일">29</option>
              <option value="30일">30</option>
              <option value="31일">31</option>
            </select><p>&nbsp;일&nbsp;</p>
          </td>
        </tr>
        <tr>
          <td>
            <em>&ast;</em>최종 학력
          </td>
          <td>
            <label for="ck"><input type="radio" id="ck" name="ck">&nbsp;&nbsp;고등학교졸업이하&nbsp;&nbsp;</label>
            <label for="ck"><input type="radio" id="ck" name="ck">&nbsp;&nbsp;고등학교졸업&nbsp;&nbsp;</label>
            <label for="ck"><input type="radio" id="ck" name="ck">&nbsp;&nbsp;대학교졸업(2,3년제)&nbsp;&nbsp;</label>
            <label for="ck"><input type="radio" id="ck" name="ck">&nbsp;&nbsp;대학교졸업(4년제)&nbsp;&nbsp;</label>
            <label for="ck"><input type="radio" id="ck" name="ck">&nbsp;&nbsp;대학원 석사졸업&nbsp;&nbsp;</label>
            <label for="ck"><input type="radio" id="ck" name="ck">&nbsp;&nbsp;대학원 박사졸업&nbsp;&nbsp;</label>
          </td>
        </tr>
        <tr>
          <td>
            <em>&ast;</em>학과
          </td>
          <td>
            <input type="text" class="small" name="acaBackGround"/>
          </td>
        </tr>
        <tr>
          <td>
            <em>&ast;</em>경력연도
          </td>
          <td>
            <label for="careerYear"><input type="radio" name="careerYear">&nbsp;&nbsp;1년이하&nbsp;&nbsp;</label>
            <label for="careerYear"><input type="radio" name="careerYear">&nbsp;&nbsp;1~3년&nbsp;&nbsp;</label>
            <label for="careerYear"><input type="radio" name="careerYear">&nbsp;&nbsp;3~5년&nbsp;&nbsp;</label>
            <label for="careerYear"><input type="radio" name="careerYear">&nbsp;&nbsp;5~10년&nbsp;&nbsp;</label>
            <label for="careerYear"><input type="radio" name="careerYear">&nbsp;&nbsp;10년이상&nbsp;&nbsp;</label>
          </td>
        </tr>
        <tr>
          <td>
            <em>&ast;</em>경력사항
          </td>
          <td>
            <label for="careerType"><input type="radio" name="careerType">&nbsp;&nbsp;개인전&nbsp;&nbsp;</label>
            <label for="careerType"><input type="radio" name="careerType">&nbsp;&nbsp;단체전&nbsp;&nbsp;</label>
            <label for="careerType"><input type="radio" name="careerType">&nbsp;&nbsp;기타&nbsp;&nbsp;</label>
          </td>
        </tr>
        <tr>
          <td>
            <em>&ast;</em>갤러리 소속 여부
          </td>
          <td>
            <label for="company"><input type="radio" name="company">&nbsp;&nbsp;O&nbsp;&nbsp;</label>
            <label for="company"><input type="radio" name="company">&nbsp;&nbsp;X&nbsp;&nbsp;</label>
          </td>
        </tr>
        <tr>
          <td>
            <em>&ast;</em>포트폴리오
          </td>
          <td>
            <input type="file" class="middle">
          </td>
        </tr>
        <tr>
          <td>
            <em>&ast;</em>메인장르
          </td>
          <td>
            <select>
              <option value="조각">조각</option>
              <option value="회화">회화</option>
              <option value="동양화">동양화</option>
              <option value="소묘화">소묘화</option>
              <option value="사진">사진</option>
              <option value="일러스트">일러스트</option>
              <option value="디지털아트">디지털아트</option>
              <option value="기타">기타</option>
            </select>
          </td>
        </tr>
        <tr>
          <td>
            <em>&ast;</em>작품 평균 판매가
          </td>
          <td>
            <input type="text" class="small">
          </td>
        </tr>
        <tr>
          <td>
            <em>&ast;</em>지난 1년간 작품 판매 횟수
          </td>
          <td>
            <label label for="salesRate"><input type="radio" name="salesRate">&nbsp;없음&nbsp;</label>
            <label label for="salesRate"><input type="radio" name="salesRate">&nbsp;1~3개&nbsp;</label>
            <label label for="salesRate"><input type="radio" name="salesRate">&nbsp;3~5개&nbsp;</label>
            <label label for="salesRate"><input type="radio" name="salesRate">&nbsp;5개이상&nbsp;</label>
          </td>
        </tr>
        <tr>
          <td>
            <em>&ast;</em>대표작품 첨부
          </td>
          <td>
            <input type="file" class="middle">
          </td>
        </tr>
        <tr>
          <td>
            <em>&ast;</em>전화번호
          </td>
          <td>
            <input type="text" class="tiny"><i>-</i><input type="text"
             class="tiny"><i>-</i><input type="text" class="tiny" >
          </td>
        </tr>
        <tr>
          <td>
            <em>&ast;</em>이메일
          </td>
          <td>
            <input type="email"class="small" name="email"/>
          </td>
        </tr>
        <tr>
          <td>
            <em>&ast;</em>SNS
          </td>
          <td>
            <input type="text" class="small">
          </td>
        </tr>
      </table>
      <p class="bot-p"><input type="checkbox">본인은 이 양식에 제공된 정보가 진실하고 완전하며 정확하다는 것을 확인합니다.</p>
      <div class="button-group">
        <button class="gbtn normal">제출</button>
        <a href='<c:url value="/signup/mypage.jsp"/>'>
        <button class="gbtn normal gray"><a href='<c:url value="/signup/mypage.jsp"/>'>취소</a></button>
      </div>
    </form>
  </div>
  
</body>

</body>
</html>