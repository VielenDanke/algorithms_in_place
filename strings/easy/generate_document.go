package easy

func GenerateDocument(characters string, document string) bool {
	// Write your code here.
	chRunes, docRunes := []rune(characters), []rune(document)
	if len(docRunes) == 0 {
		return true
	}
	letterMap := make(map[rune]int)
	for _, ch := range docRunes {
		if _, ok := letterMap[ch]; ok {
			letterMap[ch]++
		} else {
			letterMap[ch] = 1
		}
	}
	for _, ch := range chRunes {
		if _, ok := letterMap[ch]; ok {
			amountOfLetter := letterMap[ch]
			if amountOfLetter-1 == 0 {
				delete(letterMap, ch)
			} else {
				letterMap[ch]--
			}
		}
	}
	return len(letterMap) == 0
}
