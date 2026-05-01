package string;

import java.util.StringTokenizer;

public class CompareVersions {

	public static void main(String[] args) {
		int result = compareVersion( "1.11","1.11.1");
		System.out.println(result);
	}

	private static int compareVersion(String version1, String version2) {
		String[] arr1 = version1.split("\\.");
		String[] arr2 = version2.split("\\.");

		int minLength = 0;
		String[] maxArr= new String[arr1.length> arr2.length? arr1.length: arr2.length];
		boolean flag = true;
		if (arr1.length > arr2.length) {
			minLength = arr2.length;
			maxArr=arr1;
			flag = true;
		} else if (arr1.length < arr2.length) {
			minLength = arr1.length;
			maxArr=arr2;
			flag = false;
		} else {
			minLength = arr1.length;
		}
		
		for(int i =0; i< minLength; i++) {
			if(Integer.parseInt(arr1[i])>Integer.parseInt(arr2[i])) {
				return 1;
			}
			if(Integer.parseInt(arr1[i])<Integer.parseInt(arr2[i])) {
				return -1;
			}
		}
		
		for(int i=minLength ; i<maxArr.length;i++) {
			if(Integer.parseInt(maxArr[i])>0) {
				if(flag) {
					return 1;
				}else {
					return -1;
				}
			}
		}

		return 0;
	}

}

/*
 * Compare two version numbers version1 and version2. If version1 > version2
 * return 1, if version1 < version2 return -1, otherwise return 0. 0.1 < 1.1 <
 * 1.2 < 13.37
 
 
 
 private static int compareVersion(String version1, String version2) {
		StringTokenizer s1 = new StringTokenizer(version1, ".");
		StringTokenizer s2 = new StringTokenizer(version2, ".");

		while (s1.hasMoreTokens() && s2.hasMoreElements()) {
			int token1 = Integer.parseInt(s1.nextToken());
			int token2 = Integer.parseInt(s2.nextToken());
			if (token1 > token2) {
				return 1;
			} else if (token2 > token1) {
				return -1;
			}
		}
		if (s1.countTokens() > s2.countTokens()) {
			while (s1.hasMoreTokens()) {
				if (Integer.parseInt(s1.nextToken()) > 0)
					return 1;
			}
			if (s2.countTokens() > s1.countTokens()) {
				while (s2.hasMoreTokens()) {
					if (Integer.parseInt(s2.nextToken()) > 0)
						return 1;
				}
			}
		}
		return 0;
	}
 */