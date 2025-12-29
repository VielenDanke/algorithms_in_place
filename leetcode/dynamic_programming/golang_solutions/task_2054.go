package golang_solutions

import (
	"sort"
)

func maxTwoEvents(events [][]int) int {
	sort.Slice(events, func(i, j int) bool {
		return events[i][0] < events[j][0]
	})

	memo := make([][]int, len(events))
	for i := range memo {
		memo[i] = []int{-1, -1, -1}
	}

	return dfs(events, 0, 0, memo)
}

func dfs(events [][]int, idx int, count int, memo [][]int) int {
	if count == 2 || idx >= len(events) {
		return 0
	}

	if memo[idx][count] != -1 {
		return memo[idx][count]
	}

	maxVal := dfs(events, idx+1, count, memo)

	targetStart := events[idx][1] + 1
	nextIdx := sort.Search(len(events), func(i int) bool {
		return events[i][0] >= targetStart
	})

	pickedVal := events[idx][2] + dfs(events, nextIdx, count+1, memo)

	if pickedVal > maxVal {
		maxVal = pickedVal
	}

	memo[idx][count] = maxVal
	return maxVal
}
