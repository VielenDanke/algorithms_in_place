package golang_solution

import "strings"

func canBeTypedWords(text string, brokenLetters string) (count int) {
	splitText := strings.Split(text, " ")

	brokenMap := make(map[rune]interface{})

	for _, b := range brokenLetters {
		brokenMap[b] = nil
	}
	for _, word := range splitText {
		isBroken := false
		for i := 0; i < len(word); i++ {
			if _, ok := brokenMap[rune(word[i])]; ok {
				isBroken = true
				break
			}
		}
		if !isBroken {
			count++
		}
	}
	return
}
