package medium

import "sort"

// O(N*logN + M*logM) Time, O(1) Space

func SmallestDifference1(array1, array2 []int) []int {
	sort.Ints(array1)
	sort.Ints(array2)

	f, s, min := 0, 0, 1<<31
	var fIdx, sIdx int

	for f < len(array1) && s < len(array2) {
		if min > abs(array1[f], array2[s]) {
			min = abs(array1[f], array2[s])
			fIdx = f
			sIdx = s
		}
		if array1[f] > array2[s] {
			s++
		} else if array1[f] < array2[s] {
			f++
		} else {
			return []int{array1[f], array2[s]}
		}
	}
	return []int{array1[fIdx], array2[sIdx]}
}

// O(N * M) Time, O(1) Space

func SmallestDifference2(array1, array2 []int) []int {
	firstMin := 0
	secondMin := 0
	min := 1 << 31
	for i := 0; i < len(array1); i++ {
		for j := 0; j < len(array2); j++ {
			tempMin := abs(array1[i], array2[j])
			if tempMin < min {
				min = tempMin
				firstMin = array1[i]
				secondMin = array2[j]
			}
		}
	}
	return []int{firstMin, secondMin}
}

func abs(f, s int) int {
	if f > s {
		return f - s
	}
	return s - f
}
