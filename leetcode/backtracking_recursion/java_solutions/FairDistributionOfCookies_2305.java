package leetcode.backtracking_recursion.java_solutions;

public class FairDistributionOfCookies_2305 {

    static class Solution {
        private int min;

        public int distributeCookies(int[] cookies, int k) {
            min = Integer.MAX_VALUE;
            backtrack(cookies, new int[k], 0);
            return min;
        }

        private void backtrack(int[] cookies, int[] children, int start) {
            if (start >= cookies.length) {
                int max = Integer.MIN_VALUE;
                for (int sum : children) max = Math.max(max, sum);
                min = Math.min(min, max);
                return;
            }
            for (int i = 0; i < children.length; i++) {
                children[i] += cookies[start];
                backtrack(cookies, children, start + 1);
                children[i] -= cookies[start];
            }
        }
    }
}
