package hackerrank.numbers.easy.java_solutions;

public class LibraryFine {

    // https://www.hackerrank.com/challenges/library-fine/problem

    static class Solution {

        public static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
            if (isReturnedBefore(d1, m1, y1, d2, m2, y2)) {
                return 0;
            }
            return calculateFee(d1, m1, y1, d2, m2, y2);
        }

        private static int calculateFee(int d1, int m1, int y1, int d2, int m2, int y2) {
            if (y1 > y2) {
                return 10000;
            } else if (m1 > m2) {
                return 500 * (m1 - m2);
            } else if (d1 > d2) {
                return 15 * (d1 - d2);
            }
            return 0;
        }

        private static boolean isReturnedBefore(int d1, int m1, int y1, int d2, int m2, int y2) {
            if (y1 < y2) {
                return true;
            } else if (y1 == y2 && m1 < m2) {
                return true;
            } else return y1 == y2 && m1 == m2 && d1 < d2;
        }
    }
}
