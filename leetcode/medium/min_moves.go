package medium

func MinMoves(target int, maxDoubles int) (operations int) {
	for target > 1 {
		if target%2 == 0 && maxDoubles != 0 {
			maxDoubles--
			target /= 2
		} else {
			target--
		}
		operations++
	}
	return operations
}
