package hackerrank.numbers.easy;

public class BookPage {

    // https://www.hackerrank.com/challenges/drawing-book
    static class Solution {
        public static int pageCount(int n, int p) {
            // Write your code here
            int leftCounter = 0;
            int leftIdx = 1;

            while (leftIdx < p) {
                leftIdx += 2;
                leftCounter++;
            }
            int rightCounter = 0, rightIdx = n;
            if (n % 2 != 0) {
                rightIdx = n - 1;
            }
            while (rightIdx > p) {
                rightIdx -= 2;
                rightCounter++;
            }
            return Math.min(leftCounter, rightCounter);
        }
    }
}
