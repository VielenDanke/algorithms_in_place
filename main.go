package main

import (
	"fmt"
	"github.com/vielendanke/preparation/sberbank"
	"os"
)

func main() {
	fmt.Fprintf(os.Stdout, "Result: %d\n", sberbank.MaxCommonSubsequence("agdd", 1, "gdd"))
}
