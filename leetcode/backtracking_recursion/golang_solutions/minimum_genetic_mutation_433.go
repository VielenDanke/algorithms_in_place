package golang_solutions

var min int

func minMutation(start string, end string, bank []string) int {
	min = 1 << 30
	backtrack(start, end, bank, make([]bool, len(bank)), 0)
	return verifyResponse(min)
}

func backtrack(current string, end string, bank []string, visited []bool, path int) {
	if path > len(bank) {
		return
	}
	if current == end {
		min = minVal(path, min)
		return
	}
	for i := 0; i < len(bank); i++ {
		if !visited[i] && isValidStep(current, bank[i]) {
			visited[i] = true
			backtrack(bank[i], end, bank, visited, path+1)
			visited[i] = false
		}
	}
}

func isValidStep(start, bank string) bool {
	if len(start) != len(bank) {
		return false
	}
	counter := 0
	for i := range start {
		if start[i] != bank[i] {
			counter++
			if counter > 1 {
				return false
			}
		}
	}
	return true
}

func verifyResponse(val int) int {
	if val == 1<<30 {
		return -1
	}
	return val
}

func minVal(a, b int) int {
	if a > b {
		return b
	}
	return a
}
