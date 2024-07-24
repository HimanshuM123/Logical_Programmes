package string;

public class LongestPalimdromSubstring {
    public String longestPalindrome(String s) {
        String res = "";
        int resLen = 0;

        for (int i = 0; i < s.length(); i++) {
            // odd length
            int left = i, right = i;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if ((right - left + 1) > resLen) {
                    res = s.substring(left, right + 1);
                    resLen = right - left + 1;
                }
                left--;
                right++;
            }

            // even length
            left = i;
            right = i + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if ((right - left + 1) > resLen) {
                    res = s.substring(left, right + 1);
                    resLen = right - left + 1;
                }
                left--;
                right++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        LongestPalimdromSubstring sol = new LongestPalimdromSubstring();
        String s = "yaahabcbakl";
        System.out.println(sol.longestPalindrome(s)); // Output: bab or aba
    }
}
