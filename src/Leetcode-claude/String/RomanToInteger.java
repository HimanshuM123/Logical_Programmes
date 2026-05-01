/*
 * LeetCode 13: Roman to Integer
 *
 * Problem: Given a roman numeral string, convert it to an integer.
 * Roman numeral rules: I(1), V(5), X(10), L(50), C(100), D(500), M(1000)
 * Subtraction case: If smaller value appears before larger, subtract it (e.g., IV = 4)
 *
 * Example: Input: s = "MCMXCIV" -> Output: 1994 (M=1000, CM=900, XC=90, IV=4)
 *
 * Approach: Single Pass with HashMap
 * - Iterate from right to left
 * - If current value < previous value, subtract; otherwise add
 * - HashMap stores roman to integer mapping
 *
 * Time Complexity: O(n) - single pass through string
 * Space Complexity: O(1) - HashMap has fixed 7 entries
 */

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public int romanToInt(String s) {
        if (s == null || s.length() == 0) return 0;

        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int result = 0;
        int prevValue = 0;

        // Iterate from right to left
        for (int i = s.length() - 1; i >= 0; i--) {
            int currentValue = romanMap.get(s.charAt(i));

            // If current is less than previous, subtract (e.g., IV = -1 + 5)
            if (currentValue < prevValue) {
                result -= currentValue;
            } else {
                result += currentValue;
            }

            prevValue = currentValue;
        }

        return result;
    }

    public static void main(String[] args) {
        RomanToInteger sol = new RomanToInteger();

        System.out.println(sol.romanToInt("III"));      // 3
        System.out.println(sol.romanToInt("LVIII"));    // 58
        System.out.println(sol.romanToInt("MCMXCIV"));  // 1994
        System.out.println(sol.romanToInt("IV"));       // 4
        System.out.println(sol.romanToInt("XL"));       // 40
    }
}
