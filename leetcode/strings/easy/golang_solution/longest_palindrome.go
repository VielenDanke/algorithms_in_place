package golang_solution

func LongestPalindrome2(s string) (result int) {
	storage := make(map[rune]int)
	for _, char := range s {
		storage[char]++
	}
	isOneAppend := false
	for _, char := range s {
		if v, ok := storage[char]; ok {
			if (v-1)%2 == 0 && !isOneAppend && v != 1 {
				result += v
				isOneAppend = true
			} else if v%2 == 0 {
				result += v
			}
			delete(storage, char)
		}
	}
	if !isOneAppend && len(storage) != 0 {
		result += 1
	}
	return
}

func LongestPalindrome(s string) (result int) {
	m := make(map[rune]int)
	for _, v := range s {
		m[v]++
	}
	var isOdd bool
	for _, value := range m {
		result += value
		if value%2 == 1 {
			result--
			isOdd = true
		}
	}
	if isOdd {
		result++
	}
	return
}
