package golang_solutions

func FindThreeLargestNumbers(array []int) []int {
	// Write your code here.
	// loop through an array - find max value
	// swap it with min value
	// add to result array
	// repeat 3 times operation
	result := make([]int, 3)
	for i := 2; i >= 0; i-- {
		currentIdx := 0
		for idx, v := range array {
			if array[currentIdx] < v {
				currentIdx = idx
			}
		}
		result[i] = array[currentIdx]
		array[currentIdx] = -1 << 31
	}
	return result
}
