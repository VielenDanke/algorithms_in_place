package golang_solutions

type MyQueue struct {
	first  []int
	second []int
}

func MyQueueConstructor() MyQueue {
	return MyQueue{make([]int, 0), make([]int, 0)}
}

func (q *MyQueue) Push(x int) {
	q.first = append(q.first, x)
}

func (q *MyQueue) Pop() (elem int) {
	if len(q.second) > 0 {
		elem = q.second[len(q.second)-1]
	} else {
		elem = q.moveAndReturnNextElement()
	}
	q.second = q.second[:len(q.second)-1]
	return
}

func (q *MyQueue) Peek() (elem int) {
	if len(q.second) > 0 {
		return q.second[len(q.second)-1]
	}
	return q.moveAndReturnNextElement()
}

func (q *MyQueue) Empty() bool {
	return len(q.first) == 0 && len(q.second) == 0
}

func (q *MyQueue) moveAndReturnNextElement() int {
	for len(q.first) > 0 {
		q.second = append(q.second, q.first[len(q.first)-1])
		q.first = q.first[:len(q.first)-1]
	}
	return q.second[len(q.second)-1]
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Push(x);
 * param_2 := obj.Pop();
 * param_3 := obj.Peek();
 * param_4 := obj.Empty();
 */
