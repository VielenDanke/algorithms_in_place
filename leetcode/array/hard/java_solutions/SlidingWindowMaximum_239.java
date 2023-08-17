package leetcode.array.hard.java_solutions;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class SlidingWindowMaximum_239 {

    static class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> nums[b] - nums[a]);
            int n = nums.length;
            int[] ans = new int[n - k + 1];
            int idx = 0;
            for (int i = 0; i < n; i++) {
                while (!pq.isEmpty() && pq.peek() <= i - k) {
                    pq.remove();
                }
                pq.add(i);
                if (i >= k - 1) {
                    ans[idx++] = nums[pq.peek()];
                }
            }
            return ans;
        }
    }

    static class SolutionBruteForce {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int left = 0, currentIdx = 0;

            while (left + k <= nums.length) {
                int max = Integer.MIN_VALUE;
                for (int i = left; i < left + k; i++) {
                    max = Math.max(max, nums[i]);
                }
                left++;
                nums[currentIdx] = max;
                currentIdx++;
            }
            return Arrays.copyOfRange(nums, 0, currentIdx);
        }
    }
}
