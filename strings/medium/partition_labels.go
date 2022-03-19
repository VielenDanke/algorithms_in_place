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
