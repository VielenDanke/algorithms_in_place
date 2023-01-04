package leetcode.array.medium.java_solutions;

import java.util.HashMap;
import java.util.Map;

public class MaximumRoundsToCompleteAllTasks_2244 {

    static class Solution {
        public int minimumRounds(int[] tasks) {
            Map<Integer, Integer> taskCounter = new HashMap<>();

            for (int task : tasks) {
                taskCounter.put(task, taskCounter.getOrDefault(task, 0) + 1);
            }
            int rounds = 0;

            for (Map.Entry<Integer, Integer> entry : taskCounter.entrySet()) {
                int currentCounter = entry.getValue();

                if (currentCounter == 1) return -1;

                rounds += currentCounter / 3;

                if (currentCounter % 3 != 0) {
                    rounds += 1;
                }

            }
            return rounds;
        }
    }
}
