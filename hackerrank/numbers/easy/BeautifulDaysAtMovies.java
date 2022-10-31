package hackerrank.numbers.easy;

public class BeautifulDaysAtMovies {

    static class Solution {

        public static int beautifulDays(int i, int j, int k) {
            int counter = 0;
            for (int num = i; num <= j; num++) {
                if (Math.abs(reverseInteger(num) - num) % k == 0) {
                    counter++;
                }
            }
            return counter;
        }

        private static int reverseInteger(int num) {
            int power = 1;
            int copyNum = num;

            while (copyNum > 0) {
                copyNum /= 10;
                power *= 10;
            }
            power /= 10;
            int result = 0;
            while (num > 0) {
                result += power * (num % 10);
                num /= 10;
                power /= 10;
            }
            return result;
        }
    }
}
