package golang_solutions

import "strconv"

func DiffWaysCompute(expression string) []int {
	result := make([]int, 0)
	for i := 0; i < len(expression); i++ {
		c := expression[i]
		if c == '+' || c == '*' || c == '-' {
			fSub := expression[0:i]
			sSub := expression[i+1:]
			v1 := DiffWaysCompute(fSub)
			v2 := DiffWaysCompute(sSub)
			for _, x := range v1 {
				for _, y := range v2 {
					if c == '*' {
						result = append(result, x*y)
					} else if c == '-' {
						result = append(result, x-y)
					} else if c == '+' {
						result = append(result, x+y)
					}
				}
			}
		}
	}
	if len(result) == 0 {
		t, err := strconv.Atoi(expression)
		if err == nil {
			result = append(result, t)
		}
	}
	return result
}
