package main

import (
	"fmt"
	"github.com/vielendanke/preparation/graph/medium"
)

func main() {
	fmt.Printf("%v\n", medium.FindSmallestSetOfVertices(6, [][]int{{0, 1}, {0, 2}, {2, 5}, {3, 4}, {4, 2}}))
}
