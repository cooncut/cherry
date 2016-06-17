package cherry;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

public class UtilsTest {

	public static void main(String[] args) {

		String str = "";
		
		String[] arr = str.split(",");
		//System.out.println(arr[0]);
		
		System.out.println(DigestUtils.md5Hex("admin"));
		System.out.println(Base64.encodeBase64String("admin".getBytes()));
	}
}
