package main

import (
	"fmt"
	"github.com/vielendanke/preparation/leetcode/medium"
	"os"
)

func main() {
	fmt.Fprintf(os.Stdout, "Result: %d\n", medium.MaxProduct([]string{"eae", "ea", "aaf", "bda", "fcf", "dc", "ac", "ce", "cefde", "dabae"}))
}
