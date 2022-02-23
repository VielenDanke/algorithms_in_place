package main

import "fmt"

func main() {
	fmt.Printf("Result: %v", bestSum(8, []int{2, 3, 5}, make(map[int][]int)))
}
