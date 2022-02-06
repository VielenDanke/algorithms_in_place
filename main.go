package main

import (
	"fmt"
	"github.com/vielendanke/preparation/strings"
	"os"
)

func main() {
	fmt.Fprintf(os.Stdout, "Result: %s\n", strings.RunLengthEncoding("AAAAAAAAAAAAABBCCCCDD"))
}
