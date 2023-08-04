<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <jsp:include page="/WEB-INF/views/common/head.jsp"></jsp:include>
  <body>
  	<!-- 헤더 -->
    <jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
    <!-- 메인 -->
    <main class="main main_notice" id="main_insert">
      <div class="banner_wrap">
      	<h2>공지사항</h2>
      </div>
      <div class="container">
      	<h2 class="tit_txt">공지사항 입력</h2>
        <form action="/notice/insert.do" method="post">
         <ul class="form_wrap">
           <li class="form_item">
             <label class="form_label" for="canonTitle">제목</label>
             <div class="form_field">
                <input type="text" id="canonTitle" name="canonTitle">
             </div>
           </li>
           <li class="form_item">
             <label class="form_label" for="canonContents">내용</label>
             <div class="form_field">
              <textarea id="canonContents" class="txt_contents" name="canonContents" maxlength="50"></textarea>
             </div>
           </li>
         </ul>
        <div class="button_wrap">
          <input type="submit" value="신청하기" class="btn_submit">
        </div>
        </form>
      </div>
    </main>
    <!-- 푸터 -->
    <jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
  </body>
</html>