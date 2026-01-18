package golang_solutions

func largestMagicSquare(grid [][]int) int {
	m, n := len(grid), len(grid[0])
	rowSum := make([][]int, m)
	for i := 0; i < m; i++ {
		rowSum[i] = make([]int, n)
		rowSum[i][0] = grid[i][0]
		for j := 1; j < n; j++ {
			rowSum[i][j] = rowSum[i][j-1] + grid[i][j]
		}
	}
	colSum := make([][]int, m)
	for i := 0; i < m; i++ {
		colSum[i] = make([]int, n)
	}
	for j := 0; j < n; j++ {
		colSum[0][j] = grid[0][j]
		for i := 1; i < m; i++ {
			colSum[i][j] = colSum[i-1][j] + grid[i][j]
		}
	}

	for edge := min(m, n); edge >= 2; edge-- {
		for i := 0; i+edge <= m; i++ {
			for j := 0; j+edge <= n; j++ {
				stdSum := rowSum[i][j+edge-1]
				if j > 0 {
					stdSum -= rowSum[i][j-1]
				}
				check := true
				for ii := i + 1; ii < i+edge; ii++ {
					sum := rowSum[ii][j+edge-1]
					if j > 0 {
						sum -= rowSum[ii][j-1]
					}
					if sum != stdSum {
						check = false
						break
					}
				}
				if !check {
					continue
				}
				for jj := j; jj < j+edge; jj++ {
					sum := colSum[i+edge-1][jj]
					if i > 0 {
						sum -= colSum[i-1][jj]
					}
					if sum != stdSum {
						check = false
						break
					}
				}
				if !check {
					continue
				}
				d1, d2 := 0, 0
				for k := 0; k < edge; k++ {
					d1 += grid[i+k][j+k]
					d2 += grid[i+k][j+edge-1-k]
				}
				if d1 == stdSum && d2 == stdSum {
					return edge
				}
			}
		}
	}
	return 1
}

func largestMagicSquareBruteForce(grid [][]int) int {
	if len(grid) == 0 || len(grid[0]) == 0 {
		return 0
	}

	max := 1

	maxFunc := func(a, b int) int {
		if a > b {
			return a
		}
		return b
	}

	for i := 0; i < len(grid); i++ {
		for j := 0; j < len(grid[i]); j++ {
			k := 1

		loop:
			for i+k < len(grid) && j+k < len(grid[i+k]) {
				storage := make(map[int]interface{})

				for iNext := i; iNext <= i+k; iNext++ {
					sum := 0
					for jNext := j; jNext <= j+k; jNext++ {
						sum += grid[iNext][jNext]
					}
					storage[sum] = nil

					if len(storage) == 2 {
						k++
						continue loop
					}
				}
				for jNext := j; jNext <= j+k; jNext++ {
					sum := 0
					for iNext := i; iNext <= i+k; iNext++ {
						sum += grid[iNext][jNext]
					}
					storage[sum] = nil

					if len(storage) == 2 {
						k++
						continue loop
					}
				}
				iNext, jNext, sum := i, j, 0

				for iNext <= i+k && jNext <= j+k {
					sum += grid[iNext][jNext]

					iNext++
					jNext++
				}
				storage[sum] = nil

				if len(storage) == 2 {
					k++
					continue loop
				}

				iNext, jNext, sum = i, j+k, 0

				for iNext <= i+k && jNext >= j {
					sum += grid[iNext][jNext]

					iNext++
					jNext--
				}
				storage[sum] = nil

				if len(storage) == 2 {
					k++
					continue loop
				}

				if len(storage) == 1 {
					max = maxFunc(k+1, max)
				}

				k++
			}
		}
	}
	return max
}
