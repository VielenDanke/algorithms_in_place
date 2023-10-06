package leetcode.numbers.medium.java_solutions;

public class IntegerBreak_343 {

    static class SolutionShorter {
        public int integerBreak(int n) {
            if (n <= 3) return n - 1;
            int quotient = n / 3, remainder = n % 3;
            return remainder == 0 ? (int) Math.pow(3, quotient) : (remainder == 1 ? (int) Math.pow(3, quotient - 1) * 4 : (int) Math.pow(3, quotient) * 2);
        }
    }

    static class Solution {
        public int integerBreak(int n) {
            if (n == 2) {
                return 1;
            } else if (n == 3) {
                return 2;
            }
            int init = 2, max = 0, p1, p2;
            while (true) {
                p1 = n / init;
                if (p1 == 1) {
                    break;
                }
                p2 = n % init;
                int cInit = init;
                int temp = 1;
                while (cInit > 0) {
                    int p1Copy = p1;
                    if (p2 > 0) {
                        p1Copy++;
                    }
                    temp *= p1Copy;
                    p2--;
                    cInit--;
                }
                init++;
                max = Math.max(max, temp);
            }
            return max;
        }
    }
}
