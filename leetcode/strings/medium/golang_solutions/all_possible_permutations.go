package golang_solutions

import "fmt"

func AllPossiblePermutations(str string, n int) {
	if len(str) == n {
		fmt.Println(str)
		return
	}
	AllPossiblePermutations(str+"A", n)
	AllPossiblePermutations(str+"B", n)
	AllPossiblePermutations(str+"C", n)
}
