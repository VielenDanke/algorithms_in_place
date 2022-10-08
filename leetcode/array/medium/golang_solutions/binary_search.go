package golang_solutions

func BinarySearch(array []int, target int) (result int) {
	// Write your code here.
	start, end := 0, len(array)-1
	for start <= end {
		idx := (end + start) / 2
		middle := array[idx]
		if middle > target {
			end = idx - 1
		} else if middle < target {
			start = idx + 1
		} else {
			return idx
		}
	}
	return -1
}
