package hard

type FreqStack struct {
	stack      []int
	max        []int
	nums       map[int]int
	currentMax int
}

func Constructor() FreqStack {
	return FreqStack{stack: make([]int, 0), max: make([]int, 0), nums: make(map[int]int)}
}

func (this *FreqStack) Push(val int) {
	this.stack = append(this.stack, val)
	this.nums[val]++
	this.max = append(this.max, this.nums[val])
	if this.nums[val] > this.currentMax {
		this.currentMax = this.nums[val]
	}
}

func (this *FreqStack) Pop() int {
	defer func() {
		this.currentMax = 0
		for i := len(this.max) - 1; i >= 0; i-- {
			if this.currentMax < this.max[i] {
				this.currentMax = this.max[i]
			}
		}
	}()
	for i := len(this.stack) - 1; i >= 0; i-- {
		if this.max[i] == this.currentMax {
			numToReturn := this.stack[i]
			this.nums[numToReturn]--
			this.stack = append(this.stack[:i], this.stack[i+1:]...)
			this.max = append(this.max[:i], this.max[i+1:]...)
			return numToReturn
		}
	}
	return -1
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Push(val);
 * param_2 := obj.Pop();
 */
