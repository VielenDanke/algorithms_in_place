package main

import (
	"fmt"
	"github.com/vielendanke/preparation/leetcode/medium"
)

func main() {
	tree := medium.BuildTree([]int{-1}, []int{-1})

	traverseTree(tree)
}

func traverseTree(node *medium.TreeNode) {
	if node == nil {
		return
	}
	fmt.Println(node.Val)
	traverseTree(node.Left)
	traverseTree(node.Right)
}
