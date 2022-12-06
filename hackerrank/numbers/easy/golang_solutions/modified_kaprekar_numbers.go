package golang_solutions

import (
	"fmt"
	"strconv"
)

// https://www.hackerrank.com/challenges/kaprekar-numbers/problem

func kaprekarNumbers(p int32, q int32) {
	// Write your code here
	isFound := false
	for i := int(p); i <= int(q); i++ {
		powNum := i * i
		s := strconv.Itoa(powNum)
		left, _ := strconv.Atoi(s[:len(s)/2])
		right, _ := strconv.Atoi(s[len(s)/2:])
		if left+right == i {
			isFound = true
			fmt.Print(i)
			fmt.Print(" ")
		}
	}
	if !isFound {
		fmt.Print("INVALID RANGE")
	}
}
