package golang_solutions

/*
use std::collections::HashMap;

impl Solution {
    pub fn min_operations(nums: Vec<i32>) -> i32 {
        let mut counter = HashMap::new();

        for v in nums {
            *counter.entry(v).or_insert(0) += 1;
        }
        let mut result = 0;
        for v in counter.values() {
            let mut count = *v;
            while count > 0 {
                if count == 3 || count > 4 {
                    count -= 3;
                } else if count >= 2 {
                    count -= 2;
                } else {
                    return -1;
                }
                result += 1;
            }
        }
        result
    }
}
*/

func minOperations(nums []int) (result int) {
	counter := make(map[int]int)
	for _, v := range nums {
		counter[v]++
	}
	for _, v := range counter {
		for v > 0 {
			if v == 3 || v > 4 {
				v -= 3
			} else if v >= 2 {
				v -= 2
			} else {
				return -1
			}
			result++
		}
	}
	return
}
