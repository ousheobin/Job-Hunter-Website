$("loginButton").click(function(){
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
	$.ajax({
		type : 'POST',
		url : "enterpise_login_confirm",
		data : {
			"username":("#username").val(),
			"password":("#password").val()
		},
		success:function(data){
			if(data.status == "ok"){
				//登陆成功，跳转index
			}
			else {
				alert("错误："+data.message);
			}
		},
		error:function(){
			alert("无法与服务器通讯");
		}
	});
});
