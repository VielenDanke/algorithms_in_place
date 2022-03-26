package medium

func ThreeNumberSort(array []int, order []int) []int {
	// Write your code here.
	// iterate over an order array
	// take first element and sort elements in first array according order of first
	counter := 0
	for i := 0; i < len(order); i++ {
		for j := counter; j < len(array); j++ {
			if order[i] != array[j] {
				for k := len(array) - 1; k >= j; k-- {
					if order[i] == array[k] {
						counter++
						array[j], array[k] = array[k], array[j]
						break
					}
				}
			} else {
				counter++
			}
		}
	}
	return array
}
