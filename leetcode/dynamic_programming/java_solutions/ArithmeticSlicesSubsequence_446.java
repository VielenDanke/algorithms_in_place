package leetcode.dynamic_programming.java_solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArithmeticSlicesSubsequence_446 {

    static class Solution {
        public int numberOfArithmeticSlices(int[] nums) {
            int result = 0;

            List<Map<Long, Integer>> dp = new ArrayList<>();

            for (int i = 0; i < nums.length; i++) {
                dp.add(new HashMap<>());
                for (int j = 0; j < i; j++) {
                    long diff = (long) nums[i] - (long) nums[j];

                    result += dp.get(j).getOrDefault(diff, 0);
                    Integer num = dp.get(i).getOrDefault(diff, 0);
                    num += dp.get(j).getOrDefault(diff, 0) + 1;
                    dp.get(i).put(diff, num);
                }
            }
            return result;
        }
    }

    static class SolutionTimeLimit {

        private int counter;

        public int numberOfArithmeticSlices(int[] nums) {
            counter = 0;
            backtrack(nums, new ArrayList<>(), 0);
            return counter;
        }

        private void backtrack(int[] nums, List<Long> temp, int start) {
            if (temp.size() >= 3) {
                counter++;
            }
            for (int i = start; i < nums.length; i++) {
                if (temp.size() <= 1 || (isNumberFits(temp, nums[i]) && isOrderFits(temp, nums[i]))) {
                    temp.add((long) nums[i]);
                    backtrack(nums, temp, i + 1);
                    temp.remove(temp.size() - 1);
                }
            }
        }

        private boolean isOrderFits(List<Long> temp, int number) {
            int n = temp.size();
            if (temp.get(n - 1) > temp.get(n - 2)) {
                return number > temp.get(n - 1);
            } else if (temp.get(n - 1) < temp.get(n - 2)) {
                return number < temp.get(n - 1);
            } else {
                return number == temp.get(n - 1);
            }
        }

        private boolean isNumberFits(List<Long> temp, int number) {
            long max = Math.max(temp.get(temp.size() - 1), temp.get(temp.size() - 2));
            long min = Math.min(temp.get(temp.size() - 1), temp.get(temp.size() - 2));

            long diff = Math.abs(max - min);

            return diff == Math.abs(Math.max(number, temp.get(temp.size() - 1)) - Math.min(number, temp.get(temp.size() - 1)));
        }
    }
}
