package medium

import (
	"fmt"
	"github.com/vielendanke/preparation/tree"
)

type BSTIterator struct {
	array      []int
	currentIdx int
}

func BSTConstructor(root *tree.TreeNode) BSTIterator {
	array := make([]int, 0)
	tree.DFS(root, &array)
	fmt.Printf("%v", array)
	return BSTIterator{array: array}
}

func (this *BSTIterator) Next() int {
	defer func() {
		this.currentIdx++
	}()
	return this.array[this.currentIdx]
}

func (this *BSTIterator) HasNext() bool {
	return this.currentIdx < len(this.array)
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * obj := Constructor(root);
 * param_1 := obj.Next();
 * param_2 := obj.HasNext();
 */
