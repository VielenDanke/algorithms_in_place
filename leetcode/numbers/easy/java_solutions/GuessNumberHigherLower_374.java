package leetcode.numbers.easy.java_solutions;

public class GuessNumberHigherLower_374 {

    private static class GuessGame {

        /**
         * Forward declaration of guess API.
         *
         * @param num your guess
         * @return -1 if num is higher than the picked number
         * 1 if num is lower than the picked number
         * otherwise return 0
         * int guess(int num);
         */
        protected int guess(int num) {
            return -1;
        }
    }

    static class Solution extends GuessGame {

        public int guessNumber(int n) {
            int min = 1;
            int max = n;

            while (true) {
                int middle = min + (max - min) / 2;
                int result = guess(middle);
                if (result == 0) {
                    return middle;
                } else if (result > 0) {
                    min = middle + 1;
                } else {
                    max = middle - 1;
                }
            }
        }
    }
}
