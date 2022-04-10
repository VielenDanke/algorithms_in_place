package stack

import "strconv"

func calPoints(ops []string) (sum int) {
	stack := make([]int, 0)

	for _, v := range ops {
		if v == "D" {
			sumToAppend := stack[len(stack)-1] * 2
			sum += sumToAppend
			stack = append(stack, sumToAppend)
		} else if v == "C" {
			sum -= stack[len(stack)-1]
			stack = stack[:len(stack)-1]
		} else if v == "+" {
			stack = append(stack, stack[len(stack)-1]+stack[len(stack)-2])
			sum += stack[len(stack)-1]
		} else {
			num, _ := strconv.Atoi(v)
			stack = append(stack, num)
			sum += num
		}
	}
	return
}
