package main

import (
	"bufio"
	"fmt"
	"log"
	"os"
	"strconv"
	"strings"
)

var team = make(map[string]int)
var previousExp = make(map[string]int)

func main() {
	scanner := bufio.NewScanner(os.Stdin)

	var n int
	scanner.Scan()
	n, err := strconv.Atoi(scanner.Text())
	if err != nil {
		log.Fatalln(err)
	}

	for i := 0; i < n; i++ {
		var name string
		var timeFrame int

		scanner.Scan()
		split := strings.Split(scanner.Text(), " ")
		name = split[0]
		timeFrame, _ = strconv.Atoi(split[1])

		if val, ok := team[name]; !ok {
			team[name] = timeFrame
		} else {
			delete(team, name)
			previousExp[name] = max(previousExp[name], timeFrame-val)
		}

		theMostExp := -1 << 31
		sumExp := 0
		var theMostExpName string

		for key, val := range team {
			currentExperience := timeFrame - val + previousExp[key]

			if theMostExp < currentExperience {
				theMostExp = currentExperience
				theMostExpName = key
			} else if theMostExp == currentExperience {
				if key < theMostExpName {
					theMostExpName = key
				}
			}

			sumExp += currentExperience
		}

		fmt.Printf("%s %d\n", theMostExpName, sumExp-theMostExp-(theMostExp))
	}
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
