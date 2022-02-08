package medium

var preorderIdx = 0
var inorderIdxMap = make(map[int]int)

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func BuildTree(preorder []int, inorder []int) *TreeNode {
	for i := 0; i < len(inorder); i++ {
		inorderIdxMap[inorder[i]] = i
	}
	return arrayToTree(preorder, 0, len(preorder)-1)
}

func arrayToTree(preorder []int, left, right int) *TreeNode {
	if left > right {
		return nil
	}
	rootVal := preorder[preorderIdx]
	preorderIdx++
	root := &TreeNode{Val: rootVal}
	root.Left = arrayToTree(preorder, left, inorderIdxMap[rootVal]-1)
	root.Right = arrayToTree(preorder, inorderIdxMap[rootVal]+1, right)
	return root
}
