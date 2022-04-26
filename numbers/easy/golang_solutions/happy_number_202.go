package golang_solutions

func isHappy(n int) bool {
	set := make(map[int]interface{})
	for n != 1 {
		nextNumber := 0
		set[n] = nil
		for n != 0 {
			right := n % 10
			nextNumber += right * right
			n /= 10
		}
		if _, ok := set[nextNumber]; ok {
			return false
		}
		n = nextNumber
	}
	return true
}
