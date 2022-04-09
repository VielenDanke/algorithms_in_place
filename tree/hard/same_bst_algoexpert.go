package hard

func SameBsts(arrayOne, arrayTwo []int) bool {
	if len(arrayOne) == 0 && len(arrayTwo) == 0 {
		return true
	}
	if len(arrayOne) != len(arrayTwo) || arrayOne[0] != arrayTwo[0] {
		return false
	}
	leftOne := getSmaller(arrayOne)
	leftTwo := getSmaller(arrayTwo)
	rightOne := getBiggerOrEqual(arrayOne)
	rightTwo := getBiggerOrEqual(arrayTwo)
	return SameBsts(leftOne, leftTwo) && SameBsts(rightOne, rightTwo)
}

func getSmaller(array []int) []int {
	smaller := make([]int, 0)
	for i := 1; i < len(array); i++ {
		if array[i] < array[0] {
			smaller = append(smaller, array[i])
		}
	}
	return smaller
}

func getBiggerOrEqual(array []int) []int {
	biggerOrEqual := make([]int, 0)
	for i := 1; i < len(array); i++ {
		if array[i] >= array[0] {
			biggerOrEqual = append(biggerOrEqual, array[i])
		}
	}
	return biggerOrEqual
}
