package array.easy.java_solutions;

import java.util.Arrays;

public class BestTimeToBuyAndSellStock_121 {

    public int maxProfit(int[] prices) {
        int left = 0, right = 1, maxProfit = 0;

        while (right < prices.length) {
            while (right < prices.length && prices[right] - prices[left] > 0) {
                if (maxProfit < prices[right] - prices[left]) {
                    maxProfit = prices[right] - prices[left];
                }
                right++;
            }
            left = right;
            right = left + 1;
        }
        return maxProfit;
    }

    public int maxProfitDivideAndConquer(int[] prices) {
      return -1;
    }

    public static void main(String[] args) {
        int i = new BestTimeToBuyAndSellStock_121().maxProfitDivideAndConquer(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(i);
    }
}
