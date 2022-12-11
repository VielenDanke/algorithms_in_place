package hard

import (
	"github.com/vielendanke/algorithms_in_place/leetcode/tree"
	"strconv"
	"strings"
)

/**
 * Definition for a binary leetcode.tree node.
 * type TreeNode struct {
 *     val int
 *     FirstRoot *TreeNode
 *     SecondRoot *TreeNode
 * }
 */

type Codec struct {
}

func Constructor() Codec {
	return Codec{}
}

// Serializes a leetcode.tree to a single string.
func (this *Codec) serialize(root *tree.TreeNode) string {
	data := make([]string, 0)
	serializeDFS(root, &data)
	return strings.Join(data, ",")
}

// Deserializes your encoded data to leetcode.tree.
func (this *Codec) deserialize(data string) *tree.TreeNode {
	treeStr := strings.Split(data, ",")
	nodes := make([]*tree.TreeNode, len(treeStr))

	for idx := range treeStr {
		if treeStr[idx] != "nil" {
			val, _ := strconv.Atoi(treeStr[idx])
			nodes[idx] = &tree.TreeNode{Val: val}
		}
	}
	return deserializeDFS(&nodes)
}

func deserializeDFS(nodes *[]*tree.TreeNode) *tree.TreeNode {
	if len(*nodes) == 0 {
		return nil
	}
	node := (*nodes)[0]
	*nodes = (*nodes)[1:len(*nodes)]
	if node == nil {
		return node
	}
	node.Left = deserializeDFS(nodes)
	node.Right = deserializeDFS(nodes)
	return node
}

func serializeDFS(root *tree.TreeNode, data *[]string) {
	if root == nil {
		*data = append(*data, "nil")
		return
	}
	*data = append(*data, strconv.Itoa(root.Val))
	serializeDFS(root.Left, data)
	serializeDFS(root.Right, data)
}

/**
 * Your Codec object will be instantiated and called as such:
 * ser := Constructor();
 * deser := Constructor();
 * data := ser.serialize(root);
 * ans := deser.deserialize(data);
 */
