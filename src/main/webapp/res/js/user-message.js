$(".delete").click(function(){
	var id = $(".delete").attr("delete-id");
	console.log(id);
	$.ajax({
		type : 'POST',
		url : "user/message_delete",
		data:{
			messageId:id
		},
		cache : false,
		dataType : "json",
		success : function(data) {
			if(data.status == "ok"){
				location.reload(true);
			}else{
				alert("出错了.Oops...");
			}
		},
		error : function() {
			alert("无法和服务器通讯，请稍后尝试");
		}
	});
});