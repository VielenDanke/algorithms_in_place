package leetcode.numbers.medium.java_solutions;

import java.util.ArrayList;
import java.util.List;

public class ReorderedPowerOf2_869 {

    private static class SolutionOptimal {
        public boolean reorderedPowerOf2(int N) {
            long c = counter(N);
            for (int i = 0; i < 32; i++)
                if (counter(1 << i) == c) return true;
            return false;
        }

        private long counter(int N) {
            long res = 0;
            for (; N > 0; N /= 10) res += (int) Math.pow(10, N % 10);
            return res;
        }
    }

    private static class SolutionBruteForce {
        public boolean reorderedPowerOf2(int n) {
            /*
            brute-force approach:
            1. find all leetcode.numbers in n
            2. reorder them in random order to create new number
            3. if number is (n & n-1)==0 -> return true
            4. else return false
            */
            List<Integer> numbers = new ArrayList<>();

            while (n > 0) {
                numbers.add(n % 10);
                n /= 10;
            }
            return backtrack(numbers, "", new boolean[numbers.size()]);
        }

        private boolean backtrack(List<Integer> numbers, String result, boolean[] visited) {
            if (numbers.size() == result.length() && result.charAt(0) - '0' != 0) {
                int n = Integer.parseInt(result);
                return (n & n - 1) == 0;
            }
            for (int i = 0; i < numbers.size(); i++) {
                if (visited[i]) {
                    continue;
                }
                visited[i] = true;
                if (backtrack(numbers, result + numbers.get(i), visited)) {
                    return true;
                }
                visited[i] = false;
            }
            return false;
        }
    }
}
