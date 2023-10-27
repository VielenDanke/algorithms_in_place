package golang_solutions

import "strings"

func longestPalindrome(s string) string {
	transformedS := "^#" + strings.Join(strings.Split(s, ""), "#") + "#$"
	n := len(transformedS)
	radius := make([]int, n)
	center, rightBoundary := 0, 0

	for i := 1; i < n-1; i++ {
		if rightBoundary > i {
			radius[i] = min(rightBoundary-i, radius[2*center-i])
		}
		for transformedS[i+1+radius[i]] == transformedS[i-1-radius[i]] {
			radius[i]++
		}
		if i+radius[i] > rightBoundary {
			center, rightBoundary = i, i+radius[i]
		}
	}
	maxLen := 0
	centerIndex := 0
	for i, v := range radius {
		if v > maxLen {
			maxLen = v
			centerIndex = i
		}
	}
	return s[(centerIndex-maxLen)/2 : (centerIndex+maxLen)/2]
}
