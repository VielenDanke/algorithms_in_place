package hackerrank.numbers.easy.java_solutions;

import java.math.BigInteger;

public class ExtraLongFactorials {

    // https://www.hackerrank.com/challenges/extra-long-factorials/problem

    static class Solution {
        public static void extraLongFactorials(int n) {
            // Write your code here
            BigInteger result = new BigInteger("1");
            while (n > 0) {
                result = result.multiply(BigInteger.valueOf(n));
                n--;
            }
            System.out.println(result);
        }
    }
}
