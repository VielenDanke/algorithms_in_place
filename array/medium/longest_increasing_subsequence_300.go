package medium

// link https://leetcode.com/problems/longest-increasing-subsequence/

// Time limit

var globalCounter int

func LengthOfLIS(nums []int) int {
	globalCounter = -1 << 31
	for i := range nums {
		backtrack(nums, nums[i], i+1, 1)
	}
	return globalCounter
}

func backtrack(nums []int, prev, start, counter int) {
	for i := start; i < len(nums); i++ {
		if nums[i] > prev {
			backtrack(nums, nums[i], i+1, counter+1)
		} else {
			continue
		}
	}
	if globalCounter < counter {
		globalCounter = counter
	}
}

func LengthOfLISTabulation(nums []int) (max int) {
	dp := make([]int, len(nums))

	for i := range dp {
		dp[i] = 1
	}
	for i := len(nums) - 1; i >= 0; i-- {
		for j := i + 1; j < len(nums); j++ {
			if nums[i] < nums[j] {
				dp[i] = maxNum(dp[i], dp[j]+1)
			}
		}
	}
	return maxNum(dp...)
}

func maxNum(vals ...int) int {
	max := -1 << 31
	for i := range vals {
		if max < vals[i] {
			max = vals[i]
		}
	}
	return max
}
