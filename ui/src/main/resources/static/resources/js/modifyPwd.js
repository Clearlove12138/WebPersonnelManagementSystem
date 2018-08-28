var msgBox = {
	count : 0,
	init : function(msg, icon) {
		this.count++;
		if ('ok' == icon) {
			icon = 'icon-success';
		} else if ('no' == icon) {
			icon = 'icon-warning';
		}
		var warning = '<div class="ifly-tips-box" id="ifly-tips-box-'
				+ this.count + '"><div class="ifly-' + icon + '"></div>' + msg
				+ '</div>';
		$('body').append(warning);
		if (warning) {
			setTimeout("$('#ifly-tips-box-" + this.count + "').remove()", 2000)
		}
	},
	loading : function(options) {
		/**
		 * loading加载，手动关闭，flag等于false关闭，等于true或为空显示
		 * 
		 * @msg loading加载
		 * @icon icon-loading 加载
		 */
		var defaults = {
			flag : true,
			msg : ''
		};
		var opts = $.extend({}, defaults, options);
		this.count++;
		if (opts.flag) {
			var warning = '<div class="ifly-tips-box-view"><div class="ifly-tips-box-shadow"></div><div class="ifly-tips-box"><div class="ifly-icon-loading"></div>'
					+ opts.msg + '</div></div>';
			top.$('body').append(warning);
		} else {
			top.$(".ifly-tips-box-view").remove();
		}
	}
};
$(function() {

		})

// 保存
function savePwd() {
	if ($.trim($("#username").val()) == "") {
		msgBox.init('请填写用户名', 'no');
		$("#username").focus();
		return false;
	}
	if ($.trim($("#password").val()) == "") {
		msgBox.init('请填写原密码', 'no');
		$("#password").focus();
		return false;
	}
	if ($.trim($("#newPwd").val()) == "") {
		msgBox.init('请填写新密码', 'no');
		$("#newPwd").focus();
		return false;
	}
	if ($.trim($("#confirmPwd").val()) == "") {
		msgBox.init('请填写确认密码', 'no');
		$("#confirmPwd").focus();
		return false;
	}

	// 判断和确认密码是否相同
	if ($("#newPwd").val() != $.trim($("#confirmPwd").val())) {
		msgBox.init('两次密码输入不同', 'no');
		$("#confirmPwd").focus();
		return false;
	}

	// 老和新密码是否相同
	if ($("#newPwd").val() == $.trim($("#password").val())) {
		msgBox.init('新老密码不可相同', 'no');
		$("#newPwd").focus();
		return false;
	}

	var param = {
		username : $("#username").val(),
		password : $("#password").val(),
		newPwd : $("#newPwd").val()
	};
	msgBox.loading({
				flag : true,
				msg : '保存中…'
			});
	$.ajax({
				url : ctx + '/changePwd',
				data : JSON.stringify(param),
				type : 'POST',
				contentType : "application/json;charset=UTF-8",
				dataType : 'html',
				success : function(data) {
					msgBox.loading({
						flag : false
					});
					msgBox.init(data, 'no');
				},
				error : function(error) {
					msgBox.loading({
								flag : false
							});
					msgBox.init("操作失败", 'no');
				}
			})
}
