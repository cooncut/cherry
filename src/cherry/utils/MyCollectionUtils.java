package cherry.utils;

import java.util.Collection;
import java.util.LinkedHashSet;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.lang3.StringUtils;

/**
 * 我的集合操作工具类
 * 
 * @author wenjizou
 * 
 */
public class MyCollectionUtils {

	private MyCollectionUtils() {
	}

	/**
	 * 去除一个集合中的null或者空白字符
	 * 
	 * @param coll
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> Collection<T> removeBlank(Collection<T> coll) {
		return CollectionUtils.select(coll, new Predicate() {
			public boolean evaluate(Object one) {// 返回true表示允许
				if (one == null)
					return false;
				if (one.getClass() == String.class)
					return StringUtils.isNotBlank(one.toString());
				return true;
			}
		});
	}

	/**
	 * 去除一个集合中的重复元素
	 * 
	 * @param coll
	 * @return
	 */
	public static <T> Collection<T> removeDuplicate(Collection<T> coll) {
		return new LinkedHashSet<>(coll);
	}

	public static void main(String[] args) {
		// List<String> list = new ArrayList<>();
		// System.out.println(removeBlank(null));
	}

}
