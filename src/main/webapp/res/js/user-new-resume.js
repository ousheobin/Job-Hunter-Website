$("#save-resume").click(function(){
	var inputs = $(".content").find("input");
	var textareas = $(".content").find("textarea");
	var hasNotFinish = false;
	inputs.each(function() {
		var value = $(this).val();
		if(value == "" || value.length < 1){
			hasNotFinish = true;
			$(this).parent().addClass("has-error");
		}
	});
	textareas.each(function() {
		var value = $(this).val();
		if(value == "" || value.length < 1){
			hasNotFinish = true;
			$(this).parent().addClass("has-error");
		}
	});
	if(hasNotFinish){
		alert("您还有内容没填写，请重新检查一下哦")
	}else{
		$.ajax({
			type : 'POST',
			url : "user/add_resume",
			data:{
				name:$("#name").val(),
				gender:$("input[name='gender']:checked").val(),
				phone:$("#name").val(),
				email:$("#email").val(),
				applyWork:$("#applyWork").val(),
				birthday:$("#birthday").val(),
				timeToWork:$("#timeToWork").val(),
				residence:$("#residence").val(),
				orginResidence:$("#orignResidence").val(),
				educationList:getEducation(),
				experienceList:getExperience(),
				evaluate:$("#evaluate").val(),
				projectExperience:$("#projectExperince").val()
			},
			cache : false,
			dataType : "json",
			success : function(data) {
				if(data.status == "ok"){
//					location.href="resume.html"
				}else{
					alert("出错了.Oops...");
				}
			},
			error : function() {
				alert("无法和服务器通讯，请稍后尝试");
			}
		});
	}
});