package golang_solutions

import "unicode"

func calculate(s string) int {
	n, sign, result, expr := len(s), 1, 0, []rune(s)

	stack := make([]int, 0)

	for i := 0; i < n; i++ {
		if unicode.IsDigit(expr[i]) {
			sum := int(expr[i] - '0')
			for i+1 < n && unicode.IsDigit(expr[i+1]) {
				sum = sum*10 + int(expr[i+1]-'0')
				i++
			}
			result += sum * sign
		} else if expr[i] == '+' {
			sign = 1
		} else if expr[i] == '-' {
			sign = -1
		} else if expr[i] == '(' {
			stack = append(stack, result)
			stack = append(stack, sign)
			result = 0
			sign = 1
		} else if expr[i] == ')' {
			result *= stack[len(stack)-1]
			stack = stack[:len(stack)-1]
			result += stack[len(stack)-1]
			stack = stack[:len(stack)-1]
		}
	}
	return result
}
