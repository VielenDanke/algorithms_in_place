package golang_solutions

func RemoveKdigits(num string, k int) (result string) {
	if k == 0 {
		return num
	}
	if len(num) <= k {
		return "0"
	}
	stack := make([]byte, 0)

	stack = append(stack, num[0])

	for i := 1; i < len(num); i++ {
		for k > 0 && len(stack) > 0 && num[i] < stack[len(stack)-1] {
			k--
			stack = stack[:len(stack)-1]
		}
		stack = append(stack, num[i])
		if len(stack) == 1 && num[i] == '0' {
			stack = stack[:len(stack)-1]
		}
	}
	for k > 0 && len(stack) > 0 {
		k--
		stack = stack[:len(stack)-1]
	}
	for _, v := range stack {
		result += string(v)
	}
	if result == "" {
		return "0"
	}
	return
}
