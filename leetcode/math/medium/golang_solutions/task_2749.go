package golang_solutions

func makeTheIntegerZero(num1 int, num2 int) int {
	k := int64(1)
	num1i64 := int64(num1)
	num2i64 := int64(num2)

	for {
		x := num1i64 - num2i64*k
		if x < k {
			return -1
		}
		if k >= bitCount(x) {
			return int(k)
		}
		k++
	}
}

func bitCount(n int64) int64 {
	count := int64(0)

	for n != 0 {
		count++
		n &= n - 1
	}
	return count
}
