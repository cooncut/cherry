package cherry;

import cherry.controller.UserC;
import cherry.controller.ViewC;
import cherry.model._MappingKit;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.i18n.I18nInterceptor;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.ViewType;

/**
 * 项目配置
 * 
 * @author wenjizou
 * 
 */
public class CherryConfig extends JFinalConfig {
	// 配置常量
	public void configConstant(Constants me) {
		// 加载少量必要配置，随后可用PropKit.get(...)获取值
		PropKit.use("app.txt");
		me.setDevMode(PropKit.getBoolean("devMode", false));
		me.setBaseViewPath("/WEB-INF/views/");
		me.setViewType(ViewType.JSP);
		me.setI18nDefaultBaseName("i18n");
	}

	// 配置路由
	public void configRoute(Routes me) {
		me.add("/", ViewC.class);
		me.add("/user", UserC.class);
	}

	public static C3p0Plugin createC3p0Plugin() {
		return new C3p0Plugin(PropKit.get("jdbc.url"), PropKit.get("jdbc.username"), PropKit.get("jdbc.password"));
	}

	// 配置插件
	public void configPlugin(Plugins me) {
		// 配置C3p0数据库连接池插件
		C3p0Plugin C3p0Plugin = createC3p0Plugin();
		me.add(C3p0Plugin);
		// 配置ActiveRecord插件
		ActiveRecordPlugin arp = new ActiveRecordPlugin(C3p0Plugin);
		me.add(arp);
		// 所有配置在 MappingKit 中搞定
		_MappingKit.mapping(arp);
	}

	// 配置拦截器
	public void configInterceptor(Interceptors me) {
		me.add(new I18nInterceptor());
	}

	// 配置处理器
	public void configHandler(Handlers me) {
	}

	public static void main(String[] args) {

	}
}
