package main

import (
	"fmt"
	"github.com/vielendanke/preparation/strings/medium"
)

func main() {
	for _, v := range medium.Partition("aab") {
		fmt.Printf("%v\n", v)
	}
}
