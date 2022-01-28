package main

import "fmt"

func main() {
	tree := &BST{
		Left:  &BST{Value: 5, Left: &BST{Value: 2, Left: &BST{Value: 1}}, Right: &BST{Value: 5}},
		Right: &BST{Value: 15, Left: &BST{Value: 13, Right: &BST{Value: 14}}, Right: &BST{Value: 22}},
		Value: 10,
	}
	fmt.Println(tree.FindClosestValue2(12))
}
