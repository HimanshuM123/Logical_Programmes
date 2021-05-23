package com.dsa.basics;

public class Palimdrome {
	public static void main(String[] args) {
		boolean flag = false;
		Palimdrome palimdrome = new Palimdrome();
		flag = palimdrome.isPalimdrome("madam2");
		if (flag)
			System.out.println("The string is palimdrom");
		else
			System.out.println("The string is not palimdrom");
	}

	boolean isPalimdrome(String s) {
		// m  a  d  a  m
		char[] arr = s.toCharArray();
		for (int i = 0; i <= arr.length / 2; i++) {
			if (arr[i] != arr[arr.length - 1 - i])
				return false;
		}
		return true;
	}

}
