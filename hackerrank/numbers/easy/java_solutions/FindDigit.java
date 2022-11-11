package hackerrank.numbers.easy.java_solutions;

public class FindDigit {

    // https://www.hackerrank.com/challenges/find-digits/problem

    static class Solution {
        public static int findDigits(int n) {
            // Write your code here
            int counter = 0;
            int num = n;
            while (n > 0) {
                int current = n % 10;
                if (current != 0 && num % current == 0) {
                    counter++;
                }
                n /= 10;
            }
            return counter;
        }
    }
}
