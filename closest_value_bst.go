package main

type BST struct {
	Value int

	Left  *BST
	Right *BST
}

func abcdiff(a, b int) int {
	if a > b {
		return a - b
	}
	return b - a
}

func (tree *BST) FindClosestValue(target int) (closestValue int) {
	// ask if target is always positive
	// could we found exactly match?
	// could we assume that first two children always exists?
	node := tree

	closestValue = node.Value

	for node != nil {
		if abcdiff(target, closestValue) > abcdiff(target, node.Value) {
			closestValue = node.Value
		}
		if target < node.Value {
			node = node.Left
		} else if target > node.Value {
			node = node.Right
		} else {
			return
		}
	}
	return
}

func (tree *BST) FindClosestValue2(target int) (closestValue int) {
	return tree.findClosestValue(target, tree.Value)
}

func (tree *BST) findClosestValue(target int, closestValue int) int {
	if abcdiff(target, closestValue) > abcdiff(target, tree.Value) {
		closestValue = tree.Value
	}
	if target < tree.Value && tree.Left != nil {
		return tree.Left.findClosestValue(target, closestValue)
	} else if target > tree.Value && tree.Right != nil {
		return tree.Right.findClosestValue(target, closestValue)
	}
	return closestValue
}
