<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <!DOCTYPE html>
<html>
  <jsp:include page="/WEB-INF/views/common/head.jsp"></jsp:include>
  <body>
    <!-- 헤더 -->
    <jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
    <!-- 메인 -->
    <main class="main" id="main_register">
      <div class="container">
        <form action="/member/register.do" method="post">
          <h2>회원가입</h2>
          <ul class="user_info_wrap">
            <li class="info_line">
              <label for="member-id">아이디</label>
              <input type="text" id="member-id" name="member-id">
            </li>
            <li class="info_line">
              <label for="member-pw">비밀번호</label>
              <input type="password" id="member-pw" name="member-pw">
            </li>
            <li class="info_line">
              <label for="member-name">이름</label>
              <input type="text" id="member-name" name="member-name">
            </li>
            <li class="info_line">
              <label for="member-age">나이</label>
              <input type="text" id="member-age" name="member-age">
            </li>
            <li class="info_line info_gender">
              <label for="member-gender">성별</label>
              <div class="check_radio">
                남<input type="radio" id="member-gender" name="member-gender" value="M">
                여<input type="radio" id="member-gender" name="member-gender" value="F">
              </div>
            </li>
            <li class="info_line">
              <label for="member-email">이메일</label>
              <input type="text" id="member-email" name="member-email">
            </li>
            <li class="info_line">
              <label for="member-phone">전화번호</label>
              <input type="text" id="member-phone" name="member-phone">
            </li>
            <li class="info_line">
              <label for="member-address">주소</label>
              <input type="text" id="member-address" name="member-address">
            </li>
            <li class="info_line">
              <label for="member-hobby">취미</label>
              <input type="text" id="member-hobby" name="member-hobby">
            </li>
          </ul>
          <div class="btn_wrap">
            <input type="submit" value="가입하기" class="btn_submit">
            <input type="reset" value="초기화" class="btn_reset">
          </div>
        </form>
      </div>
    </main>
    <!-- 푸터 -->
    <jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
  </body>
</html>