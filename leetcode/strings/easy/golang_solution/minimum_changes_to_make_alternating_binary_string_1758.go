package golang_solution

import "math"

/*
use std::cmp;

impl Solution {
    pub fn min_operations(s: String) -> i32 {
        let (n, mut count) = (s.len(), 0);
        if n == 1 {
            return 0;
        }
        for (i, c) in s.chars().enumerate() {
            let is_even = i % 2 == 0;

            if (is_even && c == '1') || (!is_even && c == '0') {
                count += 1;
            }
        }
        cmp::min(count, n as i32 - count)
    }
}
*/

func minOperations(s string) int {
	n, count := len(s), 0
	if n == 1 {
		return 0
	}
	for i := 0; i < n; i++ {
		isEven := i%2 == 0
		if (isEven && s[i] == '1') || (!isEven && s[i] == '0') {
			count++
		}
	}
	return int(math.Min(float64(count), float64(n-count)))
}

// optimized

func minOperationsCountTwoPossibleArrays(s string) int {
	runes := []rune(s)
	left := countAlternating(runes, runes[0])
	if runes[0] == '1' {
		runes[0] = '0'
	} else {
		runes[0] = '1'
	}
	right := countAlternating(runes, runes[0]) + 1
	return int(math.Min(float64(left), float64(right)))
}

func countAlternating(runes []rune, prev rune) (counter int) {
	for i := 1; i < len(runes); i++ {
		if runes[i] == prev {
			counter++
			if prev == '0' {
				prev = '1'
			} else {
				prev = '0'
			}
		} else {
			prev = runes[i]
		}
	}
	return
}

// brute force

func minOperationsBruteForce(s string) int {
	return dfs(0, []rune(s))
}

func dfs(idx int, runes []rune) int {
	if idx >= len(runes) {
		if isValid(runes) {
			return 0
		}
		return -1
	}
	min := 1 << 30
	var result int
	if runes[idx] == '1' {
		runes[idx] = '0'
		result = dfs(idx+1, runes)
		runes[idx] = '1'
		if result >= 0 {
			min = minNum(min, result+1)
		}
	} else {
		runes[idx] = '1'
		result = dfs(idx+1, runes)
		runes[idx] = '0'
		if result >= 0 {
			min = minNum(min, result+1)
		}
	}
	result = dfs(idx+1, runes)
	if result >= 0 {
		min = minNum(min, result)
	}
	return min
}

func minNum(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func isValid(runes []rune) bool {
	for i := range runes {
		if i > 0 && runes[i] == runes[i-1] {
			return false
		}
	}
	return true
}
