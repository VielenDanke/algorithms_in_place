package golang_solutions

import "math"

var maxNum int32
var temp []int32

func nonDivisibleSubsetSolution(k int32, s []int32) int32 {
	var result int32

	storage := make(map[int32]int32)

	for _, v := range s {
		storage[v%k]++
	}
	if val := storage[0]; val > 0 {
		result++
	}
	for i := int32(1); i < k; i++ {
		if storage[i] == 0 {
			continue
		}
		if i+i == k {
			result++
		} else {
			result += int32(math.Max(float64(storage[i]), float64(storage[k-i])))
			storage[i] = 0
			storage[k-i] = 0
		}
	}
	return result
}

// ----------------------------------------------------------------------

func nonDivisibleSubset(k int32, s []int32) int32 {
	// Write your code here
	temp = make([]int32, 0)
	backtrack(s, 0, k)
	return maxNum
}

func backtrack(s []int32, start int, k int32) {
	n := len(temp)
	if isNonDivisibleSubset(k) && maxNum < int32(n) {
		maxNum = int32(n)
	}
	for i := start; i < n; i++ {
		temp = append(temp, s[i])
		backtrack(s, i+1, k)
		temp = temp[:len(temp)-1]
	}
}

func isNonDivisibleSubset(k int32) bool {
	n := len(temp)
	for i := 0; i < n; i++ {
		for j := i + 1; j < n; j++ {
			if (temp[i]+temp[j])%k == 0 {
				return false
			}
		}
	}
	return true
}
