package practice2;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import binaryTree.BinaryTreeMirror;
import binaryTree.BinaryTreeSum;
import leetcode2.LinkedListPalimdrom;

public class Practice2 {

	private static int sum(int num) {
		int sum = 0;
		while (num > 0 || sum > 9) {
			if(num ==0) {
				num = sum ;
				sum =0;
			}
			sum = sum + num % 10;
			num = num / 10;
		}
		return sum;
	}

	public static void main(String[] args) {
		int result = sum(38);
		System.out.println(result);
	}

}