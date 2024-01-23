package golang_solutions

import "math"

var maxConc int

func maxLength(arr []string) int {
	maxConc = 0
	backtrackUniqueCharacters(arr, "", 0)
	return maxConc
}

func backtrackUniqueCharacters(arr []string, temp string, idx int) {
	if idx >= len(arr) {
		maxConc = int(math.Max(float64(maxConc), float64(len(temp))))
		return
	}
	maxConc = int(math.Max(float64(maxConc), float64(len(temp))))

	for i := idx; i < len(arr); i++ {
		letters := collectLetters(temp, arr[i])
		if letters != nil {
			prevLength := len(temp)
			temp += arr[i]
			backtrackUniqueCharacters(arr, temp, i+1)
			temp = temp[:prevLength]
		}
	}
}

func collectLetters(a, b string) []int {
	alph := make([]int, 26)
	for _, ch := range a {
		alph[ch-'a']++
		if alph[ch-'a'] > 1 {
			return nil
		}
	}
	for _, ch := range b {
		alph[ch-'a']++
		if alph[ch-'a'] > 1 {
			return nil
		}
	}
	return alph
}
