package myPkg;

public class LengthOfLastWord {

	public static void main(String[] args) {

		lengthOfLastWord("Hello World");
	}

	
	public static int lengthOfLastWord(String s) {
        int result =0;
       String a = s;
       String [] arr = a.split(" ");
        int length = arr.length;
        if(length==1){
            return arr[0].length();
        }
        for(int i=length-1 ;i>0; i--){
            if(arr[i]!=" "){
               result = arr[i].length();
               return result;
            }
        }
        return result;
    }
}


