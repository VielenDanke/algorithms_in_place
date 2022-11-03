package hackerrank.numbers.easy.java_solutions;

public class UtopianTree {

    // https://www.hackerrank.com/challenges/utopian-tree/problem

    static class Solution {
        public static int utopianTree(int n) {
            // Write your code here
            int result = 1;
            for (int i = 0; i < n; i++) {
                result = simulateGrowth(result, i % 2 == 0);
            }
            return result;
        }

        private static int simulateGrowth(int n, boolean cycle) {
            return cycle ? n * 2 : n + 1;
        }
    }
}
