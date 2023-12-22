package golang_solution

/* Rust solution
impl Solution {
    pub fn max_score(s: String) -> i32 {
        let (mut ones, mut zeroes, mut sum, mut n) = (0, 0, 0, 0);
        for c in s.chars() {
            if c == '1' {
                ones += 1;
            }
            n += 1
        }
        for (i, c) in s.chars().enumerate() {
            if c == '0' {
                zeroes += 1
            } else {
                ones -= 1
            }
            let tempSum = zeroes + ones;
            if tempSum > sum && i < n - 1 {
                sum = tempSum;
            }
        }
        sum
    }
}
*/

func maxScore(s string) int {
	ones, zeroes, sum, n := 0, 0, 0, len(s)
	for _, v := range s {
		if v == '1' {
			ones++
		}
	}
	for i, v := range s {
		if v == '0' {
			zeroes++
		} else {
			ones--
		}
		tempSum := zeroes + ones
		if tempSum > sum && i < n-1 {
			sum = tempSum
		}
	}
	return sum
}
