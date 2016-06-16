package cherry;

public class UtilsTest {

	public static void main(String[] args) {

		String str = ",2,,,";

		String[] arr = str.split(",");

		for (int i = 0, len = arr.length; i < len; i++) {
			System.out.print(arr[i] + "\t");
		}
	}
}
