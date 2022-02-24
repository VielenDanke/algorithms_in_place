package main

import "fmt"

var maxSum int
var maxDepth int

type BinaryTree struct {
	Value int

	Left  *BinaryTree
	Right *BinaryTree
}

type Edge struct {
	Depth int
	Sum   int
	Tree  *BinaryTree
}

func BinaryTreeDiameter(tree *BinaryTree) int {
	bottomUp(tree)
	return maxDepth
}

func bottomUp(node *BinaryTree) (int, int) {
	if node.Left == nil && node.Right == nil {
		return node.Value, 0
	}
	var sum, depth int
	if node.Left != nil {
		leftVal, leftDepth := bottomUp(node.Left)
		sum += leftVal
		depth += leftDepth
	}
	if node.Right != nil {
		rightVal, rightDepth := bottomUp(node.Right)
		sum += rightVal
		depth += rightDepth
	}
	sum += node.Value
	depth++
	if sum > maxSum {
		maxSum = sum
		maxDepth = depth
	}
	return sum, depth
}

func merge(nums1 []int, m int, nums2 []int, n int) {
	firstIdx, secondIdx := 0, 0

	nums1 = nums1[:m]
	nums2 = nums2[:n]

	for firstIdx < m && secondIdx < n {
		if nums1[firstIdx] > nums2[secondIdx] {
			nums1[firstIdx], nums2[secondIdx] = nums2[secondIdx], nums1[firstIdx]
			secondIdx++
		} else {
			firstIdx++
		}
	}
	for _, v := range nums2 {
		nums1 = append(nums1, v)
	}
}

func main() {
	f := []int{1, 2, 3, 0, 0, 0}
	s := []int{2, 5, 6}
	merge(f, 3, s, len(s))
	fmt.Println(f)
}
