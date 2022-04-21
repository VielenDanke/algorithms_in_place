package easy

// link https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

/*
Python solution

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        left, right, maxProfit = 0, 1, 0

        while right < len(prices):
            while right < len(prices) and prices[right] - prices[left] > 0:
                if maxProfit < prices[right] - prices[left]:
                    maxProfit = prices[right] - prices[left]
                right = right + 1
            left = right
            right = left + 1
        return maxProfit
*/

func MaxProfit(prices []int) (maxProfit int) {
	left, right := 0, 1

	for right < len(prices) {
		for right < len(prices) && prices[right]-prices[left] > 0 {
			if maxProfit < prices[right]-prices[left] {
				maxProfit = prices[right] - prices[left]
			}
			right++
		}
		left = right
		right = left + 1
	}
	return maxProfit
}
