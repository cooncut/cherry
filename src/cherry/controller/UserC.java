package cherry.controller;

import org.apache.commons.lang3.StringUtils;

import cherry.AppConst;
import cherry.model.User;
import cherry.service.UserS;
import cherry.vo.JsonResult;

import com.jfinal.core.Controller;
import com.jfinal.i18n.I18n;
import com.jfinal.i18n.Res;

/**
 * 用户控制器
 * 
 * @author wenjizou
 * 
 */
public class UserC extends Controller {

	// 业务层
	private UserS service = new UserS();

	// 登陆页面
	public void loginView() {
		renderJsp("login.jsp");
	}

	// 登陆操作
	public void login() {

		// 接收参数
		String username = getPara("username"), password = getPara("password");
		Res res = I18n.use();

		if (StringUtils.isBlank(username)) {// 验证用户名
			renderJson(new JsonResult().setErrMsg(res.get("UserC_login_001")));
			return;
		}
		if (StringUtils.isBlank(password)) {// 验证密码
			renderJson(new JsonResult().setErrMsg(res.get("UserC_login_002")));
			return;
		}

		// 进行数据库验证
		User user = service.findUser(username, password);
		if (user == null) {
			renderJson(new JsonResult().setErrMsg(res.get("UserC_login_003")));
			return;
		}
		// 将数据写入session
		setSessionAttr(AppConst.LOGIN_USER_KEY, user);
		// 写入登陆成功的表示
		renderJson(new JsonResult(true));
	}
}
