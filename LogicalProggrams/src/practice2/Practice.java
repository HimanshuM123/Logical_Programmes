package practice2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Practice {
	public static void main(String[] args) {
		int num = 12321;
		int original = num;
		int sum =0;
		
		
		while(num >0) {
			sum  = sum*10 + num%10;
			num= num/10;
		}
		
		if(sum ==original) {
			System.out.println("The number is palimdrom");
		}else {
			System.out.println("NOT");
		}
		
	}
}
