package sorting

import (
	"math/rand"
	"time"
)

func QuickSort(arr []int) {
	quickSort(arr, 0, len(arr)-1)
}

func quickSort(arr []int, low, high int) {
	if low < high {
		pivotIndex := randomPivot(low, high)
		pivot := partition(arr, low, high, pivotIndex)
		quickSort(arr, low, pivot-1)
		quickSort(arr, pivot+1, high)
	}
}

func partition(arr []int, low, high, pivotIndex int) int {
	pivot := arr[pivotIndex]
	arr[high], arr[pivotIndex] = arr[pivotIndex], arr[high]
	i := low - 1

	for j := low; j < high; j++ {
		if arr[j] <= pivot {
			i++
			arr[i], arr[j] = arr[j], arr[i]
		}
	}
	i++
	arr[i], arr[high] = arr[high], arr[i]
	return i
}

func randomPivot(low, high int) int {
	rand.Seed(time.Now().UnixNano())
	return rand.Intn(high-low+1) + low
}
