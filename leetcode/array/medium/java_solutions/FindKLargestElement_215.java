package leetcode.array.medium.java_solutions;

import java.util.*;

public class FindKLargestElement_215 {

    // Sorting O(N * logN) time | O(1) space

    static class SolutionSort {
        public int findKthLargest(int[] nums, int k) {
            Arrays.sort(nums);
            return nums[nums.length - k];
        }
    }

    // ----------------------------------------------------------------------------
    // MaxHeap O(K + N * logM) | O(N) space
    // K - k element from nums, N - length of nums, M - insertion complexity

    static class SolutionQueue {
        public int findKthLargest(int[] nums, int k) {
            Queue<Integer> queue = new PriorityQueue<>((l, r) -> r - l);
            for (int num : nums) queue.add(num);
            int lastElem = 0;
            while (k-- != 0 && !queue.isEmpty()) lastElem = queue.poll();
            return lastElem;
        }
    }

    // No sorting, O(N - M) where N - max value in array, M - min value in array

    static class SolutionMap {
        public int findKthLargest(int[] nums, int k) {
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

            Map<Integer, Integer> m = new HashMap<>();

            for (int num : nums) {
                min = Math.min(min, num);
                max = Math.max(max, num);
                m.put(num, m.getOrDefault(num, 0) + 1);
            }
            for (int i = max; i >= min; i--) {
                k -= m.getOrDefault(i, 0);
                if (k <= 0) {
                    return i;
                }
            }
            return -1;
        }
    }
}
