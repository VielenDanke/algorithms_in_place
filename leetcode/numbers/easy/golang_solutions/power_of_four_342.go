package golang_solutions

func isPowerOfFour(n int) bool {
	for n > 1 {
		if n%4 != 0 {
			return false
		}
		n /= 4
	}
	return n == 1
}

func isPowerOfFourBinary(n int) bool {
	return n > 0 && (n&(n-1)) == 0 && (n&0x55555555) != 0
}
