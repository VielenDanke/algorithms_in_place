package main

import (
	"fmt"
	"github.com/vielendanke/preparation/leetcode"
)

func main() {
	result := leetcode.InsertIntervals([][]int{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, []int{4, 8})

	for _, v := range result {
		print("{")
		for k, val := range v {
			if k != len(v)-1 {
				fmt.Printf("%d, ", val)
			} else {
				fmt.Print(val)
			}
		}
		print("}")
		println()
	}
}
