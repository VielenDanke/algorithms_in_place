package greedy_algorithms.medium.java_solutions;

import java.util.*;

public class TaskScheduler_621 {

    private static class Solution {

        public int leastInterval(char[] tasks, int n) {
            int[] counter = new int[26];
            int max = 0;
            int maxCount = 0;
            for (char task : tasks) {
                counter[task - 'A']++;
                if (max == counter[task - 'A']) {
                    maxCount++;
                } else if (max < counter[task - 'A']) {
                    max = counter[task - 'A'];
                    maxCount = 1;
                }
            }
            int partCount = max - 1;
            int partLength = n - (maxCount - 1);
            int emptySlots = partCount * partLength;
            int availableTasks = tasks.length - max * maxCount;
            int idles = Math.max(0, emptySlots - availableTasks);

            return tasks.length + idles;
        }
    }

    private static class SolutionBruteForce {

        private static class Pair {
            char task;
            int jobs;

            Pair(char task, int jobs) {
                this.task = task;
                this.jobs = jobs;
            }
        }

        public int leastInterval(char[] tasks, int n) {
            if (tasks == null || tasks.length == 0) {
                return 0;
            }
            int N = tasks.length;

            if (n == 0) {
                return N;
            }
            Map<Character, Integer> dict = new HashMap<>();

            for (char task : tasks) {
                if (dict.containsKey(task)) {
                    dict.put(task, dict.get(task) + 1);
                } else {
                    dict.put(task, 1);
                }
            }
            Queue<Pair> queue = new PriorityQueue<>((left, right) -> right.jobs - left.jobs);

            dict.forEach((key, value) -> queue.add(new Pair(key, value)));

            int result = 0;

            while (!queue.isEmpty()) {
                List<Pair> polled = new ArrayList<>();

                int temp = n;

                while (temp >= 0) {
                    if (!queue.isEmpty()) {
                        Pair lastElem = queue.poll();

                        lastElem.jobs -= 1;

                        if (lastElem.jobs > 0) {
                            polled.add(lastElem);
                        }
                    }
                    if (queue.isEmpty() && polled.isEmpty()) {
                        return result + 1;
                    }
                    result++;
                    temp--;
                }
                queue.addAll(polled);
            }
            return result;
        }
    }
}
