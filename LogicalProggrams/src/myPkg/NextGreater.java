package myPkg;

import java.util.Random;

public class NextGreater {
public static void main(String[] args) {
	int number=4756;
	//5467
	int [] arr=new int[String.valueOf(number).length()+1];
	int count=0;
	int temp=0;
	int final_number=0;
	while(number!=0) {
		arr[count]=number%10;
		number=number/10;
		count++;
	}
	int firstnumber=arr[3];
	
	for(int i=0;i<=arr.length-1;i++) {
		for(int j=i+1;j<=arr.length-1;j++) {
			if(arr[i]>arr[j]) {
				temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
			}
		}
	}
	//04567
	int secondnumber=0;
	int position=0;
	for(int l=0;l<=arr.length-1;l++) {
		if(arr[l]==firstnumber) {
			 secondnumber=arr[l+1];
			 position=l+1;
		}
	}
	
	arr[0]=arr[position];
	arr[position]=0;
	
	for(int k=0;k<=arr.length-1;k++) {
		if(arr[k]!=0) {
			final_number=final_number*10+arr[k];
		}
	}
	System.out.println(final_number);
	
}
}
