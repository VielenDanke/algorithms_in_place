package main

import (
	"fmt"
	"github.com/vielendanke/preparation/sberbank"
	"os"
)

func main() {
	fmt.Fprintf(os.Stdout, "Result: %d\n", sberbank.GetResult2([]int{3, 2, 1, 4}, []int{1, 2, 3, 4}))
}
