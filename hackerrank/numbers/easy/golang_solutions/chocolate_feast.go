package golang_solutions

// https://www.hackerrank.com/challenges/chocolate-feast/problem

func chocolateFeast(n int32, c int32, m int32) int32 {
	result, wr := int32(0), int32(0)

	for n-c >= 0 {
		n -= c
		result++
		wr++
		if wr == m {
			n += c
			wr = 0
		}
	}
	return result
}
