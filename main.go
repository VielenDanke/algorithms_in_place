package main

import (
	"fmt"
)

type BST struct {
	Value int

	Left  *BST
	Right *BST
}

func (tree BST) String() string {
	return fmt.Sprintf("%v\n", tree.inOrderTraversal(make([]int, 0)))
}

func (tree BST) inOrderTraversal(array []int) []int {
	if tree.Left != nil {
		array = tree.Left.inOrderTraversal(array)
	}
	array = append(array, tree.Value)
	if tree.Right != nil {
		array = tree.Right.inOrderTraversal(array)
	}
	return array
}

func MinHeightBST(array []int) *BST {
	return recursive(array, nil, 0, len(array)-1)
}

func recursive(array []int, node *BST, start, end int) *BST {
	if end < start {
		return nil
	}
	middle := (start + end) / 2
	val := array[middle]
	if node == nil {
		node = &BST{Value: val}
	} else {
		node.Insert(val)
	}
	recursive(array, node, start, middle-1)
	recursive(array, node, middle+1, end)
	return node
}

func (tree *BST) Insert(value int) *BST {
	if value < tree.Value {
		if tree.Left == nil {
			tree.Left = &BST{Value: value}
		} else {
			tree.Left.Insert(value)
		}
	} else {
		if tree.Right == nil {
			tree.Right = &BST{Value: value}
		} else {
			tree.Right.Insert(value)
		}
	}
	return tree
}

func main() {
	root := MinHeightBST([]int{1, 2, 5, 7, 10, 13, 14, 15, 22})
	fmt.Printf("Result: %v\n", root)
}
