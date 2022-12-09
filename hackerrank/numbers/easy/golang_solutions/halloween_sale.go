package golang_solutions

// https://www.hackerrank.com/challenges/halloween-sale/problem

func howManyGames(p int32, d int32, m int32, s int32) (buys int32) {
	for s >= m && s-p >= 0 {
		s -= p
		if p-d < m {
			p = m
		} else {
			p -= d
		}
		buys++
	}
	return
}
