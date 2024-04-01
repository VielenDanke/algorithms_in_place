package leetcode.array.hard.java_solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Rust solution:

impl Solution {
    pub fn count_subarrays(nums: Vec<i32>, min_k: i32, max_k: i32) -> i64 {
        let (mut result, mut max_i, mut min_i, mut left_i) = (0i64, -1i64, -1i64, 0i64);
        for right_i in 0..nums.len() {
            let x = nums[right_i];
            if x < min_k || x > max_k {
                left_i = (right_i + 1) as i64;
                continue;
            }
            if x == max_k {
                max_i = right_i as i64;
            }
            if x == min_k {
                min_i = right_i as i64;
            }
            result += i64::max((i64::min(max_i, min_i) - left_i + 1), 0);
        }
        result
    }
}
 */

public class CountSubarraysWithFixedBounds_2444 {

    static class Solution {
        public long countSubarrays(int[] nums, int minK, int maxK) {
            long result = 0, maxIdx = -1, minIdx = -1;

            for (int rightIdx = 0, leftIdx = 0; rightIdx < nums.length; rightIdx++) {
                int x = nums[rightIdx];
                if (x < minK || x > maxK) {
                    leftIdx = rightIdx + 1;
                    continue;
                }
                if (x == maxK) {
                    maxIdx = rightIdx;
                }
                if (x == minK) {
                    minIdx = rightIdx;
                }
                result += Math.max(Math.min(maxIdx, minIdx) - leftIdx + 1, 0);
            }
            return result;
        }
    }

    static class SolutionQueue {
        public long countSubarrays(int[] nums, int minK, int maxK) {
            Queue<Integer> queue = new LinkedList<>();
            int minElementIndex = -1;
            int maxElementIndex = -1;
            long counter = 0L;
            for (int num : nums) {
                if (num <= maxK && num >= minK) {
                    queue.add(num);
                    if (num == minK) minElementIndex = queue.size();
                    if (num == maxK) maxElementIndex = queue.size();
                    if (minElementIndex != -1 && maxElementIndex != -1) {
                        counter += Math.min(minElementIndex, maxElementIndex);
                    }
                } else {
                    queue.clear();
                    minElementIndex = -1;
                    maxElementIndex = -1;
                }
            }
            return counter;
        }
    }

    static class SolutionBadIdx {
        public long countSubarrays(int[] nums, int minK, int maxK) {
            long counter = 0, badIdx = -1, minIdx = -1, maxIdx = -1, n = nums.length;
            for (int i = 0; i < n; i++) {
                if (nums[i] < minK || nums[i] > maxK) badIdx = i;
                if (nums[i] == minK) minIdx = i;
                if (nums[i] == maxK) maxIdx = i;
                counter += Math.max(0L, Math.min(minIdx, maxIdx) - badIdx);
            }
            return counter;
        }
    }

    static class SolutionBruteForce {
        private int minK = 0;
        private int maxK = 0;

        public long countSubarrays(int[] nums, int minK, int maxK) {
            this.minK = minK;
            this.maxK = maxK;
            var list = new ArrayList<List<Integer>>();
            collectSubarrays(list, nums);
            return list.stream().filter(this::isSubarrayValid).count();
        }

        private void collectSubarrays(List<List<Integer>> list, int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                var current = new ArrayList<Integer>();
                current.add(nums[i]);
                list.add(new ArrayList<>(current));
                for (int j = i + 1; j < nums.length; j++) {
                    current.add(nums[j]);
                    list.add(new ArrayList<>(current));
                }
            }
        }

        private boolean isSubarrayValid(List<Integer> list) {
            var min = Integer.MAX_VALUE;
            var max = Integer.MIN_VALUE;

            for (int num : list) {
                min = Math.min(min, num);
                max = Math.max(max, num);
            }
            return min == minK && max == maxK;
        }
    }
}
