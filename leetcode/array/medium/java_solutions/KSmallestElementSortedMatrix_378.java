package leetcode.array.medium.java_solutions;

import java.util.PriorityQueue;
import java.util.Queue;

public class KSmallestElementSortedMatrix_378 {

    static class Solution {
        public int kthSmallest(int[][] matrix, int k) {
            Queue<Integer> queue = new PriorityQueue<>();

            for (int[] ints : matrix) {
                for (int num : ints) {
                    queue.add(num);
                }
            }
            int last = 0;
            while (k-- != 0 && !queue.isEmpty()) {
                last = queue.poll();
            }
            return last;
        }
    }
}
