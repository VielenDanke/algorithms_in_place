package golang_solutions

import (
	"math"
	"strconv"
	"strings"
)

// optimal

func getLengthOfOptimalCompression(s string, k int) int {
	cache := make([][]int, len(s)+1)

	for i := range cache {
		cache[i] = make([]int, k+1)

		for j := range cache[i] {
			cache[i][j] = -1
		}
	}
	return dpOptimalCompression(cache, s, k)
}

func dpOptimalCompression(memo [][]int, s string, k int) int {
	if memo[len(s)][k] != -1 {
		return memo[len(s)][k]
	}
	if len(s) <= k {
		return 0
	}
	result := 1 << 31
	if k > 0 {
		result = dpOptimalCompression(memo, s[1:], k-1)
	}
	frequency := 0
	currentK := k
	for i := range s {
		if s[i] == s[0] {
			frequency++
		} else if currentK > 0 {
			currentK--
		} else {
			break
		}
		result = min(result, getLength(frequency)+dpOptimalCompression(memo, s[i+1:], currentK))
	}
	memo[len(s)][k] = result

	return result
}

func getLength(frequency int) int {
	if frequency < 2 {
		return 1
	} else if frequency < 10 {
		return 2
	} else if frequency < 100 {
		return 3
	} else {
		return 4
	}
}

// brute force

func getLengthOfOptimalCompressionBruteForce(s string, k int) int {
	return backtrackOptimalCompression(s, k)
}

func backtrackOptimalCompression(s string, k int) int {
	if k == 0 {
		return calculateLength(s)
	}
	minLength := 1 << 30
	for i := 0; i < len(s); i++ {
		currentLength := backtrackOptimalCompression(s[0:i]+s[i+1:], k-1)
		minLength = int(math.Min(float64(minLength), float64(currentLength)))
	}
	return minLength
}

func calculateLength(input string) int {
	var result strings.Builder
	length := len(input)
	if length == 0 {
		return 0
	}
	currentChar := input[0]
	count := 1
	for i := 1; i < length; i++ {
		if input[i] == currentChar {
			count++
		} else {
			result.WriteByte(currentChar)
			if count > 1 {
				result.WriteString(strconv.Itoa(count))
			}
			currentChar = input[i]
			count = 1
		}
	}
	result.WriteByte(currentChar)
	if count > 1 {
		result.WriteString(strconv.Itoa(count))
	}
	return result.Len()
}
