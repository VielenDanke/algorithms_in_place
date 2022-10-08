package golang_solutions

import (
	"strconv"
)

// TODO: have to implement using DP - current solution is working but time limit

var globalWaysCounter = 0
var globalMap = make(map[string]rune)

func init() {
	counter := 1
	for r := 'A'; r <= 'Z'; r += 1 {
		globalMap[strconv.Itoa(counter)] = r
		counter++
	}
}

func numDecodingsDP(s string) int {
	return -1
}

// -----------------------------------------------------------------------

func numDecodings(s string) int {
	globalWaysCounter = 0
	decodeWays(s, 1)
	return globalWaysCounter
}

func decodeWays(s string, start int) {
	if len(s) == 0 {
		globalWaysCounter++
		return
	}
	for i := start; i <= 2 && i <= len(s); i++ {
		if _, ok := globalMap[s[:i]]; ok {
			decodeWays(s[i:], 1)
		}
	}
}
