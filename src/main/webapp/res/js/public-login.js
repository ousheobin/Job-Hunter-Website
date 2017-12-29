$("#login").click(function() {
	var username = $("#username").val();
	var password = $("#password").val();
	$(".has-error").removeClass("has-error");
	if (username == "" || username.length < 1 ) {
		alert("请输入用户名");
		$("#username").parent().addClass("has-error");
		return;
	}
	if (password == "" ||  password.length < 1) {
		alert("请输入密码");
		$("#password").parent().addClass("has-error");
		return;
	}
	$.ajax({
		type : 'POST',
		url : "public/login_comfirm",
		data : {
			"username":username,
			"password":password
		},
		cache : false,
		dataType : "json",
		success : function(data) {
			if(data.status == "ok"){
				window.location = data.nextStep;
			}else{
				alert(data.message);
			}
		},
		error : function() {
			alert("无法和服务器通讯，请稍后尝试");
		}
	});
});
