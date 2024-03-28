package leetcode.array.medium.java_solutions;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubarrayWithMostKFrequency_2958 {

    static class Solution {
        public int maxSubarrayLength(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();

            int left = 0, right = 0, result = -1 << 30, totalElements = 0;

            while (right < nums.length) {
                int currentK = map.getOrDefault(nums[right], 0) + 1;
                map.put(nums[right], currentK);

                totalElements++;

                while (currentK > k && left < right) {
                    int leftK = map.get(nums[left]) - 1;
                    totalElements--;
                    map.put(nums[left], leftK);
                    if (nums[left] == nums[right]) {
                        currentK = leftK;
                    }
                    left++;
                }
                result = Math.max(result, totalElements);
                right++;
            }
            return result;
        }
    }
}
