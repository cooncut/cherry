package cherry;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class UtilsTest {

	public static void main(String[] args) {

		System.out.println(testTel("+1-1-12", "+198-23"));
	}

	public static int testTel(String tele, String mobile) {
		int errorNum = -1;
		User user = new User();
		if (StringUtils.isNotBlank(tele)) {// 如果有电话号
			if (!tele.startsWith("+")) {// 没有国家号
				errorNum = 100;
			}
			String[] arr = tele.split("-");
			if (arr != null && arr.length > 1 && arr.length < 4) {// 输入合法
				// 得到传给UD的国家码编号
				user.setXmpager(arr[0]);
				String str = arr[1];
				for (int i = 2; i < arr.length; i++) {
					if (StringUtils.isNotBlank(arr[i])) {
						str += ("-" + arr[i]);
					}
				}
				user.setXmtel(str);// 得到电话并分割
			} else {
				errorNum = 101;// 电话字段不合法
			}
		}
		
		if(StringUtils.isNotBlank(mobile)){
			if (!mobile.startsWith("+")) {
				errorNum = 103;
			}
			String[] arr = mobile.split("-");
			if (arr != null && arr.length == 2) {// 输入合法
				user.setXmcell(arr[0] + "-" + arr[1]);
			} else {
				errorNum = 104;// 手机字段不合法
			}
		}
		System.out.println(user);
		return errorNum;
	}

	private static class User {
		private String xmpager;
		private String xmtel;
		private String xmcell;

		public String getXmpager() {
			return xmpager;
		}

		public void setXmpager(String xmpager) {
			this.xmpager = xmpager;
		}

		public String getXmtel() {
			return xmtel;
		}

		public void setXmtel(String xmtel) {
			this.xmtel = xmtel;
		}

		public String getXmcell() {
			return xmcell;
		}

		public void setXmcell(String xmcell) {
			this.xmcell = xmcell;
		}

		@Override
		public String toString() {
			return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
		}
	}
}
