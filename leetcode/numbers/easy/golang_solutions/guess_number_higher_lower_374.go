package golang_solutions

/**
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * func guess(num int) int;
 */

func guess(num int) int {
	return -1
}

func guessNumber(n int) int {
	min, max := 1, n
	for {
		middle := min + (max-min)/2

		temp := guess(middle)

		if temp == 0 {
			return middle
		} else if temp > 0 {
			min = middle + 1
		} else {
			max = middle - 1
		}
	}
}
