package golang_solutions

func MoveElementToEnd(array []int, toMove int) []int {
	// Write your code here.
	for j := len(array) - 1; j >= 0; j-- {
		if array[j] != toMove {
			for i := 0; i < j; i++ {
				if array[i] == toMove {
					array[i], array[j] = array[j], array[i]
					break
				}
			}
		}
	}
	return array
}

func MoveElementToEnd2(array []int, toMove int) []int {
	// Write your code here.
	i, j := 0, len(array)-1

	for i < j {
		for i < j && array[j] == toMove {
			j--
		}
		if array[i] == toMove {
			array[j], array[i] = array[i], array[j]
		}
		i++
	}
	return array
}
