package cherry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.ListUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class IntBufferTest {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("1");
		Set<String> users = new LinkedHashSet<String>(Arrays.asList("".split(",")));
		users.addAll(list);
		System.out.println(users);
	}

}