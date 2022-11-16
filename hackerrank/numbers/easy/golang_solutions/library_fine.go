package golang_solutions

// https://www.hackerrank.com/challenges/library-fine/problem

func libraryFine(d1 int32, m1 int32, y1 int32, d2 int32, m2 int32, y2 int32) int32 {
	if isReturnedBefore(d1, m1, y1, d2, m2, y2) {
		return 0
	}
	return calculateFee(d1, m1, y1, d2, m2, y2)
}

func calculateFee(d1 int32, m1 int32, y1 int32, d2 int32, m2 int32, y2 int32) int32 {
	if y1 > y2 {
		return 10000
	} else if m1 > m2 {
		return 500 * (m1 - m2)
	} else {
		return 15 * (d1 - d2)
	}
}

func isReturnedBefore(d1 int32, m1 int32, y1 int32, d2 int32, m2 int32, y2 int32) bool {
	if y1 < y2 {
		return true
	} else if y1 == y2 && m1 < m2 {
		return true
	} else {
		return y1 == y2 && m1 == m2 && d1 < d2
	}
}
