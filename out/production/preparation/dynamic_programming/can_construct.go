package main

import (
	"strings"
)

// O(N^M)
func canConstruct(target string, wordBank []string) bool {
	return construct(target, wordBank, make(map[string]bool))
}

func canCountConstruct(target string, wordBank []string) int {
	return countConstruct(target, wordBank, make(map[string]int))
}

func allConstruct(target string, wordBank []string) [][]string {
	return allConstructCollector(target, wordBank, make(map[string][][]string))
}

func allConstructCollector(target string, wordBank []string, memo map[string][][]string) [][]string {
	if val, ok := memo[target]; ok {
		return val
	}
	if target == "" {
		return [][]string{}
	}
	var result [][]string
	for _, v := range wordBank {
		if strings.Index(target, v) == 0 {
			res := allConstructCollector(target[len(v):], wordBank, memo)
			if res != nil {
				t := append([]string{v})
				for j := range res {
					t = append(t, res[j]...)
				}
				result = append(result, t)
			}
		}
	}
	memo[target] = result
	return result
}

func countConstruct(target string, wordBank []string, memo map[string]int) (sum int) {
	if val, ok := memo[target]; ok {
		return val
	}
	if target == "" {
		return 1
	}
	for _, v := range wordBank {
		if strings.Index(target, v) == 0 {
			sum += countConstruct(target[len(v):], wordBank, memo)
		}
	}
	memo[target] = sum
	return sum
}

func construct(target string, wordBank []string, memo map[string]bool) bool {
	if val, ok := memo[target]; ok {
		return val
	}
	if target == "" {
		return true
	}
	for _, v := range wordBank {
		if strings.Index(target, v) == 0 {
			if construct(target[len(v):], wordBank, memo) {
				memo[target] = true
				return true
			}
		}
	}
	memo[target] = false
	return false
}

// ---------------------------------------------------------------------------------------------------

func canConstructTabulation(target string, wordBank []string) bool {
	var tab []bool
	for i := 0; i < len(target)+1; i++ {
		tab = append(tab, false)
	}
	tab[0] = true
	for idx := range tab {
		if tab[idx] {
			for _, word := range wordBank {
				// if the word matches the characters starting at position i
				if idx+len(word) <= len(target) && target[idx:idx+len(word)] == word && idx+len(word) < len(tab) {
					tab[idx+len(word)] = true
				}
			}
		}
	}
	return tab[len(target)]
}

func canCountConstructTabulation(target string, wordBank []string) int {
	var tab []int
	for i := 0; i < len(target)+1; i++ {
		tab = append(tab, 0)
	}
	tab[0] = 1
	for idx := range tab {
		for _, word := range wordBank {
			if idx+len(word) <= len(target) && target[idx:idx+len(word)] == word && idx+len(word) < len(tab) {
				tab[idx+len(word)] += tab[idx]
			}
		}
	}
	return tab[len(target)]
}

func allConstructTabulation(target string, wordBank []string) [][]string {
	var tab [][][]string

	for i := 0; i < len(target)+1; i++ {
		tab = append(tab, nil)
	}
	tab[0] = [][]string{}
	for idx := range tab {
		for _, word := range wordBank {
			if idx+len(word) <= len(target) && target[idx:idx+len(word)] == word && idx+len(word) < len(tab) {
				t := append(tab[idx], []string{word})
				tab[idx+len(word)] = append(tab[idx+len(word)], t...)
			}
		}
	}
	return tab[len(target)]
}

func isContains(prefix string, wordBank []string) bool {
	for _, v := range wordBank {
		if prefix == v {
			return true
		}
	}
	return false
}
