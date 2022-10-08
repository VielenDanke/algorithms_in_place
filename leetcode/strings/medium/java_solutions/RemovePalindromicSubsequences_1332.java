package leetcode.strings.medium.java_solutions;

import java.util.ArrayList;

public class RemovePalindromicSubsequences_1332 {

    // solution is to understand if s is the same that s.reversed(), if yes - just 1 removal, if not - 2

    public int removePalindromeSub(String s) {
        return s.equals(new StringBuilder(s).reverse().toString()) ? 1 : 2;
    }

    // --------------------------------------------------------------------
    // works for different alphabetic letters inside string (Here we are matching Substring, not Subsequence!)

    public int removePalindromeSubBruteForceSubstring(String s) {
        new ArrayList<Integer>().stream().mapToInt(Integer::intValue).sum();
        int window = s.length();
        int counter = 0;
        var builder = new StringBuilder(s);

        while (window > 0 && !builder.isEmpty()) {
            for (int i = 0; i + window <= builder.length() && !builder.isEmpty(); i++) {
                if (isPalindrome(builder, i, i + window - 1)) {
                    counter++;
                    builder.replace(i, i + window, "");
                }
            }
            window = Math.min(window - 1, builder.length());
        }
        return counter;
    }

    private boolean isPalindrome(StringBuilder builder, int i, int j) {
        while (i < j) {
            if (builder.charAt(i++) != builder.charAt(j--)) return false;
        }
        return true;
    }

}
