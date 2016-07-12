package cherry.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseBaby<M extends BaseBaby<M>> extends Model<M> implements IBean {

	public void setId(java.lang.Long id) {
		set("id", id);
	}

	public java.lang.Long getId() {
		return get("id");
	}

	public void setName(java.lang.String name) {
		set("name", name);
	}

	public java.lang.String getName() {
		return get("name");
	}

	public void setSmallName(java.lang.String smallName) {
		set("smallName", smallName);
	}

	public java.lang.String getSmallName() {
		return get("smallName");
	}

	public void setSex(java.lang.Integer sex) {
		set("sex", sex);
	}

	public java.lang.Integer getSex() {
		return get("sex");
	}

	public void setBirthday(java.util.Date birthday) {
		set("birthday", birthday);
	}

	public java.util.Date getBirthday() {
		return get("birthday");
	}

	public void setBirthdayType(java.lang.Integer birthdayType) {
		set("birthdayType", birthdayType);
	}

	public java.lang.Integer getBirthdayType() {
		return get("birthdayType");
	}

	public void setBirthWeigth(java.lang.Double birthWeigth) {
		set("birthWeigth", birthWeigth);
	}

	public java.lang.Double getBirthWeigth() {
		return get("birthWeigth");
	}

}