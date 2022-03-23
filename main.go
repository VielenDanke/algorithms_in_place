package main

import (
	"fmt"
	"github.com/vielendanke/preparation/tree"
	"github.com/vielendanke/preparation/tree/medium"
)

func main() {
	fmt.Printf("%v\n", medium.ZigzagLevelOrder(&tree.TreeNode{Val: 3, Left: &tree.TreeNode{Val: 9}, Right: &tree.TreeNode{Val: 20, Left: &tree.TreeNode{Val: 15}, Right: &tree.TreeNode{Val: 7}}}))
}
