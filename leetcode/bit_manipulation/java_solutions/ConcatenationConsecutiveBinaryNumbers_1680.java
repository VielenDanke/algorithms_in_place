package leetcode.bit_manipulation.java_solutions;

public class ConcatenationConsecutiveBinaryNumbers_1680 {

    static class Solution {

        // Approach:
        // Using bit manipulation as described below.
        // A bit of description for the bitwise operations used, if you are not familiar.
        // 1. & - Bitwise AND operation:
        //    0 & 0 = 0,
        //    1 & 0 = 0,
        //    1 & 1 = 1.
        //    Example : 1101 & 1010 = 1000
        //
        // 2. << - Shift Left operation, by n position:
        //    Example:
        //    11 (3) << 2 (n position) = 1100 (14)
        //

        public int concatenatedBinary(int n) {

            final long modulo = (long) (1e9 + 7);
            long result = 0;

            // This records the number of binaryDigits we need to shift left.
            int binaryDigits = 0;

            for (int i = 1; i <= n; i++) {

                // If i is a power of 2, we add one additional binaryDigits to shift.
                // Example:
                // i = 8 (1000), i-1 = 7 (111)
                // i & (i-1) = 1000 & 111 = 0
                // So we know we have increased the binaryDigits from 3 (in 111) to 4 (in 1000).
                if ((i & (i - 1)) == 0) {
                    binaryDigits++;
                }

                // With the updated binaryDigits, we now can concatenate i to the result.
                // Each time get the remainder of the result % modulo.
                // Example:
                // i = 2
                // result = 1 (1) << 2 (n position) + 10 (2) = 100 (4) + 10 (2) = 110 (6).
                // i = 3
                // result = 110 (6) << 2 (n position) + 11 (3) = 11000 (24) + 11 (3) = 11011 (27).
                //
                result = ((result << binaryDigits) + i) % modulo;
            }
            return (int) result;
        }
    }

    static class SolutionMath {

        // Approach:
        // We concatenate by shifting position of result with division and multiplication, then add the number.
        // As there are a lot of repetitions in shifting of positions, it is much less efficient than using bit manipulation.

        public int concatenatedBinary(int n) {
            final long modulo = (long) (1e9 + 7);
            long result = 0;
            for (int i = 1; i <= n; i++) {
                int temp = i;
                while (temp > 0) {
                    temp /= 2;
                    result *= 2;
                }
                result = (result + i) % modulo;
            }
            return (int) result;
        }
    }
}
