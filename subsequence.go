package main

func IsValidSubsequence(array []int, sequence []int) bool {
	// Write your code here.
	// two pointers - first on array, second on sequence
	// move along the array and move pointer accrodingly
	// if match is exists - move pointer on sequence
	// return if sequece is equal len(sequence) - 1
	if len(sequence) > len(array) {
		return false
	}
	pointer := 0
	for i := 0; i < len(array); i++ {
		if array[i] == sequence[pointer] {
			pointer++
		}
		if pointer == len(sequence) {
			return true
		}
	}
	return false
}

func IsValidSubsequence2(array []int, sequence []int) bool {
	arrIdx := 0
	seqIdx := 0
	for arrIdx < len(array) && seqIdx < len(sequence) {
		if array[arrIdx] == sequence[seqIdx] {
			seqIdx++
		}
		arrIdx++
	}
	return seqIdx == len(sequence)
}
