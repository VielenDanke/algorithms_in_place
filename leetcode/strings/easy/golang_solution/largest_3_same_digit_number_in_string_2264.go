package golang_solution

// iteration with 3 indices

func largestGoodIntegerIteration(num string) string {
	var theLargestNumber string
	for i := 0; i < len(num); i++ {
		if (i > 0 && i < len(num)-1) && (num[i-1] == num[i] && num[i] == num[i+1]) {
			theLargestNumber = pickTheBiggestNumber(theLargestNumber, num[i-1:i+2])
		}
	}
	return theLargestNumber
}

// arr

func largestGoodIntegerArray(num string) string {
	arr := make([]int, 100)

	for i := 0; i < 3; i++ {
		arr[num[i]]++
	}
	var theLargestNumber string
	if checkIfUniqueRow(arr) {
		theLargestNumber = num[0:3]
	}
	for i := 3; i < len(num); i++ {
		if checkIfUniqueRow(arr) {
			theLargestNumber = pickTheBiggestNumber(theLargestNumber, num[i-3:i])
		}
		arr[num[i]]++
		arr[num[i-3]]--

		if arr[num[i-3]] <= 0 {
			arr[num[i-3]] = 0
		}
	}
	if checkIfUniqueRow(arr) {
		return pickTheBiggestNumber(theLargestNumber, num[len(num)-3:])
	}
	return theLargestNumber
}

func checkIfUniqueRow(arr []int) bool {
	counter := 0
	for _, v := range arr {
		if v > 0 {
			counter++
			if counter > 1 {
				return false
			}
		}
	}
	return true
}

// map

func largestGoodInteger(num string) string {
	m := make(map[byte]int)

	for i := 0; i < 3; i++ {
		m[num[i]]++
	}
	var theLargestNumber string
	if len(m) == 1 {
		theLargestNumber = num[0:3]
	}
	for i := 3; i < len(num); i++ {
		if len(m) == 1 {
			theLargestNumber = pickTheBiggestNumber(theLargestNumber, num[i-3:i])
		}
		m[num[i]]++
		m[num[i-3]]--

		if m[num[i-3]] <= 0 {
			delete(m, num[i-3])
		}
	}
	if len(m) == 1 {
		return pickTheBiggestNumber(theLargestNumber, num[len(num)-3:])
	}
	return theLargestNumber
}

func pickTheBiggestNumber(prev, current string) string {
	if prev == "" {
		return current
	}
	if current[0] > prev[0] {
		return current
	}
	return prev
}
