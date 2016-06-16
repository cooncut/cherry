package cherry.utils;

import java.util.ArrayList;
import java.util.List;

public class MyListUtils {

	private MyListUtils() {
	}

	public static <T> List<T> removeBlank(List<T> list) {
		return new ArrayList<>(MyCollectionUtils.removeBlank(list));
	}

	public static <T> List<T> removeDuplicate(List<T> list) {
		return new ArrayList<>(MyCollectionUtils.removeDuplicate(list));
	}

	public static void main(String[] args) {
		List<String> str = new ArrayList<String>();
		str.add("1");
		str.add("1");
		str.add("3");
		str.add("4");
		System.out.println(removeDuplicate(str));
	}

}
