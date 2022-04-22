package golang_solutions

// link https://leetcode.com/problems/longest-increasing-subsequence/

/*
Python solution
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        LIS = [1] * len(nums)

        for i in range(len(nums) - 1, -1, -1):
            for j in range(i + 1, len(nums)):
                if nums[i] < nums[j]:
                    LIS[i] = max(LIS[i], 1 + LIS[j])
        return max(LIS)
*/

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
