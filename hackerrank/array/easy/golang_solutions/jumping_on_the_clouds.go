package golang_solutions

// https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem?isFullScreen=true

func jumpingOnClouds(c []int32) int32 {
	// Write your code here
	idx, steps := 0, 0

	for idx < len(c)-1 {
		if idx+2 < len(c) && c[idx+2] != 1 {
			idx += 2
		} else if idx+1 < len(c) && c[idx+1] != 1 {
			idx += 1
		}
		steps++
	}
	return int32(steps)
}
