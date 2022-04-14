package dynamic_programming

func rob(nums []int) int {
	n := len(nums)
	if n == 1 {
		return nums[0]
	}
	n += 1
	dp := make([]int, n)
	dp[0] = nums[0]
	dp[1] = maxRob(nums[0], nums[1])
	for i := 2; i < n; i++ {
		f := dp[i-1]
		s := dp[i-2]
		if i < len(nums) {
			s += nums[i]
		}
		dp[i] = maxRob(f, s)
	}
	return dp[n-1]
}

func maxRob(f, s int) int {
	if f > s {
		return f
	}
	return s
}
