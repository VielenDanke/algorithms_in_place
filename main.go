package main

import (
	"fmt"
	"github.com/vielendanke/algorithms_in_place/system_implementations/golang_solutions"
)

func main() {
	codec := golang_solutions.Constructor()

	shortUrl := codec.Encode("https://leetcode.com/problems/design-tinyurl")
	fmt.Printf("%v\n", codec.Decode(shortUrl))
}
