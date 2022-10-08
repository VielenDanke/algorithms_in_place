package leetcode.dynamic_programming.java_solutions;

public class LongestPalindromicSubstring_5 {

    // DP O(N^2)

    public static String longestPalindrome(String s) {
        int N = s.length(), maxLen = 0, start = 0;
        boolean[][] dp = new boolean[N][N];

        for (int i = N - 1; i >= 0; i--) {
            for (int j = i; j < N; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);

                if (dp[i][j] && (j - i + 1 > maxLen)) {
                    maxLen = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }

    // --------------------------------------------------------------------------
    // O(N^2)

    private int low, len;

    public String longestPalindromeBetter(String s) {
        if (s.isBlank()) {
            return "";
        } else if (s.length() < 2) {
            return s;
        }
        int N = s.length();
        for (int i = 0; i < N; i++) {
            expandPalindrome(s, i, i);
            expandPalindrome(s, i, i + 1);
        }
        return s.substring(low, low + len);
    }

    private void expandPalindrome(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        int tempLen = j - i - 1;
        if (tempLen > len) {
            low = j + 1;
            len = tempLen;
        }
    }

    // -------------------------------------------------------------------------------------
    // O(N^2 * M)

    public String longestPalindromeWorst(String s) {
        String max = "";
        if (s.isBlank()) {
            return max;
        }
        int maxWindow = s.length();

        boolean isFound = false;

        while (maxWindow >= 1 && !isFound) {
            for (int i = 0; i + maxWindow <= s.length(); i++) {
                String str = s.substring(i, i + maxWindow);
                if (isPalindromic(str)) {
                    max = str;
                    isFound = true;
                    break;
                }
            }
            maxWindow--;
        }
        return max;
    }

    private boolean isPalindromic(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }
}
