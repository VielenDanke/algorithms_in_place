package golang_solutions

import (
	"strconv"
	"strings"
)

// optimal

func MultiplyOptimal(num1, num2 string) string {
	if num1 == "0" || num2 == "0" {
		return "0"
	}
	l1, l2 := len(num1), len(num2)
	res := make([]byte, l1+l2)
	for i := l1 - 1; i >= 0; i-- {
		for j := l2 - 1; j >= 0; j-- {
			val := (num1[i] - '0') * (num2[j] - '0')
			res[i+j+1] += val
			if res[i+j+1] >= 10 {
				res[i+j] += res[i+j+1] / 10
				res[i+j+1] %= 10
			}
		}
	}
	if res[0] == 0 {
		res = res[1:]
	}
	for i := range res {
		res[i] += '0'
	}
	return string(res)
}

// not optimal

func Multiply(first, second string) string {
	increment := 0

	nums := make([]string, 0)

	firstRunes := []rune(first)
	secondRunes := []rune(second)

	for i := len(secondRunes) - 1; i >= 0; i-- {
		currentSum := multiplyWithIncrement(firstRunes, secondRunes[i], increment)
		nums = append(nums, currentSum)
		increment++
	}
	currentSum := ""
	for i := 0; i < len(nums); i++ {
		if len(currentSum) == 0 {
			currentSum += nums[i]
		} else {
			currentSum = sum([]rune(currentSum), []rune(nums[i]))
		}
	}
	left := strings.TrimLeft(currentSum, "0")
	if len(left) == 0 {
		return "0"
	}
	return left
}

func sum(first, second []rune) string {
	currentSum := make([]string, 0)

	leftLastIdx := len(first) - 1
	rightLastIdx := len(second) - 1
	remainder := 0

	for leftLastIdx >= 0 && rightLastIdx >= 0 {
		temp := int(first[leftLastIdx]-'0') + int(second[rightLastIdx]-'0')

		temp += remainder
		remainder = 0

		if temp > 9 {
			num := temp % 10
			remainder = temp / 10

			strInt := strconv.Itoa(num)
			if len(currentSum) == 0 {
				currentSum = append(currentSum, strInt)
			} else {
				newCurrSum := append([]string{}, strInt)
				newCurrSum = append(newCurrSum, currentSum...)
				currentSum = newCurrSum
			}
		} else {
			strInt := strconv.Itoa(temp)
			if len(currentSum) == 0 {
				currentSum = append(currentSum, strInt)
			} else {
				newCurrSum := append([]string{}, strInt)
				newCurrSum = append(newCurrSum, currentSum...)
				currentSum = newCurrSum
			}
		}
		leftLastIdx--
		rightLastIdx--
	}
	for leftLastIdx >= 0 {
		num := int(first[leftLastIdx] - '0')

		num += remainder
		remainder = 0

		if num > 9 {
			remainder = num / 10
			num = num % 10

			newCurrSum := append([]string{}, strconv.Itoa(num))
			newCurrSum = append(newCurrSum, currentSum...)
			currentSum = newCurrSum
		} else {
			newCurrSum := append([]string{}, strconv.Itoa(num))
			newCurrSum = append(newCurrSum, currentSum...)
			currentSum = newCurrSum
		}
		leftLastIdx--
	}
	for rightLastIdx >= 0 {
		num := int(second[rightLastIdx] - '0')

		num += remainder
		remainder = 0

		if num > 9 {
			remainder = num / 10
			num = num % 10

			newCurrSum := append([]string{}, strconv.Itoa(num))
			newCurrSum = append(newCurrSum, currentSum...)
			currentSum = newCurrSum
		} else {
			newCurrSum := append([]string{}, strconv.Itoa(num))
			newCurrSum = append(newCurrSum, currentSum...)
			currentSum = newCurrSum
		}
		rightLastIdx--
	}
	if remainder != 0 {
		newCurrSum := append([]string{}, strconv.Itoa(remainder))
		newCurrSum = append(newCurrSum, currentSum...)
		currentSum = newCurrSum
		leftLastIdx--
	}
	return strings.Join(currentSum, "")
}

func multiplyWithIncrement(first []rune, second rune, increment int) string {
	currentSum := make([]string, 0)

	remainder := 0

	for i := len(first) - 1; i >= 0; i-- {
		temp := int(first[i]-'0') * int(second-'0')

		if temp == 0 {
			continue
		}

		temp += remainder
		remainder = 0

		if temp > 9 {
			tempSum := int(temp) % 10
			remainder = int(temp) / 10

			strInt := strconv.Itoa(tempSum)

			if len(currentSum) == 0 {
				currentSum = append(currentSum, strInt)
			} else {
				newCurrSum := append([]string{}, strInt)
				newCurrSum = append(newCurrSum, currentSum...)
				currentSum = newCurrSum
			}
		} else {
			strInt := strconv.Itoa(temp)
			if len(currentSum) == 0 {
				currentSum = append(currentSum, strInt)
			} else {
				newCurrSum := append([]string{}, strInt)
				newCurrSum = append(newCurrSum, currentSum...)
				currentSum = newCurrSum
			}
		}
	}
	if remainder != 0 {
		strInt := strconv.Itoa(remainder)

		newCurrSum := append([]string{}, strInt)
		newCurrSum = append(newCurrSum, currentSum...)
		currentSum = newCurrSum
	}
	for i := 0; i < increment; i++ {
		currentSum = append(currentSum, "0")
	}
	return strings.Join(currentSum, "")
}
