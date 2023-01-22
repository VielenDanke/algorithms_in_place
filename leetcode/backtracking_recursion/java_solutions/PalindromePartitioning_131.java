package leetcode.backtracking_recursion.java_solutions;

import java.util.LinkedList;
import java.util.List;

public class PalindromePartitioning_131 {

    static class Solution {
        public List<List<String>> partition(String s) {
            List<List<String>> result = new LinkedList<>();

            backtrack(result, new LinkedList<>(), s);

            return result;
        }

        private void backtrack(List<List<String>> result, LinkedList<String> palindromes, String s) {
            if (s.length() == 0) {
                result.add(new LinkedList<>(palindromes));
                return;
            }
            for (int i = 1; i <= s.length(); i++) {
                String sub = s.substring(0, i);
                if (isPalindrome(sub)) {
                    palindromes.add(sub);
                    backtrack(result, palindromes, s.substring(i));
                    palindromes.removeLast();
                }
            }
        }

        private boolean isPalindrome(String s) {
            int left = 0, right = s.length() - 1;

            while (left < right) {
                if (s.charAt(left++) != s.charAt(right--)) {
                    return false;
                }
            }
            return true;
        }
    }
}
