package golang_solutions

import "math"

func minSubarray(nums []int, p int) int {
	n := len(nums)
	sum := 0

	for _, num := range nums {
		sum += num
	}
	need := sum % p

	if need == 0 {
		return 0
	}
	storage := map[int]int{0: -1}
	prefix := 0
	result := n

	for i, num := range nums {
		prefix = (prefix + num) % p
		target := (prefix - need + p) % p
		if idx, ok := storage[target]; ok {
			result = int(math.Min(float64(result), float64(i-idx)))
		}
		storage[prefix] = i
	}
	if result == n {
		return -1
	}
	return result
}

func minSubarrayBruteForce(nums []int, p int) int {
	window := 1
	n := len(nums)
	sum := 0

	for _, num := range nums {
		sum += num
	}

	if sum%p == 0 {
		return 0
	}

	for window < n {
		for i := 0; i+window <= n; i++ {
			slice := nums[i : i+window]
			tempSum := 0

			for _, num := range slice {
				tempSum += num
			}
			if (sum-tempSum)%p == 0 {
				return window
			}
		}

		window++
	}
	return -1
}
