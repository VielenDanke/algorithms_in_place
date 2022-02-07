package main

import (
	"fmt"
	"github.com/vielendanke/preparation/recursion"
	"os"
)

func main() {
	fmt.Fprintf(os.Stdout, "Result: %d\n", recursion.NumWaysDynamic(5))
}
