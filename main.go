package main

import "github.com/vielendanke/preparation/array/hard"

func main() {
	freqStack := hard.Constructor()

	freqStack.Push(5)
	freqStack.Push(7)
	freqStack.Push(5)
	freqStack.Push(7)
	freqStack.Push(4)
	freqStack.Push(5)

	freqStack.Pop()
	freqStack.Pop()
}
