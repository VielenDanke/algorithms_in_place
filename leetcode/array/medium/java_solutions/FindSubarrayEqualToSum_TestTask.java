package leetcode.array.medium.java_solutions;

import java.util.HashMap;
import java.util.Map;

public class FindSubarrayEqualToSum_TestTask {

    static class Solution {

        public int[] findSubarrayEqualToSum(int[] array, int sumToFind) {
            if (array == null) {
                return null;
            }
            int n = array.length;

            int[] prefixSum = new int[n];

            for (int i = 0; i < n; i++) {
                if (i > 0) {
                    prefixSum[i] = prefixSum[i - 1] + array[i];
                } else {
                    prefixSum[i] = array[i];
                }
            }
            Map<Integer, Integer> m = new HashMap<>();

            for (int i = 0; i < n; i++) {
                int currentSum = prefixSum[i];

                if (currentSum == sumToFind) {
                    return new int[]{0, i};
                }
                if (m.containsKey(currentSum - sumToFind)) {
                    return new int[]{m.get(currentSum - sumToFind) + 1, i};
                }
                m.put(currentSum, i);
            }
            return null;
        }
    }
}
