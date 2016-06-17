package cherry.controller;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import cherry.AppConst;
import cherry.model.User;
import cherry.service.UserS;
import cherry.vo.JsonResult;

/**
 * 用户控制器
 * 
 * @author wenjizou
 * 
 */
public class UserC extends BaseC {

	// 业务层
	private UserS service = new UserS();
	
	// 登陆页面
	public void loginView() {
		
		//设置页面标题
		setAttr("pageTitle", res.get("UserC_loginView_001"));
		
		User user = getSessionAttr(AppConst.LOGIN_USER_KEY);
		String cookieJmVal = getCookie(DigestUtils.md5Hex(AppConst.COOKIE_USER_KEY));
		if (user != null) {// 先从session中看是否能得到值
			setAttr("username", user.getEmail());
		} else if (StringUtils.isNotBlank(cookieJmVal)) {// 如果cookie中有值
			byte[] data = Base64.decodeBase64(cookieJmVal.getBytes(Charset.forName("utf-8")));
			try {
				String cookieVal = new String(data, "utf-8");
				String[] arr = cookieVal.split("@@");
				setAttr("username", arr[0]);
				// setAttr("password", arr[1]);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		renderJsp("login.jsp");
	}

	// 登陆操作
	public void login() {

		// 接收参数
		String username = getPara("username"), password = getPara("password");

		if (StringUtils.isBlank(username)) {// 验证用户名
			renderJson(new JsonResult().setErrMsg(res.get("UserC_login_001")));
			return;
		}
		if (StringUtils.isBlank(password)) {// 验证密码
			renderJson(new JsonResult().setErrMsg(res.get("UserC_login_002")));
			return;
		}

		// 进行数据库验证
		User user = service.findUser(username, DigestUtils.md5Hex(password));
		if (user == null) {
			renderJson(new JsonResult().setErrMsg(res.get("UserC_login_003")));
			return;
		}

		// 如果有记住我，就记住我一周，
		boolean rememberMe = getParaToBoolean("rememberMe");
		if (rememberMe) {
			String key = DigestUtils.md5Hex(AppConst.COOKIE_USER_KEY);
			String val = Base64.encodeBase64String((username + "@@" + password).getBytes(Charset.forName("utf-8")));
			setCookie(key, val, 7 * 24 * 3600, true);// 设置为一周时间
		}

		// 将数据写入session
		setSessionAttr(AppConst.LOGIN_USER_KEY, user);
		// 写入登陆成功的表示
		renderJson(new JsonResult(true));
	}

	// 用户主页home.jsp
	public void homeJsp() {
		//设置页面标题
		setAttr("pageTitle", res.get("UserC_homeJsp_001"));
		renderJsp("home.jsp");
	}
}
