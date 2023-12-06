package golang_solutions

func totalMoney(n int) int {
	days, total, daysPerWeek, incrMoneyRatio := 0, 0, 7, 1

	for n > 0 {
		total += days%daysPerWeek + incrMoneyRatio + days/daysPerWeek
		days++
		n--
	}
	return total
}
