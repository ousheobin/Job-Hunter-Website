$("#apply-btn").click(function(){
	var company = $("#company").html();
	var job = $("#jobName").html();
	var hints = "您正在申请"+company+"的"+job+"职位，是否确定？";
	var resumeId = $("input[type='radio']:checked").val();

	if(resumeId!=null && resumeId.length > 0 && confirm(hints)){
		$.ajax({
			type : 'POST',
			url : "user/add_apply",
			data : {
				"jobId":jobId,
				"resumeId":resumeId
			},
			cache : false,
			dataType : "json",
			success : function(data) {
				if(data.status == "ok"){
					$("form").remove();
					$("button").remove();
					$(".new-resum").remove();
					$("#apply-title").html("申请成功!");
					$(".back").remove();
				}else{
					alert("申请失败，请稍后重试")
				}
			},
			error : function() {
				alert("无法和服务器通讯，请稍后尝试");
			}
		});
	}
});