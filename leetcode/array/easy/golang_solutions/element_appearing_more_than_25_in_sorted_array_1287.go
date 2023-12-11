package golang_solutions

// counter

func findSpecialInteger(arr []int) int {
	occurrences, counter, number := len(arr)/4, 0, arr[0]

	for _, v := range arr {
		if v == number {
			counter++
		} else {
			counter = 1
			number = v
		}
		if counter > occurrences {
			return number
		}
	}
	return -1
}

// map

func findSpecialIntegerBruteForce(arr []int) int {
	occurrences := len(arr) / 4

	counter := make(map[int]int)

	for _, v := range arr {
		counter[v]++
		if counter[v] > occurrences {
			return v
		}
	}
	return -1
}
