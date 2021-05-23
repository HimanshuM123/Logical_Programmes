package algorithmRecursion;

public class ZigZag {
	public static void main(String[] args) {
		pzz(3);

	}
	private static void pzz(int n) {
		if(n==0)
			return;
		
		System.out.println("pre "+n);
		pzz(n-1);
		System.out.println("In "+n);
		pzz(n-1);
		System.out.println("Post "+n);
	}
}
/*
0  0 0 0 0 0 0  0
 \ / \ / \ / \ /
  1   1  1   1
   \  /  \  /
    2     2 
     \  /
       3

*/