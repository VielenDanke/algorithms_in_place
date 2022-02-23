package medium

import (
	"fmt"
	"strings"
)

func SplitPi(pi string, fav []string) string {
	piRunes := []rune(pi)
	result := make([]string, 0)
	findBestPrefix(piRunes, fav, &result)
	count := len(result)
	return fmt.Sprintf("%d (%s)", count, strings.Join(result, " "))
}

func findBestPrefix(pi []rune, fav []string, result *[]string) {
	for _, v := range fav {
		idx := isMatch(pi, []rune(v))
		if idx == -1 {
			continue
		} else {
			*result = append(*result, string(pi[0:idx]))
			pi = pi[idx:]
		}
	}
}

func isMatch(f []rune, s []rune) int {
	for i := 0; i+len(s) <= len(f); i++ {
		temp := f[i : i+len(s)]
		if string(temp) == string(s) {
			return i + len(s)
		}
	}
	return -1
}
