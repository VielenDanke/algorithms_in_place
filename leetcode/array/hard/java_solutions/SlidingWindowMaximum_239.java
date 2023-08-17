package leetcode.array.hard.java_solutions;

import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class SlidingWindowMaximum_239 {

    static class SolutionTreeMap {
        public int[] maxSlidingWindow(int[] nums, int k) {
            TreeMap<Integer, Integer> map = new TreeMap<>((left, right) -> right - left);

            int size = 0, currentIdx = 0;

            for (int i = 0; i < nums.length; i++) {
                int currentNum = nums[i];
                map.put(currentNum, map.getOrDefault(currentNum, 0) + 1);
                size++;
                if (size == k) {
                    Map.Entry<Integer, Integer> entry = map.firstEntry();
                    int max = entry.getKey();
                    int prevNum = nums[i - k + 1];
                    map.put(prevNum, map.getOrDefault(prevNum, 0) - 1);
                    if (map.get(prevNum) <= 0) {
                        map.remove(prevNum);
                    }
                    nums[currentIdx++] = max;
                    size--;
                }
            }
            return Arrays.copyOfRange(nums, 0, currentIdx);
        }
    }

    static class SolutionPriorityQueue {
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
