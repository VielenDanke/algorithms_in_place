package main

import (
	"fmt"
	"github.com/vielendanke/algorithms_in_place/array/medium/golang_solutions"
)

//var elementsNum = 100000

func main() {
	fmt.Printf("%v\n", golang_solutions.MinCostConnectPoints([][]int{{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}}))

	//rand.Seed(int64(elementsNum))
	//arr := make([]int, elementsNum)
	//for i := 0; i < elementsNum; i++ {
	//	arr[i] = int(rand.Int31n(int32(elementsNum)))
	//}
	//start := time.Now()
	//medium.MergeSortWithInsertion(arr, 64)
	//end := time.Now().Sub(start)
	//fmt.Printf("End time %d\n", end.Milliseconds())
}
