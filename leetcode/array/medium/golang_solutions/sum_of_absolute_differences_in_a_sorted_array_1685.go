package golang_solutions

import "math"

func getSumAbsoluteDifferencesTwoPointers(nums []int) []int {
	sum, n := 0, len(nums)

	for _, v := range nums {
		sum += v
	}
	left, right := 0, sum

	for i := 0; i < n; i++ {
		currentVal := nums[i]
		right -= currentVal
		nums[i] = currentVal*i - left + right - currentVal*(n-i-1)
		left += currentVal
	}
	return nums
}

func getSumAbsoluteDifferences(nums []int) []int {
	n := len(nums)
	prefixSum, suffixSum := make([]int, n), make([]int, n)

	prefixSum[0] = nums[0]
	suffixSum[n-1] = nums[n-1]

	for i := 1; i < n; i++ {
		prefixSum[i] = prefixSum[i-1] + nums[i]
		suffixSum[n-i-1] = suffixSum[n-i] + nums[n-i-1]
	}
	for i := 0; i < n; i++ {
		nums[i] = ((nums[i] * i) - prefixSum[i]) + (suffixSum[i] - (nums[i] * (n - i - 1)))
	}
	return nums
}

func getSumAbsoluteDifferencesBruteForce(nums []int) []int {
	result := make([]int, len(nums))
	visited := make(map[int]int)

	for i, v := range nums {
		if _, ok := visited[v]; ok {
			result[i] = visited[v]
			continue
		}
		for j, vv := range nums {
			if i != j {
				result[i] += int(math.Abs(float64(v - vv)))
			}
		}
		visited[v] = result[i]
	}
	return result
}
