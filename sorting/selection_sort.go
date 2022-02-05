package sorting

func SelectionSort(array []int) []int {
	// Write your code here.
	// take the length of array
	// iterate over an array
	// take the index i in iteration as the first
	// iterate over an array with j and find the minIdx
	// swap i and minIdx
	n := len(array)
	for i := 0; i < n; i++ {
		minIdx := i
		for j := i; j < n; j++ {
			if array[j] < array[minIdx] {
				minIdx = j
			}
		}
		array[i], array[minIdx] = array[minIdx], array[i]
	}
	return array
}
