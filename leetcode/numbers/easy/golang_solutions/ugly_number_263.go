package golang_solutions

func isUgly(n int) bool {
	for i := 2; i < 6 && n > 0; i++ {
		for n%i == 0 {
			n /= i
		}
	}
	return n == 1
}
