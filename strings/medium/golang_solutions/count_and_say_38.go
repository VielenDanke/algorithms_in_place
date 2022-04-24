package golang_solutions

import (
	"bytes"
	"fmt"
)

func countAndSay(n int) string {
	say := "1"

	for i := 1; i < n; i++ {
		say = count(say)
	}
	return say
}

func count(say string) string {
	buff := bytes.NewBufferString("")
	c := say[0]
	counter := 1
	for i := 1; i < len(say); i++ {
		if say[i] == c {
			counter++
		} else {
			buff.WriteString(fmt.Sprintf("%d", counter))
			buff.WriteString(string(c))
			c = say[i]
			counter = 1
		}
	}
	buff.WriteString(fmt.Sprintf("%d", counter))
	buff.WriteString(string(c))
	return buff.String()
}
