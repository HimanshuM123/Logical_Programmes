package string;

public class CamelCase {

	public static void main(String[] args) {
		String str = "saveChangesInTheEditor";
		int res = getCamel(str);
		System.out.println(res);

	}

	private static int getCamel(String str) {
		int count = 1;
		for (Character ch : str.toCharArray()) {
			if (Character.isUpperCase(ch)) {
				count++;
			}
		}
		return count;

	}

}
