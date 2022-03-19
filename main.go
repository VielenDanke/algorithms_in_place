package main

import (
	"github.com/vielendanke/preparation/strings/medium"
	"log"
)

func main() {
	labels := medium.PartitionLabels("eccbbbbdec")

	log.Printf("%v\n", labels)
}
