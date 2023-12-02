package golang_solution

// array

func countCharactersArray(words []string, chars string) (sum int) {
	alph := make([]int, 26)

	for _, ch := range chars {
		alph[ch-'a']++
	}
	for _, word := range words {
		isFound := true
		cpAlph := make([]int, 26)
		copy(cpAlph, alph)
		for _, ch := range word {
			if cpAlph[ch-'a'] == 0 {
				isFound = false
				break
			}
			cpAlph[ch-'a']--
		}
		if isFound {
			sum += len(word)
		}
	}
	return
}

func countCharactersArrayNoCopy(words []string, chars string) (sum int) {
	alph := make([]int, 26)

	for _, ch := range chars {
		alph[ch-'a']++
	}
	for _, word := range words {
		isFound := true
		nonFoundIdx := len(word)
		for idx, ch := range word {
			if alph[ch-'a'] == 0 {
				isFound = false
				nonFoundIdx = idx
				break
			}
			alph[ch-'a']--
		}
		if isFound {
			sum += len(word)
		}
		for idx, ch := range word {
			if idx >= nonFoundIdx {
				break
			}
			alph[ch-'a']++
		}
	}
	return
}

// map, slower since the access in the worst case scenario could be O(logN) (depends on a language implementation, could be even O(N))

func countCharacters(words []string, chars string) (sum int) {
	counter := make(map[rune]int)

	for _, ch := range chars {
		counter[ch]++
	}
	for _, word := range words {
		isFound := true
		nonFoundIdx := len(word)
		for idx, ch := range word {
			val, ok := counter[ch]
			if !ok || val <= 0 {
				isFound = false
				nonFoundIdx = idx
				break
			}
			counter[ch]--
		}
		if isFound {
			sum += len(word)
		}
		for idx, ch := range word {
			if idx >= nonFoundIdx {
				break
			}
			counter[ch]++
		}
	}
	return
}
