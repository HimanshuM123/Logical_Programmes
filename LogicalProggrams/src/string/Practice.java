package string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

public class Practice {
	public static void main(String[] args) {
		String haystack = "sabutsad";
		String needle = "sad";
		int index = strStr(haystack, needle);
		System.out.println(index);

	}

	public static int strStr(String haystack, String needle) {

		int index = haystack.indexOf(needle);
		
		return index;
	}

}
