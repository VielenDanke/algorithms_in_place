package golang_solutions

func LongestPeak(array []int) int {
	// Write your code here.
	max := 0
	for i := 1; i+1 < len(array); i++ {
		if isPeak(array, i) {
			left := i - 1
			right := i + 1
			for left >= 1 && array[left] > array[left-1] {
				left--
			}
			for right < len(array)-1 && array[right] > array[right+1] {
				right++
			}
			if right-left+1 > max {
				max = right - left + 1
			}
			i = right
		}
	}
	return max
}

func isPeak(array []int, idx int) bool {
	return array[idx-1] < array[idx] && array[idx] > array[idx+1]
}
