package leetcode.sorting.medium.java_solutions;

import java.util.*;

public class ReductionOperationsToMakeTheArrayElementsEquals_1887 {

    static class Solution {
        public int reductionOperations(int[] nums) {
            Arrays.sort(nums);

            int operations = 0;

            for (int i = nums.length - 1; i > 0; i--) {
                if (nums[i] > nums[i - 1]) {
                    operations += (nums.length - i);
                }
            }
            return operations;
        }
    }

    static class SolutionCountingSort {
        public int reductionOperations(int[] nums) {
            int n = nums.length;
            int[] freq = new int[50001];
            for (int num : nums) {
                freq[num]++;
            }
            int res = 0, operations = 0;
            for (int i = 50000; i >= 1; i--) {
                if (freq[i] > 0) {
                    operations += freq[i];
                    res += operations - freq[i];
                }
            }
            return res;
        }
    }

    static class SolutionTreeMap {
        public int reductionOperations(int[] nums) {
            TreeMap<Integer, Integer> map = new TreeMap<>((left, right) -> right - left);

            for (int num : nums) {
                map.merge(num, 1, Integer::sum);
            }
            int operations = 0;
            while (map.size() > 1) {
                Map.Entry<Integer, Integer> first = map.pollFirstEntry();

                operations += first.getValue();

                if (!map.isEmpty()) {
                    map.merge(map.firstKey(), first.getValue(), Integer::sum);
                }
            }
            return operations;
        }
    }

    static class SolutionMaxHeap {
        public int reductionOperations(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();

            Queue<Integer> queue = new PriorityQueue<>((left, right) -> right - left);
            for (int num : nums) {
                int result = map.merge(num, 1, Integer::sum);
                if (result == 1) {
                    queue.offer(num);
                }
            }
            int operations = 0;
            while (!queue.isEmpty()) {
                int number = queue.poll();
                if (!queue.isEmpty()) {
                    int currentOperations = map.remove(number);
                    operations += currentOperations;
                    map.merge(queue.peek(), currentOperations, Integer::sum);
                }
            }
            return operations;
        }
    }
}
