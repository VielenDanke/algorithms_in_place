package main

import "sort"

func TwoNumberSum(array []int, target int) []int {
	arr := make([]int, 0)
	for i := 0; i < len(array); i++ {
		for j := i; j < len(array); j++ {
			if target == array[i]+array[j] {
				arr = append(arr, array[i], array[j])
			}
		}
	}
	return arr
}

func TwoNumberSum2(array []int, target int) []int {
	arr := make([]int, 0)
	m := make(map[int]interface{})
	// iterating over an array
	for i := 0; i < len(array); i++ {
		// find the mirror num, ex: target = 10 array[i] = 3 mirrorNum = 10 - 3 = 7
		mirrorNum := target - array[i]
		if _, ok := m[mirrorNum]; ok {
			arr = append(arr, array[i], mirrorNum)
		} else {
			// add array[i] to match pair if 10 - 7 == 3 and 3 would be inside the map
			m[array[i]] = nil
		}
	}
	return arr
}

func TwoNumberSum3(array []int, target int) []int {
	sort.Ints(array)
	leftP := 0
	rightP := len(array) - 1
	result := make([]int, 0)

	for leftP < rightP {
		sum := array[leftP] + array[rightP]
		if sum > target {
			rightP--
		} else if sum < target {
			leftP++
		} else {
			result = append(result, array[leftP], array[rightP])
			leftP++
			rightP--
		}
	}
	return result
}
