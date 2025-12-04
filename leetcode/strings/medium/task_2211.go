package medium

func countCollisions(directions string) int {
	flag := -1
	result := 0

	for _, dir := range directions {
		switch dir {
		case 'L':
			if flag >= 0 {
				result += flag + 1
				flag = 0
			}
		case 'S':
			if flag > 0 {
				result += flag
			}
			flag = 0
		case 'R':
			if flag >= 0 {
				flag += 1
			} else {
				flag = 1
			}

		}
	}
	return result
}
