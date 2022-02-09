package main

import "github.com/vielendanke/preparation/array/medium"

func main() {
	res := medium.MaxSubarraySum([]int{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 15)

	for _, v := range res {
		println(v)
	}
}
