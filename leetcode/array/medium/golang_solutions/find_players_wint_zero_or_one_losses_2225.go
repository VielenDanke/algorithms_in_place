package golang_solutions

func findWinners(matches [][]int) [][]int {
	scores := [100001]int{}

	for _, match := range matches {
		if scores[match[0]] == 0 {
			scores[match[0]] = 1
		}
		if scores[match[1]] == 0 {
			scores[match[1]] = 1
		}
		scores[match[1]]++
	}
	zeros := make([]int, 0)
	ones := make([]int, 0)

	for player, score := range scores {
		if score == 1 {
			zeros = append(zeros, player)
		} else if score == 2 {
			ones = append(ones, player)
		}
	}
	return [][]int{zeros, ones}
}

func findWinnersMap(matches [][]int) [][]int {
	wins := make(map[int]int)
	loses := make(map[int]int)
	maxPlayer := 0

	for _, match := range matches {
		wins[match[0]]++
		loses[match[1]]++
		maxPlayer = max(maxPlayer, match[0], match[1])
	}
	result := make([][]int, 2)
	result[0] = make([]int, 0)
	result[1] = make([]int, 0)

	for player := 0; player <= maxPlayer; player++ {
		_, isWin := wins[player]
		playerLose, isLose := loses[player]
		if isWin && !isLose {
			result[0] = append(result[0], player)
		} else if isLose && playerLose == 1 {
			result[1] = append(result[1], player)
		}
	}
	return result
}

func max(ints ...int) (max int) {
	for _, v := range ints {
		if v > max {
			max = v
		}
	}
	return
}
