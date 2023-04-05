package leetcode.dynamic_programming.java_solutions;

import java.util.*;
import java.util.stream.Stream;

public class MinimizeMaximumArray_2439 {

    static class SolutionBinarySearch {
        public int minimizeArrayValue(int[] nums) {
            int left = 0, right = Arrays.stream(nums).max().getAsInt(), best = 0;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (isValid(mid, nums)) {
                    best = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return best;
        }

        private boolean isValid(int mid, int[] nums) {
            long sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                if (sum > (long) mid * (i + 1)) return false;
            }
            return true;
        }
    }

    static class SolutionPrefixSum {
        public int minimizeArrayValue(int[] nums) {
            long sum = 0, result = 0;
            for (int i = 0; i < nums.length; ++i) {
                sum += nums[i];
                result = Math.max(result, (sum + i) / (i + 1));
            }
            return (int) result;
        }
    }

    static class SolutionGreedy {
        public int minimizeArrayValue(int[] nums) {
            int globalMin = Integer.MAX_VALUE;
            while (true) {
                int maxNumber = Integer.MIN_VALUE, minIdx = 0;
                for (int i = 0; i < nums.length; i++) {
                    if (maxNumber < nums[i]) {
                        maxNumber = nums[i];
                        minIdx = i;
                    }
                }
                if (globalMin < maxNumber) return globalMin;
                if (minIdx == 0) return maxNumber;
                globalMin = maxNumber;
                nums[minIdx]--;
                nums[minIdx - 1]++;
            }
        }
    }

    static class SolutionBruteForce {
        public int minimizeArrayValue(int[] nums) {
            int minNumber = Integer.MAX_VALUE;

            List<Integer> indexes = Stream.iterate(0, i -> i + 1).limit(nums.length).toList();

            Queue<Integer> queue = new PriorityQueue<>((i, j) -> nums[j] - nums[i]);

            queue.addAll(indexes);

            while (!queue.isEmpty()) {
                Integer maxIdx = queue.poll();

                if (maxIdx == 0) return nums[maxIdx];

                if (minNumber >= nums[maxIdx]) {
                    minNumber = nums[maxIdx];
                    nums[maxIdx]--;
                    nums[maxIdx - 1]++;
                    queue.clear();
                    queue.addAll(indexes);
                } else {
                    return minNumber;
                }
            }
            return -1;
        }
    }
}
