package leetcode.array.medium.java_solutions;

public class KokoEatingBananas_875 {

    static class SolutionBinarySearch {
        public int minEatingSpeed(int[] piles, int h) {
            int maxPile = Integer.MIN_VALUE, middlePile;

            for (int pile : piles) maxPile = Math.max(maxPile, pile);

            int minPile = maxPile / h == 0 ? 1 : maxPile / h;

            while (minPile < maxPile) {
                middlePile = minPile + (maxPile - minPile) / 2;

                int total = 0;

                for (int pile : piles) total += (pile + middlePile - 1) / middlePile;

                if (total > h) {
                    minPile = middlePile + 1;
                } else {
                    maxPile = middlePile;
                }
            }
            return minPile;
        }
    }

    static class SolutionBruteForce {
        public int minEatingSpeed(int[] piles, int h) {
            int maxPile = Integer.MIN_VALUE, n = piles.length;

            for (int pile : piles) {
                maxPile = Math.max(maxPile, pile);
            }
            int min = maxPile / h == 0 ? 1 : maxPile / h;

            int[] newPile = new int[n];

            while (true) {
                int cH = h;
                for (int i = 0; i < n; i++) {
                    newPile[i] = piles[i];
                    cH -= newPile[i] / min;
                    if (newPile[i] % min != 0) {
                        cH--;
                    }
                    if (cH <= 0 && i != n - 1) {
                        break;
                    } else if (cH >= 0 && i == n - 1) {
                        return min;
                    }
                }
                min++;
            }
        }
    }
}
