<!-- 头部开始 -->
<%@include file="../include/top-begin.jsp"%>
<!-- 自定义样式开始 -->
<link href="static/css/signin.css" rel="stylesheet">
<!-- 自定义样式结束 -->
<!-- 头部结束 -->
<%@include file="../include/top-end.jsp"%>
<!-- 内容开始 -->
<div class="signin">
	<div class="signin-head"><img src="images/test/head_120.png" alt="" class="img-circle"></div>
	<form class="form-signin" role="form">
		<input type="text" class="form-control" placeholder="用户名" required autofocus />
		<input type="password" class="form-control" placeholder="密码" required />
		<button class="btn btn-lg btn-warning btn-block" type="submit">登录</button>
		<label class="checkbox">
			<input type="checkbox" value="remember-me"> 记住我
		</label>
	</form>
</div>
<!-- 内容结束 -->
<!-- 自定义js开始 -->
<!-- 自定义js结束 -->
<!-- 尾部 -->
<%@include file="../include/buttom.jsp"%>