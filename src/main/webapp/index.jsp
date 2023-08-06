<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <jsp:include page="/WEB-INF/views/common/head.jsp"></jsp:include>
  <body>
    <!-- 헤더 -->
    <jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
    <!-- 메인 -->
    <main class="main" id="main_login" >
      <div class="container">
        <h2 class="main_title_txt">로그인</h2>
        <div class="box_wrap">
          <p class="bold_txt"><strong>통합회원으로 전환하시고 <br>더욱 새로워진 캐논코리아를 만나보세요!</strong>
          </p>
          <p class="regular_txt">통합회원전환 이후에도 모든 서비스를 동일하게 이용하실 수 있습니다.</p>
          <div class="btn_wrap">
            <a href="" class="integrated_btn">통합회원전환 ></a>
          </div>
        </div>
        <form id="check_form" action="/member/login.do" method="post">
          <div class="input_wrap">
            <div class="input_field_area">
              <input type="text" placeholder="아이디" name="canon_id" id="canon_id" class="canon_input_id">
              <input type="password" placeholder="비밀번호" name="canon_pw" id="canon_pw" class="canon_input_pw">
            </div>
            <div class="remember_acc_wrap">
              <ul class="check_field_wrap">
                <li class="check_item">
                  <input type="checkbox" name="rember_check" id="acc_remind_01" class="check_alone">
                  <label for="acc_remind_01">아이디 기억</label>
                </li>
                <li class="check_item">
                  <input type="checkbox" name="rember_check" id="acc_remind_02" class="check_alone">
                  <label for="acc_remind_02">로그인 유지</label>
                </li>
              </ul>
              <ul class="menu_wrap">
                <li class="menu_item"><a href="">아이디 찾기</a></li>
                <li class="menu_item"><a href="">비밀번호 찾기</a></li>
                <li class="menu_item"><a href="/member/register.do">회원가입</a></li>
              </ul>
            </div>
          </div>
          <div class="big_btn_wrap">
            <a href="#" class="login_btn" onclick="chk_form()">로그인</a>
          </div>
        </form>
        <p class="add_txt">개인정보수정 페이지에서 SNS 로그인 연동 설정을 하시면 재방문 시 간편하게 로그인 가능합니다.</p>
      </div>
    </main>
    <!-- 푸터 -->
    <jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
    <script>
    	<!-- 특정헤더요소제거임시..-->
    	const selectTag = document.querySelector(".header_util_wrap");
    	console.log(selectTag);
    	selectTag.remove();
    </script>
  </body>
</html>