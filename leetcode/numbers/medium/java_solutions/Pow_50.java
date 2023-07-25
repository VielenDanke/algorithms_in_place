package leetcode.numbers.medium.java_solutions;

public class Pow_50 {

    static class SolutionBruteForce {
        public double myPow(double x, int n) {
            if (n < 0) {
                x = 1 / x;
                n *= -1;
            }
            double root = x;
            if (n > 0) {
                while (n > 1) {
                    root *= x;
                    n--;
                }
            } else {
                root = 1.0;
            }
            return root;
        }
    }

    static class SolutionRecursive {

        public double myPow(double base, int exponent) {
            if (exponent == 0)
                return 1;
            if (exponent < 0) {
                return 1 / base * myPow(1 / base, -(exponent + 1));
            }
            return (exponent % 2 == 0) ?
                myPow(base * base, exponent / 2) :
                base * myPow(base * base, exponent / 2);
        }
    }

    static class Solution {
        public double myPow(double base, int exponent) {
            if (exponent == 0) {
                return 1.0;
            }

            double result = 1.0;
            double current = base;
            long absExponent = Math.abs((long) exponent);

            while (absExponent > 0) {
                if ((absExponent & 1) == 1) {
                    result *= current;
                }
                current *= current;
                absExponent >>= 1;
            }

            return exponent < 0 ? 1.0 / result : result;
        }
    }
}
