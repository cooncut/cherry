package cherry.controller;

import com.jfinal.core.Controller;

public class UserC extends Controller {

	public void login() {
		renderJsp("login.jsp");
	}

}
