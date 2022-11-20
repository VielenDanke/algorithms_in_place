package golang_solutions

type NumArray struct {
	nums []int
}

func NumArrayConstructor(nums []int) NumArray {
	return NumArray{nums: nums}
}

func (na *NumArray) SumRange(left int, right int) int {
	sum := 0
	for i := left; i <= right; i++ {
		sum += na.nums[i]
	}
	return sum
}

/**
 * Your NumArray object will be instantiated and called as such:
 * obj := Constructor(nums);
 * param_1 := obj.SumRange(left,right);
 */
