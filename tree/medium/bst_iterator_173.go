package medium

import "github.com/vielendanke/algorithms_in_place/tree"

type BSTIterator struct {
	nodes []int
}

func Constructor(root *tree.TreeNode) BSTIterator {
	nodes := make([]int, 0)
	tree.InOrderTraversal(root, &nodes)
	return BSTIterator{nodes: nodes}
}

func (this *BSTIterator) Next() int {
	if len(this.nodes) <= 0 {
		return -1
	}
	var next int
	next, this.nodes = this.nodes[0], this.nodes[1:]
	return next
}

func (this *BSTIterator) HasNext() bool {
	return len(this.nodes) > 0
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * obj := Constructor(root);
 * param_1 := obj.next();
 * param_2 := obj.HasNext();
 */
