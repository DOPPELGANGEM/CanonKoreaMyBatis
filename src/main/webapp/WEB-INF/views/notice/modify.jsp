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
    <main class="main main_notice" id="main_noticeModify">
      <div class="banner_wrap">
      	<h2>공지사항</h2>
      </div>
      <div class="container">
      	<h2 class="tit_txt">공지사항 수정</h2>
        <form action="/notice/modify.do" method="post">
      	<input type="hidden" name="noticeNo" value="${notice.noticeNo}"> 
	         <ul class="form_wrap">
	           <li class="form_item">
	             <label class="form_label" for="noticeTitle">제목</label>
	             <div class="form_field">
	                <input type="text" id="noticeTitle" name="noticeTitle" value="">
	             </div>
	           </li>
	           <li class="form_item">
	             <label class="form_label" for="noticeContents">내용</label>
	             <div class="form_field">
	              <textarea class="noticeContents" id="noticeContents" name="noticeContents" value="${notice.noticeContents}"></textarea>
	             </div>
	           </li>
	         </ul>
	        <div class="button_wrap">
	          <input type="submit" value="수정하기" class="btn_submit">
	        </div>
        </form>
      </div>
    </main>
    <!-- 푸터 -->
    <jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
  </body>
</html>