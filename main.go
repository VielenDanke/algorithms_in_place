package main

import (
	"github.com/vielendanke/preparation/strings/medium"
)

func main() {
	for _, v := range medium.Partition("aab") {
		for _, j := range v {
			print(j + " ")
		}
		println()
	}
}
