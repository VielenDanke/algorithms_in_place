package main

func MaxSubsetSumNoAdjacent(array []int) int {
	// Write your code here.
	arrLen := len(array)
	if arrLen == 0 {
		return 0
	} else if len(array) == 1 {
		return array[0]
	}
	maxSums := make([]int, len(array))
	maxSums[0], maxSums[1] = array[0], max(array[0], array[1])
	for i := 2; i < len(array); i++ {
		maxSums[i] = max(maxSums[i-1], maxSums[i-2]+array[i])
	}
	return maxSums[len(array)-1]
}

func max(f, s int) int {
	if f > s {
		return f
	}
	return s
}
