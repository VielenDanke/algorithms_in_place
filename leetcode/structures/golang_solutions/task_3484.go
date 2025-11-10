package golang_solutions

import (
	"strconv"
	"strings"
)

type Spreadsheet struct {
	valueMap map[string]int
}

func (this *Spreadsheet) SetCell(cell string, value int) {
	this.valueMap[cell] = value
}

func (this *Spreadsheet) ResetCell(cell string) {
	delete(this.valueMap, cell)
}

func (this *Spreadsheet) GetValue(formula string) int {
	formula = formula[1:]
	split := strings.Split(formula, "+")
	left, right := split[0], split[1]
	leftValue, rightValue := 0, 0
	if left[0] >= 'A' && left[0] <= 'Z' {
		leftValue = this.valueMap[left]
	} else {
		leftValue, _ = strconv.Atoi(left)
	}
	if right[0] >= 'A' && right[0] <= 'Z' {
		rightValue = this.valueMap[right]
	} else {
		rightValue, _ = strconv.Atoi(right)
	}
	return leftValue + rightValue
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * obj := Constructor(rows);
 * obj.SetCell(cell,value);
 * obj.ResetCell(cell);
 * param_3 := obj.GetValue(formula);
 */
