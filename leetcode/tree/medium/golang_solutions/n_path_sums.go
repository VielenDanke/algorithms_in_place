package golang_solutions

import "github.com/vielendanke/algorithms_in_place/leetcode/tree"

func PathSum(root *tree.TreeNode, targetSum int) [][]int {
	if root == nil {
		return nil
	}
	if root.Left == nil && root.Right == nil {
		if targetSum-root.Val == 0 {
			return append(make([][]int, 0), []int{root.Val})
		}
		return nil
	}
	result := make([][]int, 0)
	leftArr := PathSum(root.Left, targetSum-root.Val)
	if leftArr != nil {
		temp := []int{root.Val}
		for idx := range leftArr {
			leftArr[idx] = append(temp, leftArr[idx]...)
		}
		result = append(result, leftArr...)
	}
	rightArr := PathSum(root.Right, targetSum-root.Val)
	if rightArr != nil {
		temp := []int{root.Val}
		for idx := range rightArr {
			rightArr[idx] = append(temp, rightArr[idx]...)
		}
		result = append(result, rightArr...)
	}
	return result
}
