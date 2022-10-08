package golang_solutions

type treeMap struct {
	left  *treeMap
	right *treeMap
	key   int
	val   int
}

type MyHashMap struct {
	set []*treeMap
	fn  hashFunc
}

func ConstructorMap() MyHashMap {
	return MyHashMap{
		set: make([]*treeMap, 1024),
		fn: func(x int) int {
			return 2041 * x
		},
	}
}

func (this *MyHashMap) Put(key int, value int) {
	idx := this.fn(key) % len(this.set)

	t := this.set[idx]

	this.set[idx] = addToTreeMap(t, key, value)
}

func (this *MyHashMap) Get(key int) int {
	idx := this.fn(key) % len(this.set)

	t := this.set[idx]

	return findInTreeMap(t, key)
}

func (this *MyHashMap) Remove(key int) {
	idx := this.fn(key) % len(this.set)

	t := this.set[idx]

	this.set[idx] = deleteNodeMap(t, key)
}

func deleteNodeMap(root *treeMap, key int) *treeMap {
	if root == nil {
		return root
	}
	if root.key > key {
		root.left = deleteNodeMap(root.left, key)
	} else if root.key < key {
		root.right = deleteNodeMap(root.right, key)
	} else {
		if root.left != nil && root.right != nil {
			rMin := minRightNodeMap(root.right)
			root.key = rMin.key
			root.val = rMin.val
			root.right = deleteNodeMap(root.right, rMin.key)
			return root
		} else if root.left != nil {
			return root.left
		} else {
			return root.right
		}
	}
	return root
}

func minRightNodeMap(root *treeMap) *treeMap {
	if root.left != nil {
		root = root.left
	}
	return root
}

func addToTreeMap(root *treeMap, key, val int) *treeMap {
	if root == nil {
		root = &treeMap{key: key, val: val}
		return root
	}
	if root.key == key {
		root.val = val
		return root
	}
	if root.key > key {
		root.left = addToTreeMap(root.left, key, val)
	}
	if root.key < key {
		root.right = addToTreeMap(root.right, key, val)
	}
	return root
}

func findInTreeMap(root *treeMap, key int) int {
	if root == nil {
		return -1
	}
	if root.key == key {
		return root.val
	} else if root.key > key {
		return findInTreeMap(root.left, key)
	} else {
		return findInTreeMap(root.right, key)
	}
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Put(key,value);
 * param_2 := obj.Get(key);
 * obj.Remove(key);
 */
