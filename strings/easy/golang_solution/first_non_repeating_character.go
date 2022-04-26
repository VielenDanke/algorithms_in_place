package golang_solution

func FirstNonRepeatingCharacter(str string) int {
	// Write your code here.
	for i := range str {
		isRepeated := false
		for j := range str {
			if str[i] == str[j] && i != j {
				isRepeated = true
			}
		}
		if !isRepeated {
			return i
		}
	}
	return -1
}
