package golang_solutions

import "unicode"

// https://www.hackerrank.com/challenges/caesar-cipher-1/problem?isFullScreen=true

func caesarCipher(s string, k int32) string {
	// Write your code here
	n := 26

	alphabet := make([]rune, n, n)

	for letter := 'a'; letter <= 'z'; letter++ {
		alphabet[letter-'a'] = letter
	}
	phrase := []rune(s)

	for i := 0; i < len(phrase); i++ {
		letter := phrase[i]
		if unicode.IsLetter(letter) {
			isUpper := unicode.IsUpper(letter)
			letter = unicode.ToLower(letter)
			letter = alphabet[(int(letter-'a')+int(k))%n]
			if isUpper {
				letter = unicode.ToUpper(letter)
			}
			phrase[i] = letter
		}
	}
	return string(phrase)
}
