
$(document).ready(function(){
	$.ajax({
		type : 'GET',
		url : "user/apply_list",
		cache : false,
		dataType : "json",
		success : function(data) {
			if(data.status == "ok"){
				var html = "";
				$.each(data.applyList,function(index,item){
					html+= "<div class=\"list-group-item text-left\"><div class=\"row\"><div class=\"col-md-8 col-xs-8 col-sm-8\">"+
                                "<p class=\"job\">"+item.job.jobName+"</p><p class=\"company\">"+item.job.enterpise.enterpiseName+"</p>";
					if(item.hanle){
						if(item.offer){
							html += "</div> <div> <p class=\"status offer\">已通知面试</p> </div> </div> </div>";
						}else{
							html += "</div> <div> <p class=\"status refuse\">企业已回绝</p> </div> </div> </div>";
						}
					}else{
						html += "</div> <div> <p class=\"status not-handle\">企业未处理</p> </div> </div> </div>";
					}
					
				 });
				$("#apply-list").append(html);
			}else{
				alert("出错了.Oops...");
			}
		},
		error : function() {
			alert("无法和服务器通讯，请稍后尝试");
		}
	});
});