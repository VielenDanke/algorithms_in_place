package golang_solutions

// https://www.hackerrank.com/challenges/beautiful-triplets/problem

func beautifulTriplets(d int32, arr []int32) int32 {
	// Write your code here
	result := int32(0)
	m := make(map[int32]interface{})
	for _, v := range arr {
		m[v] = nil
	}
	for _, v := range arr {
		_, x := m[v+d]
		_, y := m[v+2*d]
		if x && y {
			result++
		}
	}
	return result
}
