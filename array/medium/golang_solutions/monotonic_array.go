package golang_solutions

// Time O(N), Space O(1)

func IsMonotonic(array []int) bool {
	// Write your code here.
	if len(array) == 0 {
		return true
	} else if len(array) == 1 {
		return true
	}
	isIncrease := false

	if array[0] < array[len(array)-1] {
		isIncrease = true
	}
	for i := 0; i+1 < len(array); i++ {
		if isIncrease {
			if array[i] > array[i+1] {
				return false
			}
		} else {
			if array[i] < array[i+1] {
				return false
			}
		}
	}
	return true
}
