package leetCode;

class NumPalimdrome {
    public boolean isPalindrome(int x) {
    	int num=x;
        int rev=0;
        while(x>0){
           int rem=x%10;
             rev = rem+rev*10;
            x=x/10;
            
        }
        if(num==rev){
            return true;
        }
        else{
            return false;
        }
   
    }
    
    
    public static void main(String args[]){
    	NumPalimdrome s=new NumPalimdrome();
      boolean flag= s.isPalindrome(121); 
      System.out.println(flag);
    }
    //121
}
    
    
