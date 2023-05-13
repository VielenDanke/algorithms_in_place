package leetcode.dynamic_programming.java_solutions;

public class SolvingQuestionsWithBrainpower_2140 {

    static class Solution {

        private Long[] cache;

        public long mostPoints(int[][] questions) {
            this.cache = new Long[questions.length];
            return backtrack(questions, 0);
        }

        private long backtrack(int[][] questions, int start) {
            if (start >= questions.length) return 0;
            if (cache[start] != null) return cache[start];
            long skip = backtrack(questions, start + 1);
            long add = backtrack(questions, start + questions[start][1] + 1) + questions[start][0];
            return cache[start] = Math.max(skip, add);
        }
    }

    static class SolutionBruteForce {

        public long mostPoints(int[][] questions) {
            return backtrack(questions, 0, 0);
        }

        private long backtrack(int[][] questions, int start, int rest) {
            if (start >= questions.length) {
                return 0;
            }
            long max = 0;
            for (int i = start; i < questions.length; i++) {
                if (rest-- <= 0) {
                    max = Math.max(max, backtrack(questions, i + 1, questions[i][1]) + questions[i][0]);
                }
            }
            return max;
        }
    }
}
