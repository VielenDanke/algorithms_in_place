package golang_solutions

import (
	"github.com/vielendanke/algorithms_in_place/leetcode/tree"
	"strings"
)

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func getDirections(root *tree.TreeNode, startValue int, destValue int) string {
	arrToStart := dfsDirection(root, make([]byte, 0), startValue)
	arrToDest := dfsDirection(root, make([]byte, 0), destValue)

	i := 0

	for i < len(arrToStart) && i < len(arrToDest) && arrToStart[i] == arrToDest[i] {
		i++
	}
	pathUp := strings.Repeat("U", len(arrToStart)-i)
	pathDown := string(arrToDest[i:])

	return pathUp + pathDown
}

func dfsDirection(root *tree.TreeNode, arr []byte, target int) []byte {
	if root.Val == target {
		return arr
	}
	if root.Left != nil {
		newArr := append(arr, 'L')
		if found := dfsDirection(root.Left, newArr, target); found != nil {
			return found
		}
	}
	if root.Right != nil {
		newArr := append(arr, 'R')
		if found := dfsDirection(root.Right, newArr, target); found != nil {
			return found
		}
	}
	return nil
}
