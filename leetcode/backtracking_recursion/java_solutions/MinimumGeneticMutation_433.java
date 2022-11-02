package leetcode.backtracking_recursion.java_solutions;

public class MinimumGeneticMutation_433 {

    static class Solution {
        private Integer min;

        public int minMutation(String start, String end, String[] bank) {
            min = null;
            backtrack(start, end, bank, new boolean[bank.length], 0);
            return min == null ? -1 : min;
        }

        private void backtrack(String current, String end, String[] bank, boolean[] visited, int path) {
            if (path > bank.length) {
                return;
            }
            if (current.equals(end)) {
                min = min == null ? path : Math.min(min, path);
                return;
            }
            for (int i = 0; i < bank.length; i++) {
                if (!visited[i] && isValidStep(current, bank[i])) {
                    visited[i] = true;
                    backtrack(bank[i], end, bank, visited, path + 1);
                    visited[i] = false;
                }
            }
        }

        private boolean isValidStep(String current, String bank) {
            if (current.length() != bank.length()) return false;
            int counter = 0;
            for (int i = 0; i < current.length(); i++) {
                if (current.charAt(i) != bank.charAt(i)) {
                    if (++counter > 1) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
