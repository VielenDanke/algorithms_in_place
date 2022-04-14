package dynamic_programming

func MinNumberOfCoinsForChange(n int, denoms []int) int {
	if n == 0 {
		return 0
	}
	if len(minRecursive(n, denoms)) == 0 {
		return -1
	}
	return len(minRecursive(n, denoms))
}

func minRecursive(n int, denoms []int) []int {
	if n == 0 {
		return []int{}
	}
	if n < 1 {
		return nil
	}
	var shortest []int
	for idx := range denoms {
		temp := minRecursive(n-denoms[idx], denoms[idx:])
		if temp != nil {
			temp = append(temp, denoms[idx])
			if shortest == nil || len(temp) < len(shortest) {
				shortest = temp
			}
		}
	}
	return shortest
}
