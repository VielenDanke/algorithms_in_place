package linked_list

type LinkedList struct {
	Value int
	Next  *LinkedList
}

// iterate over linked list
// if next == temp - switch the pointer to next node
// repeat the process until the different number appears

func RemoveDuplicatesFromLinkedList2(linkedList *LinkedList) *LinkedList {
	currentNode := linkedList
	for currentNode != nil {
		nextDistinctNode := currentNode.Next
		for nextDistinctNode != nil && nextDistinctNode.Value == currentNode.Value {
			nextDistinctNode = nextDistinctNode.Next
		}
		currentNode.Next = nextDistinctNode
		currentNode = nextDistinctNode
	}
	return linkedList
}

func RemoveDuplicatesFromLinkedList(linkedList *LinkedList) *LinkedList {
	temp := linkedList

	prevNum := linkedList.Value

	for temp.Next != nil {
		if temp.Next.Value == prevNum {
			temp.Next = temp.Next.Next
		} else {
			temp = temp.Next
			prevNum = temp.Value
		}
	}
	return linkedList
}
