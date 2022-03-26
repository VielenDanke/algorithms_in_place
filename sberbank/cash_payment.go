package sberbank

import (
	"sort"
)

func CashPayment(cash []int, s int) (amount int) {
	sort.Slice(cash, func(i, j int) bool {
		return cash[i] > cash[j]
	})
	for s > 0 {
		if s < 3 {
			lastPay := (0 - s) * -1
			cash[len(cash)-1] = cash[len(cash)-1] + lastPay
			s -= lastPay
		} else {
			cash[len(cash)-1] = cash[len(cash)-1] + 3
			s -= 3
		}
		for i := len(cash) - 2; i >= 0; i-- {
			if cash[i] < cash[i+1] {
				cash[i+1], cash[i] = cash[i], cash[i+1]
			} else {
				break
			}
		}
	}
	maxVal := cash[0]
	for i := 1; i < len(cash); i++ {
		if maxVal > cash[i] {
			return len(cash) - i
		}
	}
	return
}
