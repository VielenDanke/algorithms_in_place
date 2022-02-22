package main

import (
	"fmt"
	"sort"
)

type ListNode struct {
	Val  int
	Next *ListNode
}

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func sortedListToBST(head *ListNode) *TreeNode {
	if head == nil {
		return nil
	}
	arr := make([]int, 0)

	for head != nil {
		arr = append(arr, head.Val)
		head = head.Next
	}
	if len(arr) == 1 {
		return &TreeNode{Val: arr[0]}
	}
	return recursiveCreateTree(arr, 0, len(arr)-1)
}

func recursiveCreateTree(arr []int, start, end int) *TreeNode {
	if end < start {
		return nil
	}
	middle := (start + end) / 2
	node := &TreeNode{Val: arr[middle]}
	node.Left = recursiveCreateTree(arr, start, middle-1)
	node.Right = recursiveCreateTree(arr, middle+1, end)
	return node
}

func SpiralTraverse(array [][]int) []int {
	// Write your code here.
	result := make([]int, 0)
	runThrough(array, &result)
	return result
}

func runThrough(array [][]int, result *[]int) {
	if len(array) == 1 {
		for _, v := range array[0] {
			*result = append(*result, v)
		}
		return
	}
	if len(array) == 0 {
		return
	}
	for i := 0; i < len(array[0]); i++ {
		*result = append(*result, array[0][i])
	}
	array = array[1:]
	for i, j := 0, len(array[0])-1; i < len(array); i++ {
		*result = append(*result, array[i][j])
		array[i] = array[i][:j]
	}
	for i, j := len(array)-1, len(array[0])-1; j >= 0; j-- {
		*result = append(*result, array[i][j])
	}
	array = array[:len(array)-1]
	for i, j := len(array)-1, 0; i >= 0; i-- {
		*result = append(*result, array[i][j])
		array[i] = array[i][j+1:]
	}
	runThrough(array, result)
}

func majorityElement(nums []int) int {
	sort.Ints(nums)

	amount := 1
	currentElem := nums[0]

	for i := 1; i < len(nums); i++ {
		if currentElem != nums[i] {
			amount = 1
			currentElem = nums[i]
		} else {
			amount++
			if amount > len(nums)/2 {
				return currentElem
			}
		}
	}

	return -1
}

type node struct {
	row    int
	column int
}

func findDiagonalOrder(mat [][]int) []int {
	result := make([]int, 0)

	queue := make([]*node, 0)

	queue = append(queue, &node{row: 0, column: 0})
	visited := make(map[string]interface{})
	visited[createKey(0, 0)] = nil

	var elem *node

	for len(queue) > 0 {
		elem, queue = queue[0], queue[1:]
		result = append(result, mat[elem.row][elem.column])
		if elem.row+1 >= len(mat) && elem.column+1 >= len(mat[0]) {
			break
		}
		if elem.column+1 < len(mat[0]) {
			if _, ok := visited[createKey(elem.row, elem.column+1)]; !ok {
				visited[createKey(elem.row, elem.column+1)] = nil
				queue = append(queue, &node{row: elem.row, column: elem.column + 1})
			}
		}
		if elem.row+1 < len(mat) {
			if _, ok := visited[createKey(elem.row+1, elem.column)]; !ok {
				visited[createKey(elem.row+1, elem.column)] = nil
				queue = append(queue, &node{row: elem.row + 1, column: elem.column})
			}
		}
	}
	return result
}

func createKey(row, column int) string {
	return fmt.Sprintf("%d-%d", row, column)
}

func titleToNumber(columnTitle string) (sum int) {
	n := len(columnTitle)
	if n == 0 {
		return -1
	}
	if n == 1 {
		return int(columnTitle[0]) - 64
	}
	power := 1
	for i := n - 1; i >= 0; i-- {
		t := int(columnTitle[i]) - 64
		sum += t * power
		power *= 26
	}
	return
}

func main() {
}

func inOrderTraversal(node *TreeNode) {
	if node == nil {
		return
	}
	inOrderTraversal(node.Left)
	fmt.Println(node.Val)
	inOrderTraversal(node.Right)
}
