package dynamic_programming

import "fmt"

func minimumTotalTabulation(triangle [][]int) (minSum int) {
	return
}

func minimumTotalMemoization(triangle [][]int) (minSum int) {
	return findMinSum(triangle, 0, 0, 0, make(map[string]int))
}

func findMinSum(triangle [][]int, row, idx, currentSum int, memo map[string]int) int {
	if val, ok := memo[createMinSumKey(row, idx)]; ok {
		return val
	}
	if row >= len(triangle) {
		return currentSum
	}
	sum := minSum(findMinSum(triangle, row+1, idx, currentSum, memo), findMinSum(triangle, row+1, idx+1, currentSum, memo))
	memo[createMinSumKey(row, idx)] = sum + triangle[row][idx]
	return sum + triangle[row][idx]
}

func minSum(f, s int) int {
	if f > s {
		return s
	}
	return f
}

func createMinSumKey(row, column int) string {
	return fmt.Sprintf("%d-%d", row, column)
}
