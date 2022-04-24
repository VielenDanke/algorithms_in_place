package golang_solutions

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
	result := make([][]int, 0)

	for i := 0; i < len(array)-2; i++ {
		left, right := i+1, len(array)-1
		for left < right {
			currentSum := array[i] + array[left] + array[right]
			if currentSum == target {
				result = append(result, []int{array[i], array[left], array[right]})
				left++
				right--
			} else if currentSum < target {
				left++
			} else {
				right--
			}
		}
	}
	return result
}
