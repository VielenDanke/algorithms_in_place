package leetcode.array.medium.java_solutions;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindKLargestElement_215 {

    // Sorting O(N * logN) time | O(1) space

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    // ----------------------------------------------------------------------------
    // MaxHeap O(K + N * logM) | O(N) space
    // K - k element from nums, N - length of nums, M - insertion complexity

    public int findKthLargestQueue(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>((l, r) -> r - l);
        for (int num : nums) queue.add(num);
        int lastElem = 0;
        while (k-- != 0 && !queue.isEmpty()) lastElem = queue.poll();
        return lastElem;
    }
}
