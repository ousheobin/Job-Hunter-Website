var isSend = false;
$("#vericodeButton").click(function(){
	var hasNotFinish = false;
	var value = $("#phone").val();
	if(value == "" || value.length < 1){
		hasNotFinish = true;
	}
	if(hasNotFinish){
		alert("您还有内容没填写，请重新检查一下哦");
		return;
	}
	if(isSend){
		return;
	}
	$.ajax({
		type : 'POST',
		url : "getVericode",
		data : {
			"phone" : $("#phone").val()
		},
		cache:false,
		dataType:"json",
		success:function(data){
			if(data.status == "ok"){
				$("#vericodeButton").html("验证码已发送");
				$("#vericodeButton").addClass("disabled");
				isSend = true;
			}
			else {
				alter("错误："+data.message);
			}
		}
	});
});

$("#submitButton").click(function(){
	var hasNotFinish = false;
	var inputs = $(".login-panel").find("input");
	inputs.each(function() {
		var value = $(this).val();
		if(value == "" || value.length < 1){
			hasNotFinish = true;
		}
	});
	if(hasNotFinish){
		alert("您还有内容没填写，请重新检查一下哦");
	}
	if($("#password").val()!=$("#password-repeat").val()){
		alert("两次输入的密码不正确");
	}
	$.ajax({
		type : 'POST',
		url : "forget_password",
		data : {
			"username":$("#username").val(),
			"code":$("#vericode").val(),
			"phone":$("#phone").val(),
			"newPassword":$("#password").val()
		},
		success : function(data){
			if(data.status == "ok"){
				location.href="index.html";
			}
			else {
				alert("出错："+data.message);
			}
		},
		error:function(){
			alert("无法与服务器通讯");
		}
	});
});