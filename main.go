package main

import (
	"fmt"
)

func SpiralTraverse(array [][]int) []int {
	// Write your code here.
	result := make([]int, 0)
	runThrough(array, &result)
	return result
}

func runThrough(array [][]int, result *[]int) {
	if len(array) == 1 {
		for _, v := range array[0] {
			*result = append(*result, v)
		}
		return
	}
	if len(array) == 0 {
		return
	}
	for i := 0; i < len(array[0]); i++ {
		*result = append(*result, array[0][i])
	}
	array = array[1:]
	for i, j := 0, len(array[0])-1; i < len(array); i++ {
		*result = append(*result, array[i][j])
		array[i] = array[i][:j]
	}
	for i, j := len(array)-1, len(array[0])-1; j >= 0; j-- {
		*result = append(*result, array[i][j])
	}
	array = array[:len(array)-1]
	for i, j := len(array)-1, 0; i >= 0; i-- {
		*result = append(*result, array[i][j])
		array[i] = array[i][j+1:]
	}
	runThrough(array, result)
}

func main() {
	board := [][]int{{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}}
	fmt.Printf("Result: %v\n", board)
}
