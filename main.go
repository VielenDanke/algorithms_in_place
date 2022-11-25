package main

import (
	"github.com/vielendanke/algorithms_in_place/leetcode/system_implementations/golang_solutions"
	"math/rand"
	"time"
)

func main() {
	storage := golang_solutions.NewUniqueRandomStorage(rand.New(rand.NewSource(time.Now().UnixNano())))

	counter := 1

	for counter < rand.Intn(200) {
		randNum := rand.Intn(counter)
		storage.Add(randNum)
		counter++
	}
	for counter >= rand.Intn(50) {
		randNum := rand.Intn(counter)
		storage.Remove(randNum)
		counter--
	}
	println(storage.GetRandom())
	println(storage.GetRandom())
	println(storage.GetRandom())
	println(storage.GetRandom())
	println(storage.GetRandom())
}
