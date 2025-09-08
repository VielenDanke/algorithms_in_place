package easy

func getNoZeroIntegers(n int) []int {
	containsZero := func(num int) bool {
		for num > 0 {
			if num%10 == 0 {
				return true
			}
			num /= 10
		}
		return false
	}

	for i := 1; i < n; i++ {
		j := n - i
		if !containsZero(i) && !containsZero(j) {
			return []int{i, j}
		}
	}
	return []int{}
}
