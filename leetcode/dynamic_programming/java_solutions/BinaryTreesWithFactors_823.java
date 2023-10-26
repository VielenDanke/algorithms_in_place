package leetcode.dynamic_programming.java_solutions;

import java.util.*;

public class BinaryTreesWithFactors_823 {

    static class Solution {
        private static final int MOD = (int) (10e8 + 7);

        public int numFactoredBinaryTrees(int[] arr) {
            Arrays.sort(arr);

            Map<Integer, Integer> dp = new HashMap<>();

            for (int num : arr) {
                dp.put(num, 1);
            }

            for (int left : arr) {
                for (int right : arr) {
                    if (right > Math.sqrt(left)) break;
                    if (left % right == 0 && dp.containsKey(left / right)) {
                        long temp = (long) dp.get(right) * dp.get(left / right);
                        dp.put(left, (int) ((dp.get(left) + (left / right == right ? temp : temp * 2)) % MOD));
                    }
                }
            }
            int result = 0;
            for (int num : dp.values()) {
                result = (result + num) % MOD;
            }
            return result;
        }
    }
}
