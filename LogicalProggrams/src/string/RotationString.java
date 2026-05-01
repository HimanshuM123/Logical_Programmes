package string;

public class RotationString {

	public static void main(String[] args) {
		String s1 = "JavaJ2eeStrutsHibernate";

		String s2 = "StrutsHibernateJavaJ2ee";

		String s3 = s1 + s2;

		if (s3.contains(s1)) {
			System.out.println("Strings are rotation of each other");

		} else {
			System.out.println("Strings are NOT rotation of each other");
		}

	}

}
