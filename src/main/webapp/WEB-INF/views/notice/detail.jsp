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
	<main class="main main_notice" id="main_detail">
      <div class="banner_wrap">
        <h2>공지사항</h2>
      </div>
      <div class="container">
      	<h2 class="tit_txt">공지사항 상세</h2>
        <form action="/notice/detail.do" method="post">
           <div class="detail_title">
             <h3>번호 : ${notice.canonNoticeNumber}</h3>
             <p class="tit_tit">제목 : ${notice.canonNoticeTitle}</p>
             <span>등록일 : ${notice.canonRegDate}</span>
           </div>
           <div class="det_cotent">
             <p>${notice.canonContents}</p>
           </div>
        	<div class="button_wrap">
	        	<a class="btn btn_1" href="/notice/list.do">목록</a>
		      	<a class="btn btn_2" href="/notice/modify.do?canonNoticeNumber=${notice.canonNoticeNumber}">수정하기</a><br>
		    	<a class="btn btn_3" href="javascript:void(0)" onclick="deleteCheck();">삭제하기</a> 
       		</div>
         </form>
      </div>
   </main>
    <!-- 푸터 -->
    <jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
    <script>
	    const deleteCheck = () => {
	    	const CanonNoticeNo = '${notice.canonNoticeNumber}';
	    	if(confirm("정말로 삭제하시겠습니까?")) {
	    		location.href = "/notice/delete.do?canonNoticeNumber="+CanonNoticeNo;
	    	}
	    }	
    </script>  
  </body>
</html>