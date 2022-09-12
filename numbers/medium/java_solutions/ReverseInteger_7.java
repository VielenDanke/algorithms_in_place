package numbers.medium.java_solutions;

public class ReverseInteger_7 {

    static class SolutionShorter {
        public int reverse(int x) {
            int result = 0;

            while (x != 0) {
                int temp = x % 10;
                x /= 10;
                if (result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE / 10 && temp > 7)) {
                    return 0;
                }
                if (result < Integer.MIN_VALUE/10 || (result == Integer.MIN_VALUE / 10 && temp < -8)) {
                    return 0;
                }
                result = result * 10 + temp;
            }
            return result;
        }
    }

    static class Solution {
        public int reverse(int x) {
            long newInt = 0;
            boolean isNegative = x < 0;

            int power = 0;
            int incr = 10;
            int temp = isNegative ? x * -1 : x;

            while (temp > 9) {
                power++;
                temp /= 10;
            }
            temp = isNegative ? x * -1 : x;
            while (temp > 0) {
                int last = temp % 10;
                newInt += Math.pow(incr, power) * last;
                power--;
                temp /= 10;
            }
            return newInt > Integer.MAX_VALUE ? 0 : isNegative ? (int) newInt * -1 : (int) newInt;
        }
    }
}
