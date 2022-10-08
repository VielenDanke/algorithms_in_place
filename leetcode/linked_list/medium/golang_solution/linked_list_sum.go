package golang_solution

import "fmt"

type LinkedList struct {
	Value int
	Next  *LinkedList
}

func SumOfLinkedLists(linkedListOne *LinkedList, linkedListTwo *LinkedList) *LinkedList {
	newLinkedList := &LinkedList{Value: 0}
	currentNode := newLinkedList
	carry := 0

	nodeOne := linkedListOne
	nodeTwo := linkedListTwo

	for nodeOne != nil || nodeTwo != nil || carry != 0 {
		var valueOne, valueTwo int
		if nodeOne != nil {
			valueOne = nodeOne.Value
		}
		if nodeTwo != nil {
			valueTwo = nodeTwo.Value
		}
		sumOfValues := valueOne + valueTwo + carry

		newValue := sumOfValues % 10
		newNode := &LinkedList{Value: newValue}
		currentNode.Next = newNode
		currentNode = newNode

		carry = sumOfValues / 10
		if nodeOne != nil {
			nodeOne = nodeOne.Next
		}
		if nodeTwo != nil {
			nodeTwo = nodeTwo.Next
		}
	}
	return newLinkedList.Next
}

func SumOfLinkedLists2(linkedListOne *LinkedList, linkedListTwo *LinkedList) *LinkedList {
	oneStack, twoStack := createStack(linkedListOne), createStack(linkedListTwo)
	oneSum, twoSum := calculateSum(oneStack), calculateSum(twoStack)
	sum := oneSum + twoSum
	return createListFromSum(sum)
}

func createListFromSum(sum int) *LinkedList {
	str := fmt.Sprintf("%d", sum)
	head := &LinkedList{Value: int(str[len(str)-1]) - 48}
	current := head
	for i := len(str) - 2; i >= 0; i-- {
		current.Next = &LinkedList{Value: int(str[i]) - 48}
		current = current.Next
	}
	return head
}

func createStack(ll *LinkedList) []int {
	stack := make([]int, 0)
	for ll != nil {
		stack = append(stack, ll.Value)
		ll = ll.Next
	}
	return stack
}

func calculateSum(stack []int) int {
	sum, top := 0, 0
	for len(stack) > 0 {
		top, stack = stack[len(stack)-1], stack[:len(stack)-1]
		sum += increaseNumber(len(stack)) * top
	}
	return sum
}

func increaseNumber(n int) int {
	increaseNum := 1
	for i := 0; i < n; i++ {
		increaseNum *= 10
	}
	return increaseNum
}
