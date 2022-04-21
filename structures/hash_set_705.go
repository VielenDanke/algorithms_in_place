package structures

type tree struct {
	left  *tree
	right *tree
	val   int
}

type hashFunc func(x int) int

type MyHashSet struct {
	set []*tree
	fn  hashFunc
}

func Constructor() MyHashSet {
	return MyHashSet{set: make([]*tree, 1024), fn: func(x int) int {
		return x * 2041
	}}
}

func (this *MyHashSet) Add(key int) {
	idx := this.fn(key) % len(this.set)

	t := this.set[idx]

	this.set[idx] = addToTree(t, key)
}

func (this *MyHashSet) Remove(key int) {
	idx := this.fn(key) % len(this.set)

	t := this.set[idx]

	this.set[idx] = deleteNodeVal(t, key)
}

func (this *MyHashSet) Contains(key int) bool {
	idx := this.fn(key) % len(this.set)

	t := this.set[idx]

	return findInTree(t, key)
}

func deleteNodeVal(root *tree, key int) *tree {
	if root == nil {
		return root
	}
	if root.val > key {
		root.left = deleteNodeVal(root.left, key)
	} else if root.val < key {
		root.right = deleteNodeVal(root.right, key)
	} else {
		if root.left != nil && root.right != nil {
			rMin := minRightNode(root.right)
			root.val = rMin
			root.right = deleteNodeVal(root.right, rMin)
			return root
		} else if root.left != nil {
			return root.left
		} else {
			return root.right
		}
	}
	return root
}

func minRightNode(root *tree) int {
	if root.left != nil {
		root = root.left
	}
	return root.val
}

func addToTree(root *tree, val int) *tree {
	if root == nil {
		root = &tree{val: val}
		return root
	}
	if root.val == val {
		return root
	}
	if root.val > val {
		root.left = addToTree(root.left, val)
	}
	if root.val < val {
		root.right = addToTree(root.right, val)
	}
	return root
}

func findInTree(root *tree, val int) bool {
	if root == nil {
		return false
	}
	if root.val == val {
		return true
	} else if root.val > val {
		return findInTree(root.left, val)
	} else {
		return findInTree(root.right, val)
	}
}
