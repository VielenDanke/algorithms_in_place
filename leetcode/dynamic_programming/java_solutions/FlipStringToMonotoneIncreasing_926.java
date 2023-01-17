package leetcode.dynamic_programming.java_solutions;

public class FlipStringToMonotoneIncreasing_926 {

    static class SolutionCountPrefixSuffix {
        public int minFlipsMonoIncr(String s) {
            int n = s.length();
            int[] leftOne = new int[n];
            int[] rightZero = new int[n];
            if (s.charAt(0) == '1') {
                leftOne[0] = 1;
            }
            if (s.charAt(n - 1) == '0') {
                rightZero[n - 1] = 1;
            }
            for (int i = 1; i < n; i++) {
                leftOne[i] = s.charAt(i) == '1' ? leftOne[i - 1] + 1 : leftOne[i - 1];
                rightZero[n - 1 - i] = s.charAt(n - 1 - i) == '0' ? rightZero[n - i] + 1 : rightZero[n - i];
            }
            int min = n;
            for (int i = -1; i < n; i++) {
                int left = i == -1 ? 0 : leftOne[i];
                int right = i == n - 1 ? 0 : rightZero[i + 1];
                min = Math.min(min, left + right);
            }
            return min;
        }
    }

    static class SolutionDP {
        public int minFlipsMonoIncr(String s) {
            char[] letters = s.toCharArray();
            int one = 0, zero = 0;

            for (char current : letters) {
                if (current == '0') {
                    one = Math.min(one, zero) + 1;
                } else {
                    one = Math.min(one, zero);
                    zero += 1;
                }
            }
            return Math.min(one, zero);
        }
    }
}
