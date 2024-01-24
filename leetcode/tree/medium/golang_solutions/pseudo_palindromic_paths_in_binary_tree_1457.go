package golang_solutions

import "github.com/vielendanke/algorithms_in_place/leetcode/tree"

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
var counter int

func pseudoPalindromicPaths(root *tree.TreeNode) int {
	counter = 0
	arr := make([]int, 10)
	dfs(root, arr)
	return counter
}

func dfs(node *tree.TreeNode, temp []int) {
	if node == nil {
		return
	}
	temp[node.Val]++
	if node.Left == nil && node.Right == nil {
		if isPalindrome(temp) {
			counter++
		}
	}
	dfs(node.Left, temp)
	dfs(node.Right, temp)
	temp[node.Val]--
}

func isPalindrome(temp []int) bool {
	c := 0

	for i := 1; i <= 9; i++ {
		if temp[i]%2 != 0 {
			c++
			if c > 1 {
				return false
			}
		}
	}
	return true
}
