package practice2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

import binaryTree.BinaryTreeMirror;
import binaryTree.BinaryTreeSum;
import java8Stream.Employee;
import leetcode2.LinkedListPalimdrom;

public class Practice2 extends Thread {

	public static void main(String[] args) {

		int [] numArr = {100,90,50,40,10,9,5,4,1};
		
		String [] romanArr = {"C","XC","L","XL","X","IX","V","IV","I"};
		int n = 24;
		
		//24-> XXIV  10 10 4
		
		String res = toRoman(romanArr, numArr, n);
		System.out.println(res);
		
		

	}
	
	private static String toRoman(String [] romanArr,int [] numArr,int num) {
		String roman ="";
		
		for(int i=0 ; i< romanArr.length;i++ ) {
			if(num >= numArr[i]) {
				roman = roman + romanArr[i];
				num = num - numArr[i];
				i=0;
				
			}
		}
		
		return roman;
		
		
		
	}
}

// 1->2 2->1 5 ->1...
/*
 * 
 * 10, 20, 30, 40, 50, 60, 70
 * 
 * 30 , 20 ,10 ,40, 50, 60, 70
 * 
 * 70,60,50,40 ,10, 20, 30
 * 
 * 
 * 
 * 
 */