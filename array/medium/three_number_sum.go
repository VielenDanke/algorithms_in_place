package medium

import "sort"

func ThreeNumberSum(array []int, target int) [][]int {
	// Write your code here.
	result := make([][]int, 0)
	for i := 0; i < len(array); i++ {
		for j := i + 1; j < len(array); j++ {
			for x := j + 1; x < len(array); x++ {
				if array[i]+array[j]+array[x] == target {
					result = append(result, []int{array[i], array[j], array[x]})
				}
			}
		}
	}
	return result
}

func ThreeNumberSum2(array []int, target int) [][]int {
	sort.Ints(array)
	start, end := 0, len(array)-1
	result := make([][]int, 0)

	for start < end {
		tempMax := -1 << 31
		tempSum := array[start] + array[end]
		for _, v := range array {
			if v+tempSum > tempMax {
				tempMax = v + tempSum
			}
			if v+tempSum == target {
				result = append(result, []int{v, array[start], array[end]})
			}
		}
		if tempMax > target {
			end--
		} else {
			start++
		}
	}
	return result
}
