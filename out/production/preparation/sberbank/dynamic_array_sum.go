package sberbank

import "math"

func DynamicArraySum(arr []int, w int) bool {
	_, maxIdx := calculateSumWithMaxIdx(arr)

	retryCount := arr[maxIdx]

	return recursiveCount(arr, maxIdx, w, retryCount, 0)
}

func recursiveCount(arr []int, maxIdx, w, retryCount, alreadyUsed int) bool {
	if retryCount < alreadyUsed {
		sum, _ := calculateSumWithMaxIdx(arr)
		return sum <= w
	}
	arr[maxIdx] = int(math.Floor(float64(arr[maxIdx]) / 2))
	_, idx := calculateSumWithMaxIdx(arr)
	return recursiveCount(arr, idx, w, arr[idx], alreadyUsed+1)
}

func calculateSumWithMaxIdx(arr []int) (sum int, maxIdx int) {
	for idx, v := range arr {
		sum += v
		if v > arr[maxIdx] {
			maxIdx = idx
		}
	}
	return
}
