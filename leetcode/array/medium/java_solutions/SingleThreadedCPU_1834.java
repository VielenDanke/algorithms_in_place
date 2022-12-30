package leetcode.array.medium.java_solutions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SingleThreadedCPU_1834 {

    static class Solution {
        public int[] getOrder(int[][] tasks) {
            int n = tasks.length;
            Task[] arr = new Task[n];
            for (int i = 0; i < n; i++) {
                arr[i] = new Task(i, tasks[i][0], tasks[i][1]);
            }
            Arrays.sort(arr, Comparator.comparingInt(a -> a.enqueueTime));

            PriorityQueue<Task> p = new PriorityQueue<>((a, b) -> {
                if (a.processingTime == b.processingTime) {
                    return Integer.compare(a.idx, b.idx);
                }
                return Integer.compare(a.processingTime, b.processingTime);
            });

            int[] result = new int[n];
            int ansIdx = 0;
            int taskIdx = 0;
            int curTime = 0;

            while (ansIdx < n) {
                while (taskIdx < n && arr[taskIdx].enqueueTime <= curTime) {
                    p.offer(arr[taskIdx++]);
                }
                if (p.isEmpty()) {
                    curTime = arr[taskIdx].enqueueTime;
                } else {
                    curTime += p.peek().processingTime;
                    result[ansIdx++] = p.poll().idx;
                }
            }
            return result;
        }

        private static class Task {
            int idx;
            int enqueueTime;
            int processingTime;

            Task(int idx, int en, int pro) {
                this.idx = idx;
                this.enqueueTime = en;
                this.processingTime = pro;
            }
        }
    }
}
