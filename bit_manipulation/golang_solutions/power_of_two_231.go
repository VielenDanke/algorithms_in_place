package golang_solutions

func isPowerOfTwo(n int) bool {
	pow := 0
	num := 0
	for num < n {
		num = 1 << pow
		if num == n {
			return true
		}
		pow++
	}
	return false
}

func isPowerOfTwoBetter(n int) bool {
	return n != 0 && n&(n-1) == 0
}
