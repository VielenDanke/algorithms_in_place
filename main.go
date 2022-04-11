package main

import (
	"fmt"
	"github.com/vielendanke/algorithms_in_place/array/medium/bfs_dfs"
)

func main() {
	fmt.Printf("%v\n", bfs_dfs.OrangesRotting([][]int{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}))
}
