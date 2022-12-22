package leetcode.numbers.easy.java_solutions;

public class ArrangingCoins_441 {

    static class SolutionBinarySearch {
        public int arrangeCoins(int n) {
            if (n <= 1) {
                return n;
            }
            if (n <= 3) {
                return n == 3 ? 2 : 1;
            }
            long start = 2;
            long end = n / 2;
            while (start <= end) {
                long mid = start + (end - start) / 2;
                long coinsFilled = mid * (mid + 1) / 2;
                if (coinsFilled == n) {
                    return (int) mid;
                }
                if (coinsFilled < n) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            return (int) end;
        }
    }

    static class SolutionBit {
        public int arrangeCoins(int n) {
            int mask = 1 << 15;
            long result = 0;
            while (mask > 0) {
                result |= mask;
                if (result * (result + 1) / 2 > n) {
                    result ^= mask;
                }
                mask >>= 1;
            }
            return (int) result;
        }
    }

    static class SolutionMath {
        public int arrangeCoins(int n) {
            return (int) (Math.sqrt(2 * (long) n + 0.25) - 0.5);
        }
    }

    static class Solution {
        public int arrangeCoins(int n) {
            int incr = 1;

            while (n >= 0) {
                if (n - incr < 0) {
                    return incr - 1;
                }
                n -= incr;
                incr++;
            }
            return -1;
        }
    }
}
