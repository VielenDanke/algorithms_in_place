package leetcode.array.easy.java_solutions;

import java.util.*;

public class SetMismatch_645 {

    static class Solution {
        public int[] findErrorNums(int[] nums) {
            int n = nums.length, s = n * (n + 1) / 2;
            int sum = 0, setSum = 0;
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                sum += num;
                if (set.add(num)) setSum += num;
            }
            int missing = s - setSum;
            int duplicate = sum + missing - s;
            return new int[]{duplicate, missing};
        }
    }

    static class SolutionBuckets {
        public int[] findErrorNums(int[] nums) {
            int[] buckets = new int[100000];

            int min = nums[0], max = nums[0];

            for (int num : nums) {
                min = Math.min(min, num);
                max = Math.max(max, num);
                buckets[num]++;
            }
            int twice = 0, missing = min == 1 ? max + 1 : 1;

            for (int i = min; i <= max; i++) {
                if (buckets[i] > 1) {
                    twice = i;
                } else if (buckets[i] == 0) {
                    missing = i;
                }
            }
            return new int[]{twice, missing};
        }
    }

    static class SolutionMap {
        public int[] findErrorNums(int[] nums) {
            int min = 1 << 30, max = -1 << 30;

            Map<Integer, Integer> counter = new HashMap<>();

            int twice = 0, missing = 0;

            for (int num : nums) {
                min = Math.min(min, num);
                max = Math.max(max, num);
                counter.put(num, counter.getOrDefault(num, 0) + 1);
                if (counter.get(num) > 1) {
                    twice = num;
                }
            }
            for (int i = min; i <= max; i++) {
                if (!counter.containsKey(i)) {
                    missing = i;
                    break;
                }
            }
            return new int[]{twice, missing == 0 ? min == 1 ? max + 1 : 1 : missing};
        }
    }

    static class SolutionSort {
        public int[] findErrorNums(int[] nums) {
            Arrays.sort(nums);

            int left = 0, right = 1, n = nums.length;

            int missing = 0, twice = 0, min = Math.min(nums[left], nums[right]), max = Math.max(nums[left], nums[right]);

            while (right < n) {
                min = Math.min(min, nums[right]);
                max = Math.max(max, nums[right]);
                if (nums[left] == nums[right]) {
                    twice = nums[left];
                } else if (nums[right] - nums[left] > 1) {
                    missing = (nums[left] + nums[right]) / 2;
                }
                right++;
                left++;
            }
            return new int[]{twice, missing == 0 ? min == 1 ? max + 1 : 1 : missing};
        }
    }
}
