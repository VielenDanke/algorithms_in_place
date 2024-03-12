package golang_solution

import "github.com/vielendanke/algorithms_in_place/leetcode/linked_list"

/*
impl Solution {
    pub fn remove_zero_sum_sublists(mut head: Option<Box<ListNode>>) -> Option<Box<ListNode>> {
        let mut stack = vec![];

        while head.is_some() {
            let current_node = head.unwrap();
            if current_node.val == 0 {} else if stack.is_empty() {
                stack.push(current_node.val);
            } else {
                let idx = Solution::extract_sum_index(&stack, current_node.val);
                if idx >= 0 {
                    stack = stack[0..(idx as usize)].to_vec();
                } else {
                    stack.push(current_node.val);
                }
            }
            head = current_node.next;
        }
        if stack.is_empty() {
            return None;
        }
        Solution::re_inject_into_linked_list(stack)
    }

    fn re_inject_into_linked_list(stack: Vec<i32>) -> Option<Box<ListNode>> {
        let mut new = ListNode::new(0);
        let mut n = &mut new;

        for val in stack.into_iter().map(ListNode::new).map(Box::new) {
            n.next = Some(val);
            n = n.next.as_mut()?;
        }
        n.next = None;
        new.next
    }

    fn extract_sum_index(stack: &Vec<i32>, current_val: i32) -> i32 {
        let mut temp_sum = 0;
        let mut idx = -1;

        for (i, v) in stack.iter().enumerate().rev() {
            temp_sum += *v;
            if temp_sum + current_val == 0 {
                idx = i as i32;
                break;
            }
        }
        idx
    }
}
*/

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func removeZeroSumSublists(head *linked_list.ListNode) *linked_list.ListNode {
	stack := make([]int, 0)

	temp := head

	for temp != nil {
		if temp.Val == 0 {
			// do nothing
		} else if len(stack) == 0 {
			stack = append(stack, temp.Val)
		} else {
			idx := extractSumIndex(stack, temp.Val)
			if idx >= 0 {
				stack = stack[0:idx]
			} else {
				stack = append(stack, temp.Val)
			}
		}
		temp = temp.Next
	}
	if len(stack) == 0 {
		return nil
	}
	return reInjectIntoLinkedList(head, stack)
}

func reInjectIntoLinkedList(head *linked_list.ListNode, stack []int) *linked_list.ListNode {
	temp := head
	for i, v := range stack {
		head.Val = v
		if i != len(stack)-1 {
			head = head.Next
		}
	}
	head.Next = nil
	return temp
}

func extractSumIndex(stack []int, currentVal int) int {
	tempSum, idx := 0, -1
	for i := len(stack) - 1; i >= 0; i-- {
		tempSum += stack[i]
		if tempSum+currentVal == 0 {
			idx = i
			break
		}
	}
	return idx
}
