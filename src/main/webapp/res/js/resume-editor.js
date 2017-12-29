$("#add-experience").click(function(){
	var newCell = '<div class="list-group-item experience"><div class="form-group"><label>公司名称</label>'+
		'<input class="form-control" placeholder="请输入公司名称" type="text" name="companyName"></div><div class="form-group">'+
		'<label>开始时间</label><input class="form-control" placeholder="请输入开始时间" type="text" name="beginTime"></div>'+
		'<div class="form-group"><label>结束时间</label><input class="form-control" placeholder="请输入结束时间" type="text" name="endTime">'+
		'</div><div class="form-group"><label>所在行业</label><input class="form-control" placeholder="请输入所在行业" type="text" name="industry"></div>'+
		'<div class="form-group"><label>工作描述</label><textarea class="form-control" rows="5" placeholder="请输入工作描述" type="text" name="describe"></textarea>'+
		'</div></div>';
	$("#add-experience-container").before(newCell);
});

$("#add-education").click(function(){
	var newCell = '<div class="list-group-item education"><div class="form-group"><label>学校名称</label>'+
					'<input class="form-control" placeholder="请输入学习名称" type="text" name="schoolName"></div><div class="form-group">'+
					'<label>入学时间</label><input class="form-control" placeholder="请输入入学时间" type="text" name="enrollmentTime"></div>'+
					'<div class="form-group"><label>毕业时间</label><input class="form-control" placeholder="请输入毕业时间" type="text" name="graduateTime">'+
					'</div><div class="form-group" name="graduateTime"><label>专业</label><input class="form-control" placeholder="请输入专业名称" type="text" name="major">'+
					'</div><div class="form-group"><label>学位学历</label><select class="form-control" name="degree"><option>小学</option><option>初中</option>'+
					'<option>高中</option><option>专科</option><option selected>本科</option><option>硕士</option><option>博士</option><option>博士后'+
					'</option></select></div></div>'
	$("#add-education-container").before(newCell);
});

function getExperience() {
	var elements = $('.experience');
	experience_list = []
	elements.each(function() {
		var options = {};
		var inputs = $(this).find("input");
		inputs.each(function() {
			options[$(this).attr("name")] = $(this).val();
		});
		var selects = $(this).find('select');
		selects.each(function() {
			options[$(this).attr("name")] = $(this).val();
		});
		experience_list.push(options);
	});
	return JSON.stringify(experience_list);
}

function getEducation() {
	var elements = $('.education');
	education_list = []
	elements.each(function() {
		var options = {};
		var inputs = $(this).find("input");
		inputs.each(function() {
			options[$(this).attr("name")] = $(this).val();
		});
		var selects = $(this).find('select');
		selects.each(function() {
			options[$(this).attr("name")] = $(this).val();
		});
		education_list.push(options);
	});
	return JSON.stringify(education_list);
}