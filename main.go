package main

import (
	"github.com/vielendanke/preparation/linked_list/medium"
	"log"
)

func main() {
	ll := medium.Constructor()

	ll.AddAtHead(7)
	ll.AddAtHead(2)
	ll.AddAtHead(1)
	ll.AddAtIndex(3, 0)
	ll.DeleteAtIndex(2)
	ll.AddAtHead(6)
	ll.AddAtTail(4)
	log.Println(ll.Get(4))
}
