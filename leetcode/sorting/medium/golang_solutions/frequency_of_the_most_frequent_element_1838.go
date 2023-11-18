package golang_solutions

import (
	"math"
	"sort"
)

func maxFrequency(nums []int, k int) int {
	sort.Ints(nums)
	left, right, currentSum, maxFreq := 0, 0, 0, 0

	for right < len(nums) {
		currentSum += nums[right]

		for currentSum+k < nums[right]*(right-left+1) {
			currentSum -= nums[left]
			left++
		}
		maxFreq = int(math.Max(float64(maxFreq), float64(right-left+1)))
		right++
	}
	return maxFreq
}

func maxFrequencyBruteForce(nums []int, k int) int {
	// only increment at most k times
	sort.Ints(nums)
	incr := len(nums)
	for incr > 0 {
		for i := 0; i+incr <= len(nums); i++ {
			tempK := k
			temp := nums[i : i+incr]
			for j := range temp {
				if j < len(temp)-1 {
					tempK -= temp[len(temp)-1] - temp[j]
				}
			}
			if tempK >= 0 {
				return len(temp)
			}
		}
		incr--
	}
	return -1
}
