package golang_solutions

import (
	"bytes"
	"fmt"
	"math"
)

// https://www.hackerrank.com/challenges/matrix-rotation-algo/problem

func matrixRotation(matrix [][]int32, r int32) {
	// Write your code here
	row, col := len(matrix), len(matrix[0])
	layer := int(math.Min(float64(row), float64(col)) / 2)

	split := make([][]int32, 0)

	for i := 0; i < layer; i++ {
		temp := make([]int32, 0)
		for j := i; j < col-i; j++ {
			temp = append(temp, matrix[i][j])
		}
		for j := i + 1; j < row-i; j++ {
			temp = append(temp, matrix[j][col-i-1])
		}
		for j := col - i - 2; j >= i; j-- {
			temp = append(temp, matrix[row-i-1][j])
		}
		for j := row - i - 2; j > i; j-- {
			temp = append(temp, matrix[j][i])
		}
		split = append(split, temp)
	}
	// rotate
	for i := 0; i < layer; i++ {
		temp := make([]int32, 0)
		n := len(split[i])
		for j := 0; j < n; j++ {
			temp = append(temp, split[i][(j+int(r))%n])
		}
		split[i] = temp
	}
	// merge
	for i := 0; i < layer; i++ {
		index := 0
		for j := i; j < col-i; j++ {
			matrix[i][j] = split[i][index]
			index++
		}
		for j := i + 1; j < row-i; j++ {
			matrix[j][col-i-1] = split[i][index]
			index++
		}
		for j := col - i - 2; j >= i; j-- {
			matrix[row-i-1][j] = split[i][index]
			index++
		}
		for j := row - i - 2; j > i; j-- {
			matrix[j][i] = split[i][index]
			index++
		}
	}
	for idx, arr := range matrix {
		buff := bytes.NewBufferString("")
		for idx, elem := range arr {
			buff.WriteString(fmt.Sprintf("%d", elem))
			if idx < len(arr)-1 {
				buff.WriteRune(' ')
			}
		}
		if idx < len(matrix)-1 {
			fmt.Println(buff.String())
		} else {
			fmt.Print(buff.String())
		}
	}
}
