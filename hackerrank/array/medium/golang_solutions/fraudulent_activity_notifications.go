package golang_solutions

import (
	"math"
	"math/rand"
	"sort"
)

func activityNotificationsBruteForce(expenditure []int32, d int32) (notice int32) {
	// Write your code here
	for i := int32(0); i+d <= int32(len(expenditure)); i++ {
		sub := expenditure[i:(i + d)]
		sort.Slice(sub, func(i, j int) bool {
			return sub[i] < sub[j]
		})
		var num int32
		if d%2 != 0 {
			num = int32(sub[len(sub)/2]) * 2
		} else {
			num = int32(math.Ceil(float64(sub[len(sub)/2]+sub[len(sub)/2-1])/2.0)) * 2
		}
		if i+d < int32(len(expenditure)) && expenditure[i+d] >= num {
			notice++
		}
	}
	return
}

// -------------------------------------------------------------------------------------------------------------------

// complexity O(N * D) where N - length of an array, D - length of subarray
func activityNotificationsArr(expenditure []int32, d int32) (notice int32) {
	// limit to 200 since it is expected maximum
	arr := make([]int32, 200)

	for i := int32(0); i < d; i++ {
		arr[expenditure[i]]++
	}

	for i := d; i < int32(len(expenditure)); i++ {
		currentExp := expenditure[i]
		if isNoticeNeededArr(currentExp, arr, d) {
			notice++
		}
		prevExp := expenditure[i-d]
		arr[prevExp]--
		if arr[prevExp] < 0 {
			arr[prevExp] = 0
		}
		arr[currentExp]++
	}
	return
}

func isNoticeNeededArr(next int32, arr []int32, d int32) bool {
	sub := make([]int32, 0)
toBreak:
	for i := 0; i < 200; i++ {
		current := arr[i]
		if current > 0 {
			for j := int32(0); j < arr[i]; j++ {
				sub = append(sub, int32(i))
				if int32(len(sub)) == d {
					break toBreak
				}
			}
		}
		if int32(len(sub)) == d {
			break
		}
	}
	var num int32
	if d%2 != 0 {
		num = int32(sub[len(sub)/2]) * 2
	} else {
		num = int32(math.Ceil(float64(sub[len(sub)/2]+sub[len(sub)/2-1])/2.0)) * 2
	}
	return next >= num
}

// -------------------------------------------------------------------------------------------------------------------

func activityNotificationsQuickSelect(expenditure []int32, d int32) (notice int32) {
	// Write your code here
	for i := int32(0); i+d <= int32(len(expenditure)); i++ {
		median := int64(findMedian(expenditure[i:(i+d)])) * 2
		if i+d < int32(len(expenditure)) && int64(expenditure[i+d]) >= median {
			notice++
		}
	}
	return
}

func findMedian(arr []int32) float64 {
	n := len(arr)
	if n%2 == 1 {
		medianIndex := n / 2
		median := quickSelect(arr, 0, n-1, medianIndex)
		return float64(median)
	} else {
		medianIndex1 := n/2 - 1
		medianIndex2 := n / 2
		median1 := quickSelect(arr, 0, n-1, medianIndex1)
		median2 := quickSelect(arr, 0, n-1, medianIndex2)
		return math.Ceil(float64(median1+median2) / 2.0)
	}
}

func quickSelect(arr []int32, low, high, k int) int32 {
	if low == high {
		return arr[low]
	}

	pivotIndex := partition(arr, low, high)

	if k == pivotIndex {
		return arr[k]
	} else if k < pivotIndex {
		return quickSelect(arr, low, pivotIndex-1, k)
	} else {
		return quickSelect(arr, pivotIndex+1, high, k)
	}
}

func partition(arr []int32, low, high int) int {
	pivotIndex := rand.Intn(high-low+1) + low
	pivot := arr[pivotIndex]
	arr[pivotIndex], arr[high] = arr[high], arr[pivotIndex]

	i := low - 1

	for j := low; j < high; j++ {
		if arr[j] <= pivot {
			i++
			arr[i], arr[j] = arr[j], arr[i]
		}
	}

	arr[i+1], arr[high] = arr[high], arr[i+1]
	return i + 1
}

// ------------------------------------------------------------------------------------------------------------------

func activityNotificationsMap(expenditure []int32, d int32) (notice int32) {
	// Write your code here
	n := int32(len(expenditure))

	m := make(map[int32]int32)

	for i := int32(0); i < d; i++ {
		if _, ok := m[expenditure[i]]; !ok {
			m[expenditure[i]] = 0
		}
		m[expenditure[i]]++
	}
	for i := d; i < n-1; i++ {
		if isNoticeNeeded(expenditure[i], m, d) {
			notice++
		}
		m[expenditure[i-d]]--
		if m[expenditure[i-d]] <= 0 {
			delete(m, expenditure[i-d])
		}
		if _, ok := m[expenditure[i]]; !ok {
			m[expenditure[i]] = 0
		}
		m[expenditure[i]]++
	}
	return
}

func isNoticeNeeded(next int32, m map[int32]int32, d int32) bool {
	sub := make([]int32, 0)
	for k, v := range m {
		for j := int32(0); j < v; j++ {
			sub = append(sub, k)
		}
	}
	var num int32
	if d%2 != 0 {
		num = int32(sub[len(sub)/2]) * 2
	} else {
		num = int32(math.Ceil(float64(sub[len(sub)/2]+sub[len(sub)/2-1])/2.0)) * 2
	}
	return next >= num
}
