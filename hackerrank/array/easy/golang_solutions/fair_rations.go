package golang_solutions

import "fmt"

func fairRations(b []int32) string {
	answer := 0
	for i := 0; i < len(b)-1; i++ {
		if b[i]%2 == 1 {
			b[i]++
			b[i+1]++
			answer += 2
		}
	}
	if b[len(b)-1]%2 == 1 {
		return "NO"
	}
	return fmt.Sprintf("%d", answer)
}
