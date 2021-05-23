package com.dsa.basics;

import java.util.Arrays;

public class Fibonaci {
	public static void main(String[] args) {
		// 0 1 1 2 3 5 8 13
		int arr[] = new int[8];
		Fibonaci fib = new Fibonaci();
		System.out.println(Arrays.toString(fib.fibo(arr)));

	}

	int[] fibo(int arr[]) {
		arr[0] = 0;
		arr[1] = 1;
		for (int i = 2; i < 8; i++)
			arr[i] = arr[i - 2] + arr[i - 1];
		return arr;
	}

}
