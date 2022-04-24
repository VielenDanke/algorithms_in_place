package golang_solutions

const HomeTeamWon = 1

func TournamentWinner(competitions [][]string, results []int) (winner string) {
	// homeTeam - 0, awayTeam - 1 (competitions)
	// 1 - homeTeam won, 0 - awayTeam won (results)
	/*
		map to calculate the points
		for i in competitions:

			if i[0] not in map:
				map[i[0]]
			if i[1] not in map:
				map[i[1]]

	*/
	output := make(map[string]int)

	for k, v := range competitions {
		homeTeam, awayTeam := v[0], v[1]
		winningTeam := ""

		if _, ok := output[homeTeam]; !ok {
			output[homeTeam] = 0
		}
		if _, ok := output[awayTeam]; !ok {
			output[awayTeam] = 0
		}
		if results[k] == HomeTeamWon {
			output[homeTeam] += 3
			winningTeam = homeTeam
		} else {
			output[awayTeam] += 3
			winningTeam = awayTeam
		}
		if output[winningTeam] > output[winner] {
			winner = winningTeam
		}
	}
	return winner
}
