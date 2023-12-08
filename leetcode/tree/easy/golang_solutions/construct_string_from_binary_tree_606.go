package golang_solutions

import (
	"bytes"
	"github.com/vielendanke/algorithms_in_place/leetcode/tree"
	"strconv"
)

var leftBracket = []byte("(")
var rightBracket = []byte(")")

// with omitting

func tree2strOmit(root *tree.TreeNode) string {
	buff := bytes.NewBufferString("")

	dfsOmit(buff, root)

	return buff.String()
}

func dfsOmit(buff *bytes.Buffer, node *tree.TreeNode) {
	if node == nil {
		return
	}
	buff.Write([]byte(strconv.Itoa(node.Val)))

	if node.Left != nil {
		buff.Write(leftBracket)
		dfsOmit(buff, node.Left)
		buff.Write(rightBracket)
	}
	if node.Right != nil {
		if node.Left == nil {
			buff.Write(leftBracket)
			buff.Write(rightBracket)
		}
		buff.Write(leftBracket)
		dfsOmit(buff, node.Right)
		buff.Write(rightBracket)
	}
}

// without omitting

func tree2str(root *tree.TreeNode) string {
	buff := bytes.NewBufferString("")

	dfs(buff, root)

	return buff.String()
}

func dfs(buff *bytes.Buffer, node *tree.TreeNode) {
	if node.Left == nil && node.Right == nil {
		buff.Write([]byte(strconv.Itoa(node.Val)))
		return
	}
	buff.Write([]byte(strconv.Itoa(node.Val)))
	if node.Left != nil {
		buff.Write([]byte(leftBracket))
		dfs(buff, node.Left)
		buff.Write([]byte(rightBracket))
	}
	if node.Right != nil {
		buff.Write([]byte(leftBracket))
		dfs(buff, node.Right)
		buff.Write([]byte(rightBracket))
	}
}
