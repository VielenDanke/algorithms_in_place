package leetcode.dynamic_programming.java_solutions;

public class BestTimeToBuyAndSellStockWithCooldown_309 {

    static class SolutionNoArray {
        public int maxProfit(int[] prices) {
            int pSell = 0, pBuy, sell = 0, buy = Integer.MIN_VALUE;
            for (int price : prices) {
                pBuy = buy;
                buy = Math.max(buy, pSell - price);
                pSell = sell;
                sell = Math.max(sell, pBuy + price);
            }
            return sell;
        }
    }

    static class SolutionDP {

        public int maxProfit(int[] prices) {
            if (prices == null || prices.length <= 1) return 0;
            int n = prices.length;
            int[] s0 = new int[n], s1 = new int[n], s2 = new int[n];
            s1[0] = -prices[0];
            s0[0] = 0;
            s2[0] = Integer.MIN_VALUE;

            for (int i = 1; i < n; i++) {
                s0[i] = Math.max(s0[i - 1], s2[i - 1]);
                s1[i] = Math.max(s1[i - 1], s0[i - 1] - prices[i]);
                s2[i] = s1[i - 1] + prices[i];
            }
            return Math.max(s0[n - 1], s2[n - 1]);
        }
    }

    static class SolutionMemo {
        private Integer[][] memo;

        public int maxProfit(int[] prices) {
            memo = new Integer[prices.length][2];
            return backtrack(prices, 0, true);
        }

        private int backtrack(int[] prices, int idx, boolean isBuy) {
            if (idx >= prices.length) {
                return 0;
            }
            if (memo[idx][isBuy ? 1 : 0] != null) return memo[idx][isBuy ? 1 : 0];
            int budget = 0;
            for (int i = idx; i < prices.length; i++) {
                if (isBuy) {
                    budget = Math.max(budget, backtrack(prices, i + 1, false) - prices[i]);
                } else {
                    budget = Math.max(budget, backtrack(prices, i + 2, true) + prices[i]);
                }
            }
            memo[idx][isBuy ? 1 : 0] = budget;
            return budget;
        }
    }
}
