package leetcode.dynamic_programming.java_solutions;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;

public class ConstrainedSubsequenceSum_1425 {

    static class SolutionDeque {
        public int constrainedSubsetSum(int[] nums, int k) {
            int[] dp = Arrays.copyOf(nums, nums.length);
            Deque<Integer> q = new ArrayDeque<>();
            q.offerLast(0);
            for (int i = 1; i < nums.length; i++) {
                while (!q.isEmpty() && q.peekLast() < i - k) {
                    q.pollLast();
                }
                if (q.isEmpty()) {
                    continue;
                }
                dp[i] = Math.max(dp[i], dp[q.peekLast()] + nums[i]);
                while (!q.isEmpty() && dp[q.peekFirst()] <= dp[i]) {
                    q.pollFirst();
                }
                q.offerFirst(i);
            }
            int max = Integer.MIN_VALUE;
            for (int num : dp) {
                max = Math.max(max, num);
            }
            return max;
        }
    }

    static class Solution {
        public int constrainedSubsetSum(int[] nums, int k) {
            PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
            heap.offer(new int[]{nums[0], 0});
            int max = nums[0];

            for (int i = 1; i < nums.length; i++) {
                while (!heap.isEmpty() && i - heap.peek()[1] > k) {
                    heap.poll();
                }
                if (heap.isEmpty()) {
                    continue;
                }
                int temp = Math.max(0, heap.peek()[0]) + nums[i];
                max = Math.max(max, temp);
                heap.offer(new int[]{temp, i});
            }
            return max;
        }
    }

    static class SolutionBruteForceTwo {
        private int rootK;

        public int constrainedSubsetSum(int[] nums, int k) {
            // subsequence max sum that every two consecutive integers i < j and j - i <= k
            this.rootK = k;
            int result = -1;
            for (int i = 0; i < nums.length; i++) {
                result = Math.max(result, backtrack(nums, i, k, 0));
            }
            return result <= 0 ? -1 : result;
        }

        private int backtrack(int[] nums, int idx, int k, int sum) {
            if (k <= 0 || idx >= nums.length) {
                return sum;
            }
            int max = -1;
            max = Math.max(max, backtrack(nums, idx + 1, k - 1, sum));
            max = Math.max(max, backtrack(nums, idx + 1, rootK, sum + nums[idx]));
            return max;
        }
    }

    static class SolutionBruteForce {
        public int constrainedSubsetSum(int[] nums, int k) {
            // subsequence max sum that every two consecutive integers i < j and j - i <= k
            int max = -1;
            for (int i = 0; i < nums.length; i++) {
                max = Math.max(max, backtrack(nums, 0, k, i));
            }
            return max;
        }

        private int backtrack(int[] nums, int sum, int k, int start) {
            if (start >= nums.length) {
                return sum;
            }
            int max = -1;
            for (int i = start; i < (Math.min(start + k, nums.length)); i++) {
                if (sum + nums[i] < 0) {
                    continue;
                }
                sum += nums[i];
                max = Math.max(max, sum);
                max = Math.max(max, backtrack(nums, sum, k, i + 1));
                sum -= nums[i];
            }
            return max;
        }
    }
}
