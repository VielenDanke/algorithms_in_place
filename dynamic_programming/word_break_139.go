package dynamic_programming

func WordBreakDP(s string, wordDict []string) bool {
	dp := make([]bool, len(s)+1)
	dp[0] = true

	for i := 1; i <= len(s); i++ {
		for _, w := range wordDict {
			if i-len(w) >= 0 && dp[i-len(w)] && w == s[i-len(w):i] {
				dp[i] = true
				break
			}
		}
	}
	return dp[len(s)]
}

func WordBreak(s string, wordDict []string) bool {
	storage := make(map[string]interface{})

	for _, v := range wordDict {
		storage[v] = nil
	}
	return repeat(s, storage)
}

func repeat(s string, storage map[string]interface{}) bool {
	if len(s) == 0 {
		return true
	}
	for i := 0; i <= len(s); i++ {
		if _, ok := storage[s[:i]]; ok {
			if repeat(s[i:], storage) {
				return true
			}
		}
	}
	return false
}
