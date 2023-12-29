package leetcode.dynamic_programming.java_solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MinimumDifficultyOfJobSchedule_1335 {

    static class Solution {
        private Integer[][] cache;

        public int minDifficulty(int[] jobDifficulty, int days) {
            final int n = jobDifficulty.length;
            if (n < days) return -1;
            cache = new Integer[n+1][days+1];
            return dfs(days, 0, jobDifficulty);
        }

        private int dfs(int d, int start, int[] jobDifficulty) {
            final int n = jobDifficulty.length;
            if (d == 0 && start == n) return 0;
            if (d == 0 || start == n) return Integer.MAX_VALUE;
            if (cache[start][d] != null) return cache[start][d];

            int curMax = jobDifficulty[start];
            int min = Integer.MAX_VALUE;
            for (int schedule = start; schedule < n; schedule++) {
                curMax = Math.max(curMax, jobDifficulty[schedule]);
                int temp = dfs(d - 1, schedule + 1, jobDifficulty);
                if (temp != Integer.MAX_VALUE) {
                    min = Math.min(min, temp + curMax);
                }
            }
            return cache[start][d] = min;
        }
    }

    static class SolutionTimeLimit {
        public int minDifficulty(int[] jobs, int days) {
        /*
        Constraints:
        1. jobs.length > d - return -1

        Questions:
        1. Is sort needed?

        Approach:
        Try to use backtrack
        1. Add to day 1 only jobs[0]
        2. Add to day 2 all another jobs
        3. Add to day 1 jobs[0]
        4, Add to day 2 all another jobs
        Repeat computation, constraint for recursive calls - day == 0
        */
            if (jobs.length < days) return -1;
            List<Integer> jobsLeft = new ArrayList<>();
            for (int job : jobs) jobsLeft.add(job);
            return backtrack(new LinkedList<>(), jobsLeft, days);
        }

        private int backtrack(LinkedList<List<Integer>> jobsPerDay, List<Integer> jobsLeft, int days) {
            if (days == 1) {
                jobsPerDay.add(jobsLeft);
                int result = 0;
                for (List<Integer> l : jobsPerDay) {
                    int max = 0;
                    for (int job : l) {
                        max = Math.max(max, job);
                    }
                    result += max;
                }
                jobsPerDay.removeLast();
                return result;
            }
            int min = Integer.MAX_VALUE;
            for (int i = 1; i < jobsLeft.size(); i++) {
                jobsPerDay.add(jobsLeft.subList(0, i));
                min = Math.min(min, backtrack(jobsPerDay, jobsLeft.subList(i, jobsLeft.size()), days - 1));
                jobsPerDay.removeLast();
            }
            return min;
        }
    }
}
