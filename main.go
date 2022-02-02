package main

import (
	"fmt"
	"github.com/vielendanke/preparation/linked_list"
)

func main() {
	l := linked_list.RemoveDuplicatesFromLinkedList3(
		&linked_list.LinkedList{Value: 1, Next: &linked_list.LinkedList{Value: 1, Next: &linked_list.LinkedList{Value: 3, Next: &linked_list.LinkedList{Value: 4, Next: &linked_list.LinkedList{Value: 4, Next: &linked_list.LinkedList{Value: 5,
			Next: &linked_list.LinkedList{Value: 6, Next: &linked_list.LinkedList{Value: 6}}}}}}}})

	for l != nil {
		fmt.Println(l.Value)
		l = l.Next
	}
}
