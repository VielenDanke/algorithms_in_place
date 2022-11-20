package hackerrank.string.easy.java_solutions;

public class RepeatedString {

    // https://www.hackerrank.com/challenges/repeated-string/problem

    static class Solution {

        public static long repeatedString(String s, long n) {
            // Write your code here
            int counter = 0, l = s.length();

            for (int i = 0; i < l; i++) {
                if (s.charAt(i) == 'a') {
                    counter++;
                }
            }
            long aCounter = n / l * counter;
            if (n % l == 0) {
                return aCounter;
            }
            long floor = n / l;

            for (long i = floor * l; i < n; i++) {
                if (s.charAt((int) (i % l)) == 0) {
                    aCounter++;
                }
            }
            return aCounter;
        }
    }
}
