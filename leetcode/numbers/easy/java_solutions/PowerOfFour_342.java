package leetcode.numbers.easy.java_solutions;

public class PowerOfFour_342 {

    static class Solution {
        public boolean isPowerOfFour(int n) {
            while (n > 1) {
                if (n % 4 != 0) {
                    return false;
                }
                n /= 4;
            }
            return n == 1;
        }
    }

    static class SolutionBinary {
        public boolean isPowerOfFour(int num) {
            return num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) != 0;
        }
    }
}
