package medium

type Node struct {
	Next *Node
	Val  int
}

type MyLinkedList struct {
	head *Node
	size int
}

func Constructor() MyLinkedList {
	return MyLinkedList{}
}

func (this *MyLinkedList) Get(index int) int {
	if index > this.size {
		return -1
	}

	curr := this.head
	var count int
	for curr != nil {
		if count == index {
			break
		}
		count++
		curr = curr.Next
	}

	if curr != nil {
		return curr.Val
	}

	return -1
}

func (this *MyLinkedList) AddAtHead(val int) {
	if this.head == nil {
		this.head = &Node{Val: val}
		this.size++
		return
	}

	node := &Node{Val: val}
	node.Next = this.head
	this.head = node
	this.size++
}

func (this *MyLinkedList) AddAtTail(val int) {
	if this.head == nil {
		this.AddAtHead(val)
		return
	}

	curr := this.head
	for curr.Next != nil {
		curr = curr.Next
	}

	curr.Next = &Node{Val: val}
	this.size++
}

func (this *MyLinkedList) AddAtIndex(index int, val int) {
	if index > this.size {
		return
	} else if index == this.size {
		this.AddAtTail(val)
		return
	} else if index == 0 {
		this.AddAtHead(val)
		return
	}

	var count int
	curr := this.head
	for curr != nil {
		if count == index-1 {
			next := curr.Next
			curr.Next = &Node{Val: val}
			curr.Next.Next = next
			break
		}
		curr = curr.Next
		count++
	}
	this.size++
}

func (this *MyLinkedList) DeleteAtIndex(index int) {
	if index > this.size || index < 0 {
		return
	}

	if index == 0 {
		this.head = this.head.Next
		this.size--
		return
	}

	var count int
	curr := this.head
	for curr != nil && curr.Next != nil {
		if count == index-1 {
			curr.Next = curr.Next.Next
			this.size--
			break
		}
		count++
		curr = curr.Next
	}
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * obj := Constructor();
 * param_1 := obj.Get(index);
 * obj.AddAtHead(val);
 * obj.AddAtTail(val);
 * obj.AddAtIndex(index,val);
 * obj.DeleteAtIndex(index);
 */
