package golang_solutions

func pangrams(s string) string {
	// Write your code here
	m := make(map[rune]int)

	for _, letter := range s {
		m[letter]++
	}
	for letter := 'a'; letter <= 'z'; letter++ {
		_, isLowerExists := m[letter]
		_, isUpperExists := m[letter-32]
		if !isLowerExists && !isUpperExists {
			return "not pangram"
		}
	}
	return "pangram"
}

func pangramsArray(s string) string {
	// Write your code here
	m := [26]int{}

	for _, letter := range s {
		letterIdx := letter - 'a'
		if letterIdx < 0 || letterIdx > 26 {
			letterIdx = letter - 'A'
			if letterIdx < 0 || letterIdx > 26 {
				continue
			}
		}
		m[letterIdx]++
	}
	for letter := 'a'; letter <= 'z'; letter++ {
		if m[letter-'a'] == 0 {
			return "not pangram"
		}
	}
	return "pangram"
}
