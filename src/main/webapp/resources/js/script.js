'use strict';

/* 05.통합회원가입(개인)  */
function doOpenCheck(chk) {
  let obj = document.getElementsByName('rember_check');
  for(let i = 0; i < obj.length; i++) {
    if(obj[i] !== chk) {
      obj[i].checked = false;
    } else {
      obj[i].checked = true;
    }
  }
}

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




















