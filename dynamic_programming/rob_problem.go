package main

func Rob(nums []int) int {
	n := len(nums) + 1
	if n == 1 {
		return nums[0]
	}
	dp := make([]int, n)
	dp[0] = nums[0]
	dp[1] = max(nums[0], nums[1])
	for i := 2; i < n; i++ {
		f := dp[i-1]
		s := dp[i-2]
		if i < len(nums) {
			s += nums[i]
		}
		dp[i] = max(f, s)
	}
	return dp[n-1]
}
