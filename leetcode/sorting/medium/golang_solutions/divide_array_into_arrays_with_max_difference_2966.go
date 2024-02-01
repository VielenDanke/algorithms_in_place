package golang_solutions

import (
	"math"
	"sort"
)

//  Sort

func divideArray(nums []int, k int) [][]int {
	sort.Ints(nums)

	result := make([][]int, 0)

	for i := 0; i+3 <= len(nums); i += 3 {
		if nums[i+2]-nums[i] > k {
			return [][]int{}
		}
		result = append(result, nums[i:i+3])
	}
	return result
}

// -------------------------------------------------------------------------------------------

// Counting Sort

func divideArrayCountingSort(nums []int, k int) [][]int {
	freq := make([]int, 100001)
	maxNum, minNum := 0, math.MaxInt

	for _, num := range nums {
		freq[num]++
		maxNum = max(num, maxNum)
		minNum = min(num, minNum)
	}
	result := make([][]int, 0)
	temp := make([]int, 3)
	idx := 0

	for currentNum := minNum; currentNum <= maxNum; currentNum++ {
		for freq[currentNum] > 0 {
			temp[idx] = currentNum
			if idx == 2 {
				if temp[2]-temp[0] > k {
					return [][]int{}
				}
				toAppend := make([]int, 3)
				copy(toAppend, temp)
				result = append(result, toAppend)
				idx = 0
			} else {
				idx++
			}
			freq[currentNum]--
		}
	}
	return result
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}
