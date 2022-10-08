package leetcode.strings.medium.java_solutions;

public class PalindromicSubstrings_647 {

    private int sum;

    public int countSubstrings(String s) {
        int N = s.length();

        for (int i = 0; i < N; i++) {
            extendSubstring(s, i, i);
            extendSubstring(s, i, i + 1);
        }
        return sum;
    }

    private void extendSubstring(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            sum++;
            left--;
            right++;
        }
    }

    // ----------------------------------------------------------------------------------------

    public int countSubstringsBruteForce(String s) {
        int window = 1, result = 0;

        while (window <= s.length()) {
            for (int i = 0; i + window <= s.length(); i++) {
                String substring = s.substring(i, i + window);
                if (isPalindromic(substring)) {
                    result++;
                }
            }
        }
        return result;
    }

    private boolean isPalindromic(String substring) {
        int left = 0, right = substring.length() - 1;

        while (left < right) {
            if (substring.charAt(left) != substring.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
