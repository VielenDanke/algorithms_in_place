package main

import (
	"fmt"
	"github.com/vielendanke/preparation/leetcode/easy"
)

func main() {
	head := &easy.ListNode{Val: 1, Next: &easy.ListNode{Val: 1, Next: &easy.ListNode{Val: 2, Next: &easy.ListNode{Val: 1}}}}

	fmt.Printf("Result: %t\n", easy.IsPalindrome(head))
}
