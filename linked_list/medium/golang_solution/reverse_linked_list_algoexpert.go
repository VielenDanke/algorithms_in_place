package golang_solution

func reverseLinkedList(head *LinkedList) *LinkedList {
	var previousNode, currentNode *LinkedList = nil, head

	for currentNode != nil {
		nextNode := currentNode.Next
		currentNode.Next = previousNode
		previousNode = currentNode
		currentNode = nextNode
	}
	return previousNode
}

func reverseLinkedListSecond(head *LinkedList) *LinkedList {
	array := make([]int, 0)

	temp := head

	for temp != nil {
		array = append(array, temp.Value)
		temp = temp.Next
	}
	head.Value = array[len(array)-1]

	temp = head

	for i := len(array) - 2; i >= 0; i-- {
		temp.Next.Value = array[i]
		temp = temp.Next
	}
	return head
}
