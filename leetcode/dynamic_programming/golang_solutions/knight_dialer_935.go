package golang_solutions

// going through next numbers of the current position instead of all possible directions
// for example if we put knight on 0 number, next possible moves is 4, 6 numbers on the dial
// cache every successful combination (n == 1)
const mod = 10e8 + 7

var dp = [5001][10]int{}
var nextMoveNumbers = [][]int{{4, 6}, {6, 8}, {7, 9}, {4, 8}, {0, 3, 9}, {}, {0, 1, 7}, {2, 6}, {1, 3}, {2, 4}}

func knightDialer(n int) int {
	return backtrackKnightDialer(n, []int{0, 1, 2, 3, 4, 5, 6, 7, 8, 9})
}

func backtrackKnightDialer(n int, nextNumbers []int) (counter int) {
	if n == 1 {
		return len(nextNumbers)
	}
	for _, nextNumber := range nextNumbers {
		current := dp[n][nextNumber]
		if current == 0 {
			current = backtrackKnightDialer(n-1, nextMoveNumbers[nextNumber])
			dp[n][nextNumber] = current
		}
		counter += current
		counter %= mod
	}
	return
}

// -------------------------------------------------------------------------------------------

const rowLength = 4
const colLength = 3

var nextMoves = [][]int{{-1, -2}, {1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}}

func knightDialerBruteForce(n int) int {
	dial := make([][]int, rowLength)
	for i := 0; i < rowLength; i++ {
		dial[i] = make([]int, colLength)
	}
	dial[rowLength-1][0], dial[rowLength-1][2] = -1, -1
	count := 0
	for i := 0; i < rowLength; i++ {
		for j := 0; j < colLength; j++ {
			if dial[i][j] != -1 {
				count += backtrackKnightDialerBruteForce(n-1, i, j, dial)
			}
		}
	}
	return count
}

func backtrackKnightDialerBruteForce(n, row, col int, dial [][]int) int {
	if n == 0 {
		return 1
	}
	counter := 0
	for _, v := range nextMoves {
		nextRow, nextCol := row+v[0], col+v[1]
		if !isValidPosition(dial, nextRow, nextCol) {
			continue
		}
		counter += backtrackKnightDialerBruteForce(n-1, nextRow, nextCol, dial)
	}
	return counter
}

func isValidPosition(dial [][]int, row, col int) bool {
	return row >= 0 && col >= 0 && row < rowLength && col < colLength && dial[row][col] != -1
}
