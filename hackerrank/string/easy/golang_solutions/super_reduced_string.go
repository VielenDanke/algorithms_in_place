package golang_solutions

func superReducedString(s string) string {
	// Write your code here
	runes := []rune(s)
	isAllDeleted := false
	for !isAllDeleted {
		isAllDeleted = true
		for i := 1; i < len(runes); i++ {
			if runes[i-1] == runes[i] {
				isAllDeleted = false
				runes = append(runes[:(i-1)], runes[(i+1):]...)
			}
		}
	}
	return fitAnswer(runes)
}

func fitAnswer(runes []rune) string {
	if len(runes) == 0 {
		return "Empty String"
	}
	return string(runes)
}
