package golang_solutions

// https://www.hackerrank.com/challenges/equality-in-a-array/problem

func EqualizeArray(arr []int32) int32 {
	// Write your code here
	m := make(map[int32]int)

	maxVal := 0
	maxNum := int32(0)

	for _, v := range arr {
		m[v]++
		if m[v] > maxVal {
			maxNum = v
			maxVal = m[v]
		}
	}
	return int32(len(arr) - m[maxNum])
}
