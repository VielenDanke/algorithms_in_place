package main

import (
	"fmt"
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

func isContains(prefix string, wordBank []string) bool {
	for _, v := range wordBank {
		if prefix == v {
			return true
		}
	}
	return false
}

func main() {
	fmt.Printf("Result: %v\n", allConstruct("purple", []string{"purp", "p", "ur", "le", "purpl"}))
}
