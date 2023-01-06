package golang_solutions

import (
	"fmt"
)

// https://www.hackerrank.com/challenges/almost-sorted/problem

func almostSorted(arr []int32) {
	// Write your code here
	// only two operations are available - swap or reverse segment (i..j)
	// only one operation is allowed
	if arr == nil || len(arr) <= 1 {
		fmt.Println("YES")
	}
	mostLeftIdx, mostRightIdx := findMostLeftAndRightIdx(arr)
	if mostLeftIdx < 0 && mostRightIdx < 0 {
		fmt.Println("yes")
	} else {
		arr[mostLeftIdx], arr[mostRightIdx] = arr[mostRightIdx], arr[mostLeftIdx]
		if isSorted(arr) {
			fmt.Println("yes")
			fmt.Printf("swap %d %d", mostLeftIdx+1, mostRightIdx+1)
			return
		} else {
			arr[mostLeftIdx], arr[mostRightIdx] = arr[mostRightIdx], arr[mostLeftIdx]
			left, right := mostLeftIdx, mostRightIdx
			for left < right {
				arr[left], arr[right] = arr[right], arr[left]
				left++
				right--
			}
			if isSorted(arr) {
				fmt.Println("yes")
				fmt.Printf("reverse %d %d", mostLeftIdx+1, mostRightIdx+1)
				return
			}
		}
	}
	fmt.Println("no")
}

func findMostLeftAndRightIdx(arr []int32) (int, int) {
	mostLeftIdx, mostRightIdx := -1<<30, -1<<30
	n := len(arr)
	for i := 0; i < n; i++ {
		if (i > 0 && arr[i] < arr[i-1]) || (i < n-1 && arr[i] > arr[i+1]) {
			if mostLeftIdx == -1<<30 {
				mostLeftIdx = i
			} else {
				mostRightIdx = i
			}
		}
	}
	return mostLeftIdx, mostRightIdx
}

func isSorted(arr []int32) bool {
	n := len(arr)
	for i := 1; i < n; i++ {
		if arr[i] < arr[i-1] {
			return false
		}
	}
	return true
}
