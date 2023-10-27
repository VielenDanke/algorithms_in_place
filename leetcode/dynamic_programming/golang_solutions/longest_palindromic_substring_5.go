package golang_solutions

import "strings"

func longestPalindrome(s string) string {
	transformedS := "^#" + strings.Join(strings.Split(s, ""), "#") + "#$"
	n := len(transformedS)
	dp := make([]int, n)
	c, r := 0, 0

	for i := 1; i < n-1; i++ {
		if r > i {
			dp[i] = min(r-i, dp[2*c-i])
		}
		for transformedS[i+1+dp[i]] == transformedS[i-1-dp[i]] {
			dp[i]++
		}
		if i+dp[i] > r {
			c, r = i, i+dp[i]
		}
	}

	maxLen := 0
	centerIndex := 0
	for i, v := range dp {
		if v > maxLen {
			maxLen = v
			centerIndex = i
		}
	}
	return s[(centerIndex-maxLen)/2 : (centerIndex+maxLen)/2]
}
