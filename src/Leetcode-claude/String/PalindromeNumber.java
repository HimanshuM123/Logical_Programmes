/*
 * LeetCode 9: Palindrome Number
 *
 * Problem: Given an integer x, return true if x is a palindrome integer.
 * Negative numbers are not palindromes.
 *
 * Example: Input: x = 121 -> Output: true
 *          Input: x = -121 -> Output: false
 *
 * Approach: Reverse Half of the Number
 * - No need to reverse entire number (can cause overflow)
 * - Reverse second half and compare with first half
 * - When reversed > original, we've processed half
 *
 * Time Complexity: O(log n) - number of digits in x
 * Space Complexity: O(1) - only use few variables
 */

public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        // Negative numbers and numbers ending with 0 (except 0 itself) are not palindromes
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversed = 0;

        while (x > reversed) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }

        // For odd length: middle digit doesn't matter (x == reversed / 10)
        // For even length: x == reversed
        return x == reversed || x == reversed / 10;
    }

    public static void main(String[] args) {
        PalindromeNumber sol = new PalindromeNumber();

        System.out.println(sol.isPalindrome(121));       // true
        System.out.println(sol.isPalindrome(-121));      // false
        System.out.println(sol.isPalindrome(10));        // false
        System.out.println(sol.isPalindrome(0));         // true
        System.out.println(sol.isPalindrome(12321));     // true
    }
}
