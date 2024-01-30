package golang_solutions

import (
	"strconv"
)

func evalRPN(tokens []string) int {
	stack := make([]int, 0)

	for _, v := range tokens {
		var toAppend int
		if v == "*" || v == "-" || v == "+" || v == "/" {
			last := stack[len(stack)-1]
			prevLast := stack[len(stack)-2]
			stack = stack[:len(stack)-2]
			if v == "*" {
				toAppend = last * prevLast
			} else if v == "-" {
				toAppend = prevLast - last
			} else if v == "+" {
				toAppend = prevLast + last
			} else {
				toAppend = prevLast / last
			}
		} else {
			toAppend, _ = strconv.Atoi(v)
		}
		stack = append(stack, toAppend)
	}
	return stack[0]
}
