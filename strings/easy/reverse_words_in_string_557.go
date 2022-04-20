package easy

import (
	"strings"
)

func reverseWords(s string) string {
	words := strings.Split(s, " ")

	for idx, v := range words {
		letters := []rune(v)
		reverseLetters(letters)
		words[idx] = string(letters)
	}
	return strings.Join(words, " ")
}

func reverseLetters(word []rune) {
	left, right := 0, len(word)-1

	for left <= right {
		word[left], word[right] = word[right], word[left]
		left++
		right--
	}
}
