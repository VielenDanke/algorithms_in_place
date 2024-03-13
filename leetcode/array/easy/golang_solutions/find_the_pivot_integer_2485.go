package golang_solutions

/*
pub struct Solution {}

impl Solution {
    pub fn pivot_integer(n: i32) -> i32 {
        let mut left_prefix_sum = Vec::new();
        let mut right_prefix_sum = Vec::new();

        for i in 0..n {
            if i == 0 {
                left_prefix_sum.push( i + 1);
            } else {
                left_prefix_sum.push((i + 1) + left_prefix_sum[i as usize - 1]);
            }
        }
        let mut idx = 0;
        for i in (1..n+1).rev() {
            if idx == 0 {
                right_prefix_sum.push(i);
            } else {
                right_prefix_sum.push(i + right_prefix_sum[idx as usize - 1]);
            }
            idx += 1;
        }
        for i in 0..n as usize {
            if left_prefix_sum[i] == right_prefix_sum[(n - 1) as usize - i] {
                return (i + 1) as i32;
            }
        }
        -1
    }

    pub fn pivot_integer_better(n: i32) -> i32 {
        let mut s1 = n * (n + 1) / 2;
        let mut s2 = 0;

        for i in 1..n+1 {
            s2 += i;

            if s1 == s2 {
                return i;
            }
            s1 -= i;
        }
        -1
    }
}

*/

func pivotInteger(n int) int {
	s1, s2 := n*(n+1)/2, 0

	for i := 1; i <= n; i++ {
		s2 += i

		if s1 == s2 {
			return i
		}
		s1 -= i
	}
	return -1
}

func pivotIntegerPrefixSumArray(n int) int {
	leftPrefixSum, rightPrefixSum := make([]int, n), make([]int, n)

	for i := 0; i < n; i++ {
		if i == 0 {
			leftPrefixSum[i] = i + 1
		} else {
			leftPrefixSum[i] = i + 1 + leftPrefixSum[i-1]
		}
	}
	idx := 0
	for i := n; i >= 1; i-- {
		if idx == 0 {
			rightPrefixSum[idx] = i
		} else {
			rightPrefixSum[idx] = i + rightPrefixSum[idx-1]
		}
		idx++
	}
	for i := 0; i < n; i++ {
		if leftPrefixSum[i] == rightPrefixSum[n-1-i] {
			return i + 1
		}
	}
	return -1
}
