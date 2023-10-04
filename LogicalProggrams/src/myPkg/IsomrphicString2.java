package myPkg;

import java.util.HashMap;
import java.util.Map;

public class IsomrphicString2 {
	public static void main(String[] args) {
		IsomrphicString2 is = new IsomrphicString2();
		boolean flag = is.isIsomorphic("egg", "add");
		if (flag) {
			System.out.println("The stings are isomorphic");
		} else {
			System.out.println("The stings are NOT isomorphic");
		}
	}

	private boolean isIsomorphic(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}
		Map<Character, Character> hm = new HashMap<>();

		for (int i = 0; i < str1.length(); i++) {
			if (hm.get(str1.charAt(i)) == null) {
				hm.put(str1.charAt(i), str2.charAt(i));
			} else {
				Character ch = hm.get(str1.charAt(i));
				if (!ch.equals(str2.charAt(i))) {
					return false;
				}
			}
		}

		return true;
	}
}
