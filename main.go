package main

import (
	"fmt"
	"github.com/vielendanke/preparation/strings"
)

func main() {
	fmt.Printf("Result: %s\n", strings.SplitPi("3141592653589793238462643383279",
		[]string{"314", "49", "9001", "15926535897", "14", "9323", "8462643383279", "4", "793"}))
}
