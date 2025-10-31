package string;
public class PalindromeIndexSinglePass {
    public static int palindromeIndex(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                // skip left
                if (isPalindrome(s, left + 1, right)) return left;
                // skip right
                if (isPalindrome(s, left, right - 1)) return right;
                return -1;
            }
        }
        return -1; // already palindrome
    }

    private static boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(palindromeIndex("bcbc")); // 0 or 3
        System.out.println(palindromeIndex("aaab")); // 3
        System.out.println(palindromeIndex("racecar")); // -1
    }
}
