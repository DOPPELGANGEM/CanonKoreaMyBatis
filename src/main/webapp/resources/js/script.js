'use strict';

/* 로그인 */
function chk_form() {
	
	if(document.getElementById("acc_remind_01").value ==""){
		alert("성명을 입력해주십시오.");
		return false;
	}
	if(document.getElementById("acc_remind_02").value ==""){
		alert("비밀번호를 입력해주십시오.");
		return false;
	}
//	if (!$('input[name=rember_check]:checked').val()) {
//		alert('개인정보 활용에 동의해주십시오.');
//		return false;
//	}

	document.getElementById("check_form").submit();
}















