package array;

import java.util.Arrays;

public class UserDefinedArray {
	public static void main(String[] args) {
		Array numbers = new Array(3);
		
		  numbers.insert(10); 
		  numbers.insert(20);
		  numbers.insert(30);
		  numbers.insert(40);
		  numbers.insert(50);
		  numbers.insert(60);
		  
		  numbers.removeAt(2);
		 
		numbers.print();
	}

}

class Array {
	int[] array;
	int  count=0;
	Array(int num) {
		array = new int[3];
	}

	public void print() {
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i]+" ");
		}
	}
	 
	public void insert(int number) {
		if(array.length==count) {
			int[] newItems= new int[count*2];
			for(int i=0;i<count;i++) {
				newItems[i]=array[i];
			}
			array=newItems;
		}
		array[count++]=number;
	}
	
	public void removeAt(int index) {
		if(index<0 || index >=count)
			throw new IllegalArgumentException();
		
		for(int i=index;i<count-1;i++)
			array[i]=array[i+1];
		
		count--;
	}

}