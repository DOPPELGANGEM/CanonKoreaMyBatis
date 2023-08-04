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
    <main class="main" id="main_mypage">
     <div class="container">
       <form action="/member/update.do" method="post">
	         <h2>마이페이지</h2>
	         <ul>
	           <li class="info_line">
	             <label for="member-id">아이디</label>
	             <input type="text" id="member-id" name="member-id" value="${member.canonMemId}"> <!-- 보기만하세요 readonly -->
	           </li>
	           <li class="info_line">
	             <label for="member-pw">비밀번호</label>
	             <input type="password" id="member-pw" name="member-pw">
	           </li>
	           <li class="info_line">
	             <label for="member-name">이름</label>
	             <input type="text" id="member-name" name="member-name" value="${member.canonMemName}" readonly>
	           </li>
	           <li class="info_line">
	             <label for="member-age">나이</label>
	             <input type="text" id="member-age" name="member-age" value="${member.canonMemAge}" readonly>
	           </li>
	           <li class="info_line">
    	          <label for="member-gender">성별 :</label>
<%--     	          <input type="hidden" id="member-gender" name="member-gender" value="${member.canonMemGender}"> --%>
<%-- 	              <c:if test="${member.canonMemGender eq 'M'}">남자</c:if> --%>
<%-- 	         	  <c:if test="${member.canonMemGender eq 'F'}">여자</c:if> --%>
    	          <div class="check_radio">
    	           남<input type="radio" id="member-gender" name="member-gender" value="M" <c:if test="${member.canonMemGender eq 'M' }">checked</c:if>>
    	           여<input type="radio" id="" name="member-gender" value="F" <c:if test="${member.canonMemGender eq 'F' }">checked</c:if>>
    	          </div>				
	            </li>
	           <li class="info_line">
	             <label for="member-email">이메일</label>
	             <input type="text" id="member-email" name="member-email" value="${ member.canonMemEmail }">
	           </li>
	           <li class="info_line">
	             <label for="member-phone">전화번호</label>
	             <input type="text" id="member-phone" name="member-phone" value="${ member.canonMemPhone }">
	           </li> 
	           <li class="info_line">
	             <label for="member-address">주소</label>
	             <input type="text" id="member-address" name="member-address" value="${ member.canonMemAddr }">
	           </li>
	           <li class="info_line">
	             <label for="member-hobby">취미</label>
	             <input type="text" id="member-hobby" name="member-hobby" value="${ member.canonMemHobby }">
	           </li>
	           <li class="info_line">
	             <label for="member-hobby">가입날짜</label>
	             <input type="text" id="member-hobby" name="member-hobby" value="${ member.memberDate }" readonly>
	           </li>
	         </ul>
	        <div class="btn_wrap">
     			<button class="btn_update">수정하기</button>
     			<a href="javascript:void(0)" onclick="checkDelete();" class="btn_delete">탈퇴하기</a> <%-- sessionScope 생략가능 --%>
       		</div>
         </form>
	  </div>
	</main>
    <!-- 푸터 -->
    <jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
     <script>
     function checkDelete(){
		const canonMemberId = '${sessionScope.canonMemId}';
		if(confirm("탈퇴하시겠습니까?")){
			location.href = "/member/delete.do?memberId="+canonMemberId;
		}
	  }
     </script>
  </body>
</html>