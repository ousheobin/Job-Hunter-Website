$("vericodeButton").click(function(){
	var hasNotFinish = false;
	var value = $("#phone").val();
	if(value == "" || value.length < 1){
		hasNotFinish = true;
	}
	if(hasNotFinish){
		alert("您还有内容没填写，请重新检查一下哦");
	}
	$.ajax({
		type : 'POST',
		url : "getVericode",
		data : {
			"phone" : ("#phone").val()
		},
		cache:false,
		dataType:"json",
		success:function(data){
			if(data.status == "ok"){
				//发送成功，修改button不能点击
			}
			else {
				alter("错误："+data.message);
			}
		}
	});
});

$("submitButton").click(function(){
	var hasNotFinish = false;
	textareas.each(function() {
		var value = $(this).val();
		if(value == "" || value.length < 1){
			hasNotFinish = true;
		}
	});
	if(hasNotFinish){
		alert("您还有内容没填写，请重新检查一下哦");
	}
	if(("#password").val()!=("#password-repeat").val()){
		alert("两次输入的密码不正确");
	}
	$.ajax({
		type : 'POST',
		url : "forget_password",
		data : {
			"username":("#username").val(),
			"code":("#vericode").val(),
			"phone":("#phone").val(),
			"newPassword":("#password").val()
		},
		success : function(data){
			if(data.status == "ok"){
				//修改密码成功，自动登陆
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