package backtracking;

public class SubsetString {
	public static void main(String[] args) {
		subset("ab",0,"");
	}
	
	private static void subset(String s , int index, String current) {
		if(index == s.length()) {
			System.out.println(current);
			return;
		}
		
		//exclude
		subset(s,index+1,current);
		
		//include
		subset(s,index+1,current+s.charAt(index));
		
		
		
	}

}

/*

                           ("", index=0)
                         /                \
                exclude 'a'             include 'a'
               ("",1)                  ("a",1)
              /      \               /        \
       exclude 'b' include 'b'  exclude 'b' include 'b'
         ("",2)     ("b",2)      ("a",2)     ("ab",2)

*/