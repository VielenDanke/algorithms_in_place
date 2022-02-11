package main

import (
	"fmt"
	"log"
	"os"
)

func bestSum(target int, numbers []int, memo map[int][]int) []int {
	if val, ok := memo[target]; ok {
		return val
	} else if target == 0 {
		return []int{}
	} else if target < 0 {
		return nil
	}
	var shortestCombination []int

	for _, v := range numbers {
		remainder := target - v
		remainderComb := bestSum(remainder, numbers, memo)
		if remainderComb != nil {
			remainderComb = append(remainderComb, v)
			if shortestCombination == nil || len(remainderComb) < len(shortestCombination) {
				shortestCombination = remainderComb
			}
		}
	}
	memo[target] = shortestCombination
	return shortestCombination
}

func main() {
	memo := make(map[int][]int)
	n, err := fmt.Fprintf(os.Stdout, "Result: %v\n", bestSum(7, []int{5, 3, 4, 25}, memo))
	if err != nil {
		log.Fatalln(err)
	}
	fmt.Printf("Bytes written: %d\n", n)
}
