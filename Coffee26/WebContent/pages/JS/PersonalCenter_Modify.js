/* =================================================================
				Personal Center (Modify)
				个人中心（用户和管理员）修改个人信息和密码
================================================================= */



/*修改个人信息*/
function showEditInfoTabel() {
	document.getElementById("info-table").style.display = "none";
	document.getElementById("edit-info-form").style.display = "";
	document.getElementById("edit-pwd-form").style.display = "none";
	document.getElementById("edit-info-table").style.display = "";
	document.getElementById("edit-pwd-table").style.display = "none";
	
	document.getElementById("modifyInfoBtn").style.display = "none";
	document.getElementById("modifyPwdBtn").style.display = "none";
	document.getElementById("confirmInfoBtn").style.display = "";
	document.getElementById("confirmPwdBtn").style.display = "none";
	document.getElementById("cancelModifyInfoBtn").style.display = "";
	document.getElementById("cancelModifyPwdBtn").style.display = "none";
};

/*确认修改个人信息*/
function confirmInfo(form) {
	var isConfirmed = confirm("确认修改？");
	if (isConfirmed == true) {
		return true;
	} else {
		return false;
	}
};

/*修改密码*/
function showEditPwdTabel() {
	document.getElementById("info-table").style.display = "none";
	document.getElementById("edit-info-form").style.display = "none";
	document.getElementById("edit-pwd-form").style.display = "";
	document.getElementById("edit-info-table").style.display = "none";
	document.getElementById("edit-pwd-table").style.display = "";
	
	document.getElementById("modifyInfoBtn").style.display = "none";
	document.getElementById("modifyPwdBtn").style.display = "none";
	document.getElementById("confirmInfoBtn").style.display = "none";
	document.getElementById("confirmPwdBtn").style.display = "";
	document.getElementById("cancelModifyInfoBtn").style.display = "none";
	document.getElementById("cancelModifyPwdBtn").style.display = "";
};

/*确认修改密码*/
function confirmPwd(form) {
	if (form.oldPwd.value == "") {
		alert("请输入原密码！");
		return false;
	} else if (form.newPwd1.value == "") {
		alert("请输入新密码！");
		return false;
	} else if (form.newPwd2.value == "") {
		alert("请确认新密码！");
		return false;
	} else if (form.newPwd1.value != form.newPwd2.value) {
		alert("新密码不一致！");
		return false;
	} else {
		var isConfirmed = confirm("确认修改？");
		if (isConfirmed == true) {
			return true;
		} else {
			return false;
		}
	}
};

/*取消修改*/
function cancelModifying() {
	document.getElementById("info-table").style.display = "";
	document.getElementById("edit-info-form").style.display = "";
	document.getElementById("edit-pwd-form").style.display = "none";
	document.getElementById("edit-info-table").style.display = "none";
	document.getElementById("edit-pwd-table").style.display = "none";
	
	document.getElementById("modifyInfoBtn").style.display = "";
	document.getElementById("modifyPwdBtn").style.display = "";
	document.getElementById("confirmInfoBtn").style.display = "none";
	document.getElementById("confirmPwdBtn").style.display = "none";
	document.getElementById("cancelModifyInfoBtn").style.display = "none";
	document.getElementById("cancelModifyPwdBtn").style.display = "none";
};




