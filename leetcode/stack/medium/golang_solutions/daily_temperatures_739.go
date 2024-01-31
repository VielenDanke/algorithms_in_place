package golang_solutions

func dailyTemperatures(temperatures []int) []int {
	stack := make([]int, 0)

	for i, v := range temperatures {
		for len(stack) > 0 && v > temperatures[stack[len(stack)-1]] {
			idx := stack[len(stack)-1]
			temperatures[idx] = i - idx
			stack = stack[:len(stack)-1]
		}
		stack = append(stack, i)
	}
	for _, idx := range stack {
		temperatures[idx] = 0
	}
	return temperatures
}

func dailyTemperaturesBruteForce(temperatures []int) []int {
	for i := 0; i < len(temperatures); i++ {
		isFound := false
		for j := i; j < len(temperatures); j++ {
			if temperatures[i] < temperatures[j] {
				temperatures[i] = j - i
				isFound = true
				break
			}
		}
		if !isFound {
			temperatures[i] = 0
		}
	}
	return temperatures
}
