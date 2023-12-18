package golang_solutions

import "sort"

// iterative

func maxProductDifference(nums []int) int {
	n1, n2, m1, m2 := 1<<30, 1<<30, -1<<30, -1<<30

	for _, v := range nums {
		if n1 > v {
			n2 = n1
			n1 = v
		} else if n2 > v {
			n2 = v
		}
		if m1 < v {
			m2 = m1
			m1 = v
		} else if m2 < v {
			m2 = v
		}
	}
	return m2*m1 - n2*n1
}

// sort

func maxProductDifferenceSorting(nums []int) int {
	sort.Ints(nums)
	n := len(nums)
	return nums[n-1]*nums[n-2] - nums[0]*nums[1]
}
