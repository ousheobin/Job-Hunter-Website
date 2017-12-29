$("#rigisiterButton").click(function(){
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
	else if(("#password").val()!=("#password-repeat").val){
		alert("两次输入的密码不正确");
	}
	else {
		$.ajax({
			type : 'POST',
			url : "user_register",
			data : {
				username : ("#username").val(),
				password : ("#password").val(),
				phone : ("#phone").val()
			},
			cache : false,
			dataType : "json",
			success : function(data){
				if(data.status == "ok"){
					//注册成功，自动登陆
				}
				else {
					alert("错误："+data.message);
				}
			},
			error : function(){
				alert("无法和服务器通讯");
			}
		});
	}
});