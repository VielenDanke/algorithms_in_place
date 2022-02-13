package main

import (
	"fmt"
	"github.com/vielendanke/preparation/strings/medium"
	"os"
)

func main() {
	fmt.Fprintf(os.Stdout, "Result: %s\n", medium.DecodeString("3[a]2[bc]"))
}
