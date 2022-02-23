package medium

import "fmt"

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

func recursiveBetter(array []int, start, end int) *BST {
	if end < start {
		return nil
	}
	midIdx := (start + end) / 2
	val := array[midIdx]
	node := &BST{Value: val}
	node.Left = recursiveBetter(array, start, midIdx-1)
	node.Right = recursiveBetter(array, midIdx+1, end)
	return node
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
