package main

import (
	"fmt"
	"github.com/vielendanke/preparation/sberbank"
	"os"
)

func main() {
	fmt.Fprintf(os.Stdout, "Result: %t\n", sberbank.GuestsList2(4, []string{"1-2", "3-4"}))
}
