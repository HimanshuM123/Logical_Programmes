package codingInterview;

public class ClimbingStairs2 {

	public static void main(String[] args) {
		int N = 4;//stairs
		int K = 3;// steps
		
		
	int ways =	solve(N,K);
	System.out.println(ways);//7
		
	
	}
	
	private static int solve(int n, int k) {
		if(n==0) {
			return 1;
		}
		if(n<0) {
			return 0;
		}
		
		int ans=0;
		for(int i=1; i<=k;++i) {
			ans = ans+solve(n-i,k);
		}
		return ans;
	}

}

/*
f(N)=f(N-1)+f(N-2)+...+f(N-K)
7 ways
1,1,1,1
1,1,2
1,2,1
2,1,1
2,2
1,3
3,1


*/