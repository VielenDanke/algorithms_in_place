package main

import (
	"github.com/vielendanke/preparation/tree"
	"github.com/vielendanke/preparation/tree/medium"
)

func main() {
	medium.BSTConstructor(&tree.TreeNode{Val: 7, Left: &tree.TreeNode{Val: 3}, Right: &tree.TreeNode{Val: 15, Left: &tree.TreeNode{Val: 9}, Right: &tree.TreeNode{Val: 20}}})
}
