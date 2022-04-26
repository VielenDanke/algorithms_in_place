package golang_solutions

import "math"

func isPowerOfThree(n int) bool {
	if n < 1 {
		return false
	}
	for n > 1 {
		if n%3 != 0 {
			return false
		}
		n /= 3
	}
	return true
}

func isPowerOfThreeMax(n int) bool {
	return n > 0 && int(math.Pow(float64(3), float64(19)))%n == 0
}
