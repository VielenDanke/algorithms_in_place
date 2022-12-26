package golang_solutions

import "math"

// https://www.hackerrank.com/challenges/3d-surface-area/problem

func surfaceArea(a [][]int32) (result int32) {
	// Write your code here
	for i := 0; i < len(a); i++ {
		for j := 0; j < len(a[i]); j++ {
			result += 2 + a[i][j]*4
			if i-1 >= 0 {
				result -= int32(2 * math.Min(float64(a[i][j]), float64(a[i-1][j])))
			}
			if j-1 >= 0 {
				result -= int32(2 * math.Min(float64(a[i][j-1]), float64(a[i][j])))
			}
		}
	}
	return
}
