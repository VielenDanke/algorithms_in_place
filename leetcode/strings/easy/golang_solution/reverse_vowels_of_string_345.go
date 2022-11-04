package golang_solution

func reverseVowelsTwoPointers(s string) string {
	word := []rune(s)

	left, right := 0, len(word)-1

	for left < right {
		if !isVowel(word[left]) {
			left++
		} else if !isVowel(word[right]) {
			right--
		} else {
			word[left], word[right] = word[right], word[left]
			left++
			right--
		}
	}
	return string(word)
}

func reverseVowels(s string) string {
	vowels := make([]rune, 0)
	runes := []rune(s)

	for _, v := range runes {
		if isVowel(v) {
			vowels = append(vowels, v)
		}
	}
	right := len(vowels) - 1
	for i, v := range runes {
		if isVowel(v) {
			runes[i] = vowels[right]
			right--
		}
	}
	return string(runes)
}

func isVowel(c rune) bool {
	return c == 'a' || c == 'i' || c == 'e' || c == 'o' || c == 'u' || c == 'A' || c == 'I' || c == 'E' || c == 'O' || c == 'U'
}
