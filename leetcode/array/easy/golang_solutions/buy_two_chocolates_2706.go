package golang_solutions

import "sort"

// iterative

func buyChoco(prices []int, money int) int {
	first, second := 1<<30, 1<<30

	for _, price := range prices {
		if first > price {
			second = first
			first = price
		} else if second > price {
			second = price
		}
	}
	moneyLeft := money - (first + second)
	if moneyLeft < 0 {
		return money
	}
	return moneyLeft
}

// sort

func buyChocoSort(prices []int, money int) int {
	sort.Ints(prices)
	moneyLeft := money - (prices[0] + prices[1])
	if moneyLeft < 0 {
		return money
	}
	return moneyLeft
}
