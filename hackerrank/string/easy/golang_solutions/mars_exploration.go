package golang_solutions

func marsExploration(s string) (miss int32) {
	// Write your code here
	left, right := 0, 3

	pattern := []rune{'S', 'O', 'S'}

	letters := []rune(s)

	for right <= len(s) {
		subLetters := letters[left:right]

		for idx, v := range subLetters {
			if pattern[idx] != v {
				miss++
			}
		}
		left += 3
		right += 3
	}
	return
}

func marsExploration2(s string) (miss int32) {
	// Write your code here
	letters := []rune(s)

	pattern := make([]rune, 0)

	for len(pattern) < len(letters) {
		pattern = append(pattern, 'S', 'O', 'S')
	}
	for idx := range letters {
		if letters[idx] != pattern[idx] {
			miss++
		}
	}
	return
}
