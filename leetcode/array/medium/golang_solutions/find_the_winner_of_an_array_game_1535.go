package golang_solutions

import "math"

func getWinner(arr []int, k int) int {
	// k consecutive games
	// arr[0] and arr[1] are gaming
	// counter per number to check what games it win
	if k > len(arr) {
		maxVal := arr[0]
		for _, v := range arr {
			maxVal = int(math.Max(float64(maxVal), float64(v)))
		}
		return maxVal
	}
	if k == 1 {
		return int(math.Max(float64(arr[0]), float64(arr[1])))
	}
	currentWinner, consecutiveWins := arr[0], 0

	for i := 1; i < len(arr); i++ {
		if currentWinner > arr[i] {
			consecutiveWins++
		} else {
			currentWinner = arr[i]
			consecutiveWins = 1
		}
		if consecutiveWins == k {
			return currentWinner
		}
	}
	return currentWinner
}

func getWinnerBruteForce(arr []int, k int) int {
	// k consecutive games
	// arr[0] and arr[1] are gaming
	// counter per number to check what games it win
	if k > len(arr) {
		maxVal := arr[0]
		for _, v := range arr {
			maxVal = int(math.Max(float64(maxVal), float64(v)))
		}
		return maxVal
	}
	if k == 1 {
		return int(math.Max(float64(arr[0]), float64(arr[1])))
	}
	lastWinner, consecutiveWins := -1, 1

	for consecutiveWins < k {
		if arr[0] > arr[1] {
			if lastWinner == arr[0] {
				consecutiveWins++
			} else {
				lastWinner = arr[0]
				consecutiveWins = 1
			}
			temp := arr[1]
			arr = append(arr[:1], arr[2:]...)
			arr = append(arr, temp)
		} else {
			if lastWinner == arr[1] {
				consecutiveWins++
			} else {
				lastWinner = arr[1]
				consecutiveWins = 1
			}
			temp := arr[0]
			arr = arr[1:]
			arr = append(arr, temp)
		}
	}
	return lastWinner
}
