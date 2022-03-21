package medium

import (
	"strings"
)

// right way

func findRepeatedDnaSequences(s string) []string {
	result := make([]string, 0)
	storage := make(map[string]int)
	i, j, k := 0, 0, 10

	for j < len(s) {
		if j-i+1 == k {
			sub := s[i : j+1]
			storage[sub]++
			if storage[sub] > 1 && storage[sub] <= 2 {
				result = append(result, sub)
			}
			i++
		}
		j++
	}
	return result
}

// brut force

func FindRepeatedDnaSequences(s string) []string {
	if len(s) <= 10 {
		return []string{}
	}
	storage := make(map[string]interface{})
	result := make([]string, 0)

	for i := 0; i < len(s)-10; i++ {
		temp := s[i : i+10]
		if _, ok := storage[temp]; ok {
			continue
		}
		if strings.Contains(s[i+1:], temp) {
			storage[temp] = nil
			result = append(result, temp)
		}
	}
	return result
}
