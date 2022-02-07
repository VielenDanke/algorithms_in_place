package main

import (
	"fmt"
	"github.com/vielendanke/preparation/sberbank"
	"os"
)

func main() {
	fmt.Fprintf(os.Stdout, "Result: %t\n", sberbank.DynamicArraySum([]int{3, 2, 4, 5}, 9))
}
