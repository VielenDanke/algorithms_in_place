package leetcode.array.medium.java_solutions;

import java.util.*;

public class MaximumSubsequenceScore_2542 {

    static class Solution {
        public long maxScore(int[] nums1, int[] nums2, int k) {
            int n = nums1.length;
            int[][] pairs = new int[n][2];
            for (int i = 0; i < n; ++i) {
                pairs[i] = new int[]{nums1[i], nums2[i]};
            }
            Arrays.sort(pairs, (a, b) -> b[1] - a[1]);

            PriorityQueue<Integer> topKHeap = new PriorityQueue<>(k, Comparator.comparingInt(a -> a));
            long topKSum = 0;
            for (int i = 0; i < k; ++i) {
                topKSum += pairs[i][0];
                topKHeap.add(pairs[i][0]);
            }
            long answer = topKSum * pairs[k - 1][1];

            for (int i = k; i < n && !topKHeap.isEmpty(); ++i) {
                topKSum += pairs[i][0] - topKHeap.poll();
                topKHeap.add(pairs[i][0]);
                answer = Math.max(answer, topKSum * pairs[i][1]);
            }

            return answer;
        }
    }

    static class SolutionBruteForce {
        private long max;

        public long maxScore(int[] nums1, int[] nums2, int k) {
            this.max = Long.MIN_VALUE;
            backtrack(new ArrayList<>(), nums1, nums2, k, 0);
            return max;
        }

        private void backtrack(List<Integer> indexes, int[] nums1, int[] nums2, int k, int start) {
            if (indexes.size() == k) {
                max = Math.max(max, calculateResult(indexes, nums1, nums2));
                return;
            }
            if (start > nums1.length) {
                return;
            }
            for (int i = start; i < nums1.length; i++) {
                indexes.add(i);
                backtrack(indexes, nums1, nums2, k, i + 1);
                indexes.remove(indexes.size() - 1);
            }
        }

        private int calculateResult(List<Integer> indexes, int[] nums1, int[] nums2) {
            int min = Integer.MAX_VALUE;
            int sum = 0;

            for (Integer idx : indexes) {
                sum += nums1[idx];
                min = Math.min(min, nums2[idx]);
            }
            return sum * min;
        }
    }
}
