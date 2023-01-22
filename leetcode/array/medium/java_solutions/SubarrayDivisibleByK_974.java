package leetcode.array.medium.java_solutions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class SubarrayDivisibleByK_974 {

    static class SolutionArray {
        public int subarraysDivByK(int[] nums, int k) {
            int[] prefixSum = new int[nums.length];
            prefixSum[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                prefixSum[i] = nums[i] + prefixSum[i - 1];
            }
            int[] modGroups = new int[k];
            modGroups[0] = 1;
            int result = 0;
            for (int sum : prefixSum) {
                int mod = sum % k;
                if (mod < 0) mod += k;
                result += modGroups[mod];
                modGroups[mod]++;
            }
            return result;
        }
    }

    static class SolutionHashMap {
        public int subarraysDivByK(int[] nums, int k) {
            Map<Integer, Integer> count = new HashMap<>();
            count.put(0, 1);
            int prefix = 0, res = 0;
            for (int num : nums) {
                prefix = (prefix + num % k + k) % k;
                res += count.getOrDefault(prefix, 0);
                count.put(prefix, count.getOrDefault(prefix, 0) + 1);
            }
            return res;
        }
    }
}
