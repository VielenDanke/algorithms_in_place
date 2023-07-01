package leetcode.backtracking_recursion.java_solutions;

public class FairDistributionOfCookies_2305 {

    static class Solution {
        private int result;

        public int distributeCookies(int[] cookies, int k) {
            this.result = Integer.MAX_VALUE;
            backtrack(cookies, new int[cookies.length], k, 0);
            return result;
        }

        private void backtrack(int[] cookies, int[] children, int k, int start) {
            if (start == cookies.length) {
                int max = 0;
                for (int sum : children) max = Math.max(max, sum);
                result = Math.min(result, max);
                return;
            }
            for (int i = 0; i < k; i++) {
                children[i] += cookies[start];
                backtrack(cookies, children, k, start + 1);
                children[i] -= cookies[start];
            }
        }
    }
}
