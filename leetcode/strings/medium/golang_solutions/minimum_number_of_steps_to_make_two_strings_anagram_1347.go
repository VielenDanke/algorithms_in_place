package golang_solutions

import "math"

/*
Rust

use std::cmp;

impl Solution {
    pub fn min_steps(s: String, t: String) -> i32 {
        let mut s_count = vec![0; 26];
        let mut t_count = vec![0; 26];

        for ch in s.chars() {
            s_count[ch as usize - 'a' as usize] += 1;
        }
        for ch in t.chars() {
            t_count[ch as usize - 'a' as usize] += 1;
        }
        let mut result = 0;

        for (s, t) in s_count.iter().zip(t_count.iter()) {
            result += cmp::max(s - t, 0);
        }
        result as i32
    }
}
*/

func minSteps(s string, t string) (result int) {
	sCount, tCount := make([]int, 26), make([]int, 26)

	for _, ch := range s {
		sCount[ch-'a']++
	}
	for _, ch := range t {
		tCount[ch-'a']++
	}
	for i, v := range sCount {
		result += int(math.Max(float64(v-tCount[i]), float64(0)))
	}
	return
}
