package medium

import (
	"sort"
)

func FindAnagrams2(s string, p string) []int {
	result := make([]int, 0)
	r := []rune(s)
	for i := 0; i <= len(s)-len(p); i++ {
		sub := r[i : i+len(p)]
		if checkAnagram([]rune(p), sub) {
			result = append(result, i)
		}
	}
	return result
}

func checkAnagram(text []rune, anagram []rune) (isAnagram bool) {
	arr := make([]int, 0)

	for i := 0; i < 26; i++ {
		arr = append(arr, 0)
	}
	for _, v := range text {
		current := arr[v-97]
		arr[v-97] = current + 1
	}
	for _, v := range anagram {
		current := arr[v-97]
		arr[v-97] = current - 1
	}
	isAnagram = true
	for i := 0; i < len(arr); i++ {
		if arr[i] != 0 {
			isAnagram = false
			break
		}
	}
	return
}

func FindAnagrams(s string, p string) []int {
	text := []rune(s)
	anagram := []rune(p)
	result := make([]int, 0)
	sort.Slice(anagram, func(i, j int) bool {
		return anagram[i] < anagram[j]
	})
	for i := 0; i < len(text); i++ {
		temp := make([]rune, 0)
		maxLen := 0
		if len(anagram)+i > len(text) {
			maxLen = len(text)
		} else {
			maxLen = len(anagram) + i
		}
		for _, v := range text[i:maxLen] {
			temp = append(temp, v)
		}
		sort.Slice(temp, func(i, j int) bool {
			return temp[i] < temp[j]
		})
		ft := string(temp)
		st := string(anagram)
		if ft == st {
			result = append(result, i)
		}
	}
	return result
}
