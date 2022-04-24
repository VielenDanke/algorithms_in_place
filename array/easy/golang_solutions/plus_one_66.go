package golang_solutions

/*
129

Initialization:
First step if A[A.length - 1] < 8 - A[A.length - 1] = A[A.length - 1] + 1
Iteration:
If A[A.length - 1] = 9 -> A[A.length - 1] = 10 -> A[A.length - 1] = 0 -> A[A.length - 2] = 3
End:
If we reach bottom index or sum < 10 -> return from recursion
*/

func plusOne(digits []int) []int {
	return plusOneWithRemainder(digits, len(digits)-1, 1)
}

func plusOneWithRemainder(digits []int, currentIdx int, remainder int) []int {
	if currentIdx < 0 {
		arr := make([]int, 1)
		arr[0] = 1
		for i := 0; i < len(digits); i++ {
			arr = append(arr, digits[i])
		}
		return arr
	}
	sum := digits[currentIdx] + remainder
	if sum >= 10 {
		digits[currentIdx] = 0
		return plusOneWithRemainder(digits, currentIdx-1, 1)
	} else {
		digits[currentIdx] = sum
	}
	return digits
}

// ------------------------------------------------------------------------------------------

func plusOneIterative(digits []int) []int {
	currentIdx := len(digits) - 1
	remainder := 1

	for currentIdx >= 0 && remainder != 0 {
		sum := digits[currentIdx] + 1

		if sum >= 10 {
			digits[currentIdx] = 0
			remainder = 1
			currentIdx--
		} else {
			digits[currentIdx] = sum
			remainder = 0
		}
	}
	if remainder != 0 {
		arr := make([]int, 1)
		arr[0] = 1
		for _, v := range digits {
			arr = append(arr, v)
		}
		return arr
	}
	return digits
}
