package main

import (
	"fmt"
	"github.com/vielendanke/preparation/tree"
	"github.com/vielendanke/preparation/tree/medium"
)

func main() {
	fmt.Printf("%v\n", medium.PathSum(&tree.TreeNode{
		Val: 5,
		Left: &tree.TreeNode{
			Val: 4,
			Left: &tree.TreeNode{
				Val:   11,
				Left:  &tree.TreeNode{Val: 7},
				Right: &tree.TreeNode{Val: 2},
			},
		},
		Right: &tree.TreeNode{
			Val: 8,
			Left: &tree.TreeNode{
				Left: &tree.TreeNode{Val: 13}},
			Right: &tree.TreeNode{
				Val:   4,
				Left:  &tree.TreeNode{Val: 5},
				Right: &tree.TreeNode{Val: 1}}},
	}, 22,
	))
}
