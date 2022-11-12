package golang_solutions

// https://www.hackerrank.com/challenges/sherlock-and-squares/problem

func squares(a int32, b int32) int32 {
	// Write your code here
	var numOfSquares int32
	x := 1
	for int32(x*x) < a {
		x++
	}
	for int32(x*x) <= b {
		numOfSquares++
		x++
	}
	return numOfSquares
}
