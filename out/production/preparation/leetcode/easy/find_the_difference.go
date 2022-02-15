package easy

import "sort"

func findTheDifference(s string, t string) byte {
	sRunes, tRunes := []rune(s), []rune(t)
	sort.Slice(sRunes, func(i, j int) bool {
		return sRunes[i] > sRunes[j]
	})
	sort.Slice(tRunes, func(i, j int) bool {
		return tRunes[i] > tRunes[j]
	})
	for idx := range sRunes {
		if sRunes[idx] != tRunes[idx] {
			return byte(tRunes[idx])
		}
	}
	return byte(tRunes[len(tRunes)-1])
}
