package golang_solutions

import "strings"

func maximumOddBinaryNumber(s string) string {
	ones := strings.Count(s, "1")

	startedOnes := ones - 1

	v := make([]byte, len(s))

	for i := 0; i < len(s); i++ {
		if i < startedOnes {
			v[i] = '1'
			continue
		}
		v[i] = '0'
	}
	v[len(v)-1] = '1'
	return string(v)
}
