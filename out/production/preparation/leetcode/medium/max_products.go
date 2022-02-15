package medium

import "strings"

func MaxProduct(words []string) int {
	max := 0

	for i := range words {
		for j := range words {
			if i == j {
				continue
			}
			isPower := true
			for _, v := range words[j] {
				if strings.Contains(words[i], string(v)) {
					isPower = false
					break
				}
			}
			if isPower && max < len(words[i])*len(words[j]) {
				max = len(words[i]) * len(words[j])
			}
		}
	}
	return max
}
