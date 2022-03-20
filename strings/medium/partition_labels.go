package medium

import "strings"

func PartitionLabels(s string) []int {
	lastMaxIdx := 0
	start := 0
	result := make([]int, 0)

	for i := 0; i < len(s); i++ {
		lastIdx := strings.LastIndexByte(s, s[i])
		if lastIdx > lastMaxIdx {
			lastMaxIdx = lastIdx
		}
		if lastMaxIdx == i {
			result = append(result, lastMaxIdx-start+1)
			start = i + 1
			lastMaxIdx = i + 1
		}
	}
	return result
}

func partitionLabels2(s string) []int {
	last, result := make([]int, 26), make([]int, 0)

	runes := []rune(s)

	for i := 0; i < len(runes); i++ {
		last[runes[i]-'a'] = i
	}
	var j, anchor int

	for i := 0; i < len(runes); i++ {
		j = max(j, last[runes[i]-'a'])
		if i == j {
			result = append(result, i-anchor+1)
			anchor = i + 1
		}
	}
	return result
}
