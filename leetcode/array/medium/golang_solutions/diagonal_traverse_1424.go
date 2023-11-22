package golang_solutions

import "math"

func findDiagonalOrder(nums [][]int) []int {
	// start from 0, 0
	// increment row until end
	// then increment col until end
	// every step traverse as row - 1, col + 1
	// check every traverse operation for index out of bound
	temp := make([][]int, 0)
	n, size := len(nums), 0

	for i := 0; i < n; i++ {
		m := len(nums[i])
		for j := 0; j < m; j++ {
			idx := i + j
			if len(temp) < idx+1 {
				temp = append(temp, make([]int, 0))
			}
			temp[idx] = append(temp[idx], nums[i][j])
			size++
		}
	}
	result := make([]int, size)
	idx := 0

	for i := 0; i < len(temp); i++ {
		for j := len(temp[i]) - 1; j >= 0; j-- {
			result[idx] = temp[i][j]
			idx++
		}
	}
	return result
}

// ------------------------------------------------------------------------------------------

func findDiagonalOrderBruteForce(nums [][]int) []int {
	// start from 0, 0
	// increment row until end
	// then increment col until end
	// every step traverse as row - 1, col + 1
	// check every traverse operation for index out of bound
	m := 0
	for _, row := range nums {
		m = int(math.Max(float64(len(row)), float64(m)))
	}
	result := make([]int, 0)
	for i := 0; i < len(nums); i++ {
		traverseAndAppend(&result, nums, i, 0, m)
	}
	for i := 1; i < m; i++ {
		traverseAndAppend(&result, nums, len(nums)-1, i, m)
	}
	return result
}

func traverseAndAppend(result *[]int, nums [][]int, row, col, m int) {
	for row >= 0 && col < m {
		if col < len(nums[row]) {
			*result = append(*result, nums[row][col])
		}
		row--
		col++
	}
}
