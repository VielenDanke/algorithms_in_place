package main

import "sort"

func powerArrayOfTwo(array []int) {
	for k, v := range array {
		array[k] = v * v
	}
}

func SortedSquaredArray(array []int) []int {
	// Write your code here.
	firstNum := array[0]
	powerArrayOfTwo(array)
	if firstNum < 0 {
		sort.Ints(array)
	}
	return array
}

func SortedSquaredArray2(array []int) []int {
	// Write your code here.
	start := 0
	end := len(array) - 1
	output := make([]int, len(array))
	for i := len(output) - 1; i >= 0; i-- {
		startNum := array[start] * array[start]
		endNum := array[end] * array[end]
		if startNum > endNum {
			output[i] = startNum
			start++
		} else {
			output[i] = endNum
			end--
		}
	}
	return output
}
