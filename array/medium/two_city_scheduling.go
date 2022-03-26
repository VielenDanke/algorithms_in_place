package medium

import "sort"

func TwoCitySchedCost(costs [][]int) int {
	// length of array == 4 people
	// send 2 "a" to aCost and 2 b to bCost
	// iterate over array
	return calculateMin(costs, 0, 0, 0)
}

func TwoCitySchedCostFaster(costs [][]int) (result int) {
	sort.Slice(costs, func(i, j int) bool {
		return (costs[i][0] - costs[i][1]) < (costs[j][0] - costs[j][1])
	})
	for i := 0; i < len(costs)/2; i++ {
		result += costs[i][0]
	}
	for i := len(costs) / 2; i < len(costs); i++ {
		result += costs[i][1]
	}
	return
}

func calculateMin(costs [][]int, currentIdx, aDest, bDest int) int {
	if currentIdx >= len(costs) {
		return 0
	}
	left, right := 1<<31, 1<<31
	if aDest != len(costs)/2 {
		left = costs[currentIdx][0] + calculateMin(costs, currentIdx+1, aDest+1, bDest)
	}
	if bDest != len(costs)/2 {
		right = costs[currentIdx][1] + calculateMin(costs, currentIdx+1, aDest, bDest+1)
	}
	if left < right {
		return left
	}
	return right
}
