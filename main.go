package main

import (
	"fmt"
	"github.com/vielendanke/preparation/greedy_algorithms/easy"
)

func main() {
	b := easy.TandemBicycle([]int{5, 5, 3, 9, 2}, []int{3, 6, 7, 2, 1}, false)

	fmt.Printf("Result: %d\n", b)
}
