package leetcode.array.easy.java_solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement_169 {

    static class Solution {
        public int majorityElement(int[] nums) {
            int n = nums.length;

            Arrays.sort(nums);

            for (int i = 1; i < n; i++) {
                int counter = 1;
                while (i < nums.length && nums[i] == nums[i - 1]) {
                    counter++;
                    i++;
                }
                if (counter > n / 2) {
                    return nums[i - 1];
                }
            }
            return nums[0];
        }
    }

    static class SolutionMap {
        public int majorityElement(int[] nums) {
            int majority = nums.length / 2;
            Map<Integer, Integer> counterMap = new HashMap<>();

            for (int num : nums) {
                if (counterMap.merge(num, 1, Integer::sum) > majority) {
                    return num;
                }
            }
            return -1;
        }
    }
}
