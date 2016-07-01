(function(exports, $) {
	// 页面加载完成时候调用
	$(function() {
		//绑定登陆按钮
		$("#loginBtn").click(fnLogin);
		//绑定enter事件
		$(document).keydown(function(event){ 
			if(event.keyCode == 13){ fnLogin(); } 
		}); 
	});

	// 登陆方法
	function fnLogin() {
		
		var username = $v("username").trim();
		var password = $v("password").trim();
		var rememberMe = $("#rememberMe").prop('checked');
		
		if(fnCheckParams(username, password)){//检查参数
			
			var o = {};
			o.username = username;
			o.password = password;
			o.rememberMe = rememberMe;
			
			//ajax请求登陆操作
			var loading = layer.load();
			$.post('user/login', o, function(json){
				layer.close(loading);
				if(!json) return;
				if(json.success){
					//跳到首页
					location.href = 'home';
				}else{
					layer.alert(json.errMsg, { icon : 2 });
				}
			}, 'json');
		}
	}
	
	function fnCheckParams(uname, pass){
		if(!uname){
			layer.alert('请输入用户名', { icon : 7 });
			return false;
		}
		if(!pass){
			layer.alert('请输入密码', { icon : 7 });
			return false;
		}
		return true;
	}
	
})(this, jQuery);