package golang_solutions

import "math"

// https://www.hackerrank.com/challenges/minimum-distances/problem

func minimumDistancesMap(a []int32) int32 {
	// Write your code here
	m := make(map[int32]int)
	min := int32(1 << 30)

	for idx, v := range a {
		if prevIdx, ok := m[v]; ok {
			min = int32(math.Min(float64(min), math.Abs(float64(idx)-float64(prevIdx))))
		}
		m[v] = idx
	}
	return validateAnswer(min)
}

func minimumDistances(a []int32) int32 {
	// Write your code here
	n := len(a)
	min := int32(1 << 30)
	for i := 0; i < n; i++ {
		for j := i + 1; j < n; j++ {
			if a[i] == a[j] {
				min = int32(math.Min(float64(min), math.Abs(float64(i)-float64(j))))
			}
		}
	}
	return validateAnswer(min)
}

func validateAnswer(ans int32) int32 {
	if ans == 1<<30 {
		return -1
	}
	return ans
}
