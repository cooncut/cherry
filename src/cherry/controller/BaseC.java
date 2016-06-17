package cherry.controller;

import com.jfinal.core.Controller;
import com.jfinal.i18n.I18n;
import com.jfinal.i18n.Res;

public class BaseC extends Controller {
	// 资源信息
	protected Res res = I18n.use();
}
