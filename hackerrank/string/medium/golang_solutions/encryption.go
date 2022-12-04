package golang_solutions

import (
	"bytes"
	"math"
)

// https://www.hackerrank.com/challenges/encryption/problem

var symbol = '@'

func trimAll(s string) string {
	buff := bytes.NewBufferString("")
	for _, v := range s {
		if v != ' ' {
			buff.WriteRune(v)
		}
	}
	return buff.String()
}

func findLowerUpperBounds(n int) (int, int) {
	sq := math.Sqrt(float64(n))

	left, right := int(math.Floor(sq)), int(math.Ceil(sq))

	if left*right < n {
		left++
	}
	return left, right
}

func createEncryptedMatrix(s string, left, right int) [][]rune {
	matrix := make([][]rune, left, left)

	for idx := range matrix {
		matrix[idx] = make([]rune, right, right)
	}
	idx := 0
	str := []rune(s)

	for i := 0; i < left; i++ {
		for j := 0; j < right; j++ {
			if idx < len(str) {
				matrix[i][j] = str[idx]
				idx++
			} else {
				matrix[i][j] = symbol
			}
		}
	}
	return matrix
}

func writeToString(matrix [][]rune, left, right int) string {
	result := bytes.NewBufferString("")

	for i := 0; i < right; i++ {
		for j := 0; j < left; j++ {
			if matrix[j][i] != symbol {
				result.WriteRune(matrix[j][i])
			} else {
				continue
			}
		}
		result.WriteRune(' ')
	}
	return result.String()
}

func encryption(s string) string {
	newStr := trimAll(s)

	left, right := findLowerUpperBounds(len(newStr))

	matrix := createEncryptedMatrix(newStr, left, right)

	return writeToString(matrix, left, right)
}
