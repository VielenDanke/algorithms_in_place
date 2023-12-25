package golang_solutions

import (
	"strconv"
)

/**
impl Solution {
    pub fn num_decodings(s: String) -> i32 {
        let (n, mut prev, mut curr) = (s.len(), 1, (s.chars().nth(0).unwrap() != '0') as i32);

        for i in 2..=n {
            let curr_char = s.chars().nth(i-1).unwrap();
            let prev_char = s.chars().nth(i-2).unwrap();

            let one = if curr_char != '0' {curr} else {0};
            let two = if prev_char == '1' || (prev_char == '2' && curr_char <= '6') {prev} else {0};

            prev = curr;
            curr = one + two;
        }
        curr
    }
}
*/

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
	n := len(s)
	dp := make([]int, n+1)

	dp[0] = 1
	if s[0] != '0' {
		dp[1] = 1
	} else {
		dp[1] = 0
	}
	for i := 2; i <= n; i++ {
		prev := s[i-1] - '0'
		current := (s[i-2]-'0')*10 + (s[i-1] - '0')
		if prev >= 1 && prev <= 9 {
			dp[i] += dp[i-1]
		}
		if current >= 10 && current <= 26 {
			dp[i] += dp[i-2]
		}
	}
	return dp[n]
}

// -----------------------------------------------------------------------

func numDecodingsDfs(s string) int {
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

// ------------------------------------------------------------------------

func numDecodingsBacktrackMemoization(s string) int {
	cache := make([]int, len(s))
	return backtrackNumDecode(0, s, cache)
}

func backtrackNumDecode(idx int, s string, cache []int) int {
	if idx >= len(s) {
		return 1
	}
	if cache[idx] > 0 {
		return cache[idx]
	}
	var total int
	if s[idx] != '0' {
		total += backtrackNumDecode(idx+1, s, nil)
		if idx+2 <= len(s) {
			first := s[idx] - '0'
			second := s[idx+1] - '0'
			if first*10+second <= 26 {
				total += backtrackNumDecode(idx+2, s, nil)
			}
		}
	}
	cache[idx] = total
	return total
}
