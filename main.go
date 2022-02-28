package main

import (
	"fmt"
)

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

func deleteAndEarn(nums []int) (max int) {
	for i := 0; i < len(nums); i++ {
		tempMax := deleteAll(append(make([]int, 0), nums...), i)
		if max < tempMax {
			max = tempMax
		}
	}
	return
}

func deleteAll(nums []int, idx int) int {
	if idx >= len(nums) || len(nums) == 0 {
		return 0
	}
	val := nums[idx]

	for i := idx; i < len(nums); i++ {
		if nums[i] == val-1 {
			nums = append(nums[:i], nums[i+1:]...)
		}
		if nums[i] == val+1 {
			nums = append(nums[:i], nums[i+1:]...)
		}
	}
	val += deleteAll(nums, idx+1)
	return val
}

func summaryRanges(nums []int) []string {
	result := make([]string, 0)

	start, current, end := 0, 0, 1

	for end < len(nums) {
		if nums[end]-nums[current] == 1 {
			end++
			current++
		} else if nums[end]-nums[current] != 1 && current != start {
			result = append(result, fmt.Sprintf("%d->%d", nums[start], nums[current]))
			start = end
			current = end
			end++
		} else if nums[end]-nums[current] != 1 {
			result = append(result, fmt.Sprintf("%d", nums[current]))
			start++
			current++
			end++
		}
	}
	if start != current {
		result = append(result, fmt.Sprintf("%d->%d", nums[start], nums[current]))
	} else if end == len(nums) && start == current {
		result = append(result, fmt.Sprintf("%d", nums[start]))
	}
	return result
}

func main() {
	fmt.Printf("Result: %v\n", summaryRanges([]int{0, 1, 2, 4, 5, 7}))
}
