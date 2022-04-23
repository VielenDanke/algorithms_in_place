package golang_solutions

import "strings"

func longestWord(words []string) string {
	result := ""
	set := make(map[string]interface{})

	for _, word := range words {
		set[word] = nil
	}
	for _, word := range words {
		if len(word) > len(result) || len(word) == len(result) && strings.Compare(word, result) < 0 {
			isGood := true
			for i := 1; i < len(word); i++ {
				if _, ok := set[word[0:i]]; !ok {
					isGood = false
					break
				}
			}
			if isGood {
				result = word
			}
		}
	}
	return result
}
