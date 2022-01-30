package main

import (
	"fmt"
	"github.com/vielendanke/preparation/greedy_algorithms"
)

func main() {
	arr := []int{3, 2, 1, 2, 6}
	fmt.Printf("Result: %d\n", greedy_algorithms.MinimumWaitingTime(arr))
}
