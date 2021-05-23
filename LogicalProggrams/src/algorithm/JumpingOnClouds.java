package algorithm;

public class JumpingOnClouds {
public static void main(String[] args) {
	int [] arr = {0,0,1,0,0,1,0};
	int count=-1;
	for(int i=0;i<arr.length;) {
		if(i+2 < arr.length && arr[i]==0) {
			i=i+2;
			
		}else {
			i=i+1;
		}
		count++;
	}
	System.out.println("The shortest jump is "+count);
	
}
}

//input 0 0 1 0 0 1 0 -> output 4
// 0 0 0 0 1 0 -> 3