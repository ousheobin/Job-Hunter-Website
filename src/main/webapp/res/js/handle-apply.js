$("#acceptBtn").click(function(){
	if(confirm("是否通过本简历")){
		$.ajax({
			type : 'POST',
			url : "enterpise/handle_apply",
			data : {
				"id":id,
				"flag":"accept"
			},
			cache : false,
			dataType : "json",
			success : function(data) {
				if(data.status == "ok"){
					window.location = "mgr-apply.html";
				}else{
					alert(data.message);
				}
			},
			error : function() {
				alert("无法和服务器通讯，请稍后尝试");
			}
		});
		
	}
});

$("#refuseBtn").click(function(){
	if(confirm("是否拒绝本简历")){
		$.ajax({
			type : 'POST',
			url : "enterpise/handle_apply",
			data : {
				"id":id,
				"flag":"refuse"
			},
			cache : false,
			dataType : "json",
			success : function(data) {
				if(data.status == "ok"){
					window.location = "mgr-apply.html";
				}else{
					alert(data.message);
				}
			},
			error : function() {
				alert("无法和服务器通讯，请稍后尝试");
			}
		});
	}
});
