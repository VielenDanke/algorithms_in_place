package golang_solutions

import "math"

// https://www.hackerrank.com/challenges/acm-icpc-team/problem

func acmTeam(topic []string) []int32 {
	// Write your code here
	result := make(map[int32]int32)
	backtrackAcmTeam(result, topic, make([]string, 0), 0)
	max := float64(-1)
	for k := range result {
		max = math.Max(max, float64(k))
	}
	return []int32{int32(max), result[int32(max)]}
}

func backtrackAcmTeam(result map[int32]int32, topic []string, temp []string, start int) {
	if len(temp) == 2 {
		result[calculateResult(temp)]++
		return
	}
	for i := start; i < len(topic); i++ {
		temp = append(temp, topic[i])
		backtrackAcmTeam(result, topic, temp, i+1)
		temp = temp[:len(temp)-1]
	}
}

func calculateResult(temp []string) (counter int32) {
	n := len(temp[0])

	for i := 0; i < n; i++ {
		if temp[0][i] == '1' || temp[1][i] == '1' {
			counter++
		}
	}
	return
}
