package hard

import "math"

// binary search

func findMedianSortedArrays(nums1 []int, nums2 []int) float64 {
	n1, n2 := len(nums1), len(nums2)

	if n1 > n2 {
		return findMedianSortedArrays(nums2, nums1)
	}
	n := n1 + n2
	// left partition
	left, low, high := (n1+n2+1)/2, 0, n1

	for low <= high {
		mid1 := (low + high) >> 1 // low + (high - low) / 2
		mid2 := left - mid1

		l1, l2, r1, r2 := -1<<30, -1<<30, 1<<30, 1<<30

		if mid1 < n1 {
			r1 = nums1[mid1]
		}
		if mid2 < n2 {
			r2 = nums2[mid2]
		}
		if mid1-1 >= 0 {
			l1 = nums1[mid1-1]
		}
		if mid2-1 >= 0 {
			l2 = nums2[mid2-1]
		}
		if l1 <= r2 && l2 <= r1 {
			if n%2 == 1 {
				return math.Max(float64(l1), float64(l2))
			}
			return (math.Max(float64(l1), float64(l2)) + math.Min(float64(r1), float64(r2))) / 2
		} else if l1 > r2 {
			high = mid1 - 1
		} else {
			low = mid1 + 1
		}
	}
	return 0
}

// merge sort solution

func findMedianSortedArraysMergeSort(nums1 []int, nums2 []int) float64 {
	left, right := 0, 0

	result := make([]int, 0)

	for left < len(nums1) && right < len(nums2) {
		if nums1[left] < nums2[right] {
			result = append(result, nums1[left])
			left++
		} else {
			result = append(result, nums2[right])
			right++
		}
	}
	for left < len(nums1) {
		result = append(result, nums1[left])
		left++
	}
	for right < len(nums2) {
		result = append(result, nums2[right])
		right++
	}
	if len(result) == 1 {
		return float64(result[0])
	}
	if len(result)%2 != 0 {
		return float64(result[len(result)/2])
	}
	return (float64(result[len(result)/2-1]) + float64(result[len(result)/2])) / 2
}
