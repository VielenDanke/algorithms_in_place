package leetcode.array.medium.java_solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountNicePairsInAnArray_1814 {

    private static final int MOD = (int) (10e8 + 7);

    private static int reverseNumber(int num) {
        String str = String.valueOf(num);
        StringBuilder strBuilder = new StringBuilder(str);
        strBuilder.reverse();
        return Integer.parseInt(strBuilder.toString());
    }

    private static int reverseNumberWithoutString(int num) {
        int reversed = 0;

        while (num > 0) {
            reversed = (reversed * 10) + (num % 10);
            num /= 10;
        }
        return reversed;
    }

    static class SolutionSort {
        public int countNicePairs(int[] nums) {
            // non negative integers
            // rev(int) - decreasing order of interger, 123 -> 321, all leading zeroes are dropped
            // nice pair -> nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
            int n;
            if (nums == null || (n = nums.length) == 0) {
                return 0;
            }
            for (int i = 0; i < n; i++) {
                nums[i] = nums[i] - reverseNumberWithoutString(nums[i]);
            }
            Arrays.sort(nums);

            long result = 0;

            for (int i = 0; i < n - 1; i++) {
                long counter = 1;
                while (i < n - 1 && nums[i] == nums[i + 1]) {
                    counter++;
                    i++;
                }
                result += counter * (counter - 1) / 2;
            }
            return (int) (result % MOD);
        }

    }

    static class Solution {
        public int countNicePairs(int[] nums) {
            // non negative integers
            // rev(int) - decreasing order of interger, 123 -> 321, all leading zeroes are dropped
            // nice pair -> nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
            int n;
            if (nums == null || (n = nums.length) == 0) {
                return 0;
            }
            Map<Integer, Integer> m = new HashMap<>();

            int counter = 0;

            for (int i = 0; i < n; i++) {
                int reversedNumber = reverseNumberWithoutString(nums[i]);
                int temp = m.getOrDefault(nums[i] - reversedNumber, 0);
                counter = (counter + temp) % MOD;
                m.put(nums[i] - reversedNumber, temp + 1);
            }
            return counter % MOD;
        }
    }

    static class SolutionBruteForce {
        public int countNicePairs(int[] nums) {
            // non negative integers
            // rev(int) - decreasing order of interger, 123 -> 321, all leading zeroes are dropped
            // nice pair -> nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
            int n;
            if (nums == null || (n = nums.length) == 0) {
                return 0;
            }
            int[] reverse = new int[n];

            for (int i = 0; i < n; i++) {
                reverse[i] = reverseNumber(nums[i]);
            }
            int counter = 0;

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (nums[i] + reverse[j] == nums[j] + reverse[i]) {
                        counter++;
                    }
                }
            }
            return counter;
        }
    }
}
