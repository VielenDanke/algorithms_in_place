package leetcode.backtracking_recursion.java_solutions;

public class TimeProblem {

    static class Solution {

        public int possibleTimes(String time) {
            char[] timeChars = time.toCharArray();
            int n = time.length();
            int result = 1;
            if (timeChars[n - 1] == '?') {
                result *= 10;
            }
            if (timeChars[n - 2] == '?') {
                result *= 6;
            }
            if (timeChars[n - 4] == '?' && timeChars[n - 5] == '?') {
                result *= 24;
            } else if (timeChars[n - 4] == '?') {
                result *= timeChars[n - 5] - '0' < 2 ? 10 : 4;
            } else if (timeChars[n - 5] == '?') {
                result *= 3;
            }
            return result;
        }
    }

    static class SolutionBacktrack {
        public int possibleTimes(String time) {
            // TODO: not implemented yet
            return -1;
        }
    }
}
