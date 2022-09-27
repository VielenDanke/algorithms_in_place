package dynamic_programming.java_solutions;

public class CoinChange2_518 {

    // TODO: more solutions to come
    static class SolutionBruteForce {
        private int counter;

        public int change(int amount, int[] coins) {
            counter = 0;
            backtrack(coins, amount, 0);
            return counter;
        }

        private void backtrack(int[] coins, int amount, int start) {
            if (amount == 0) {
                counter++;
                return;
            }
            for (int i = start; i < coins.length; i++) {
                if (amount - coins[i] < 0) continue;
                backtrack(coins, amount - coins[i], i);
            }
        }
    }
}
