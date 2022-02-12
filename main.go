package main

import (
	"fmt"
	"github.com/vielendanke/preparation/sorting/medium"
)

func main() {
	arr := []int{14, 3, 1, 5, 6, 2, 55}
	arr = medium.Sort(arr)
	fmt.Println(arr)
}
