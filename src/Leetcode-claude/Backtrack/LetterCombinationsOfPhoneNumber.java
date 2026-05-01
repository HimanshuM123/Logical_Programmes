/*
 * LeetCode 17: Letter Combinations of a Phone Number
 *
 * Problem: Given a string containing digits 2-9, return all possible letter combinations
 * that the number could represent on a traditional phone keypad.
 *
 * Example: Input: digits = "23" -> Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 *
 * Approach: Backtracking
 * - Map digits to letter sequences (like on phone keypad)
 * - For each digit, try all possible letters
 * - Recursively combine with rest of digits
 *
 * Time Complexity: O(4^n) - each digit maps to at most 4 letters
 * Space Complexity: O(n) - recursion depth
 */

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LetterCombinationsOfPhoneNumber {

    private static final Map<Character, String> digitToLetters = new HashMap<>();
    static {
        digitToLetters.put('2', "abc");
        digitToLetters.put('3', "def");
        digitToLetters.put('4', "ghi");
        digitToLetters.put('5', "jkl");
        digitToLetters.put('6', "mno");
        digitToLetters.put('7', "pqrs");
        digitToLetters.put('8', "tuv");
        digitToLetters.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return result;
        }

        backtrack(digits, 0, "", result);
        return result;
    }

    private void backtrack(String digits, int index, String current, List<String> result) {
        // Base case: processed all digits
        if (index == digits.length()) {
            result.add(current);
            return;
        }

        char digit = digits.charAt(index);
        String letters = digitToLetters.get(digit);

        // Try each letter for current digit
        for (char letter : letters.toCharArray()) {
            backtrack(digits, index + 1, current + letter, result);
        }
    }

    public static void main(String[] args) {
        LetterCombinationsOfPhoneNumber sol = new LetterCombinationsOfPhoneNumber();

        System.out.println(sol.letterCombinations("23"));
        // ["ad","ae","af","bd","be","bf","cd","ce","cf"]

        System.out.println(sol.letterCombinations(""));
        // []

        System.out.println(sol.letterCombinations("2"));
        // ["a","b","c"]

        System.out.println(sol.letterCombinations("234"));
    }
}
