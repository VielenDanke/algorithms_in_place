package leetcode.bit_manipulation.java_solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SingleNumber2_137 {

    static class SolutionBits {
        public int singleNumber(int[] nums) {
            int ones = 0, twos = 0;

            for (int j : nums) {
                ones = (ones ^ j) & ~twos;
                twos = (twos ^ j) & ~ones;
            }
            return ones;
        }
    }

    static class SolutionSort {
        public int singleNumber(int[] nums) {
            Arrays.sort(nums);

            int number = nums[0];
            int times = 1;

            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == number) {
                    times++;
                    if (times > 3) {
                        return number;
                    }
                } else {
                    if (times < 3) {
                        return number;
                    }
                    times = 1;
                    number = nums[i];
                }
            }
            return number;
        }
    }

    static class Solution {
        public int singleNumber(int[] nums) {
            Map<Integer, Integer> m = new HashMap<>();

            for (int num : nums) {
                m.put(num, m.getOrDefault(num, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
                if (entry.getValue() != 3) {
                    return entry.getKey();
                }
            }
            return -1;
        }
    }
}
