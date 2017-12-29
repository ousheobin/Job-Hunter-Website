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
				"username" : ("#username").val(),
				"password" : ("#password").val(),
				"phone" : ("#phone").val(),
				"vericode" : ("#vericode").val()
			},
			cache : false,
			dataType : "json",
			success : function(data){
				if(data.status == "ok"){
					window.location.href="index.html";
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