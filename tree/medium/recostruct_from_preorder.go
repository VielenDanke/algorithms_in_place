package medium

// O(N) time | O(N) space

func ReconstructBst(values []int) *BST {
	rootIdx := 0
	return reconstructBSTFromRange(
		-1<<31,
		1<<31,
		values,
		&rootIdx,
	)
}

func reconstructBSTFromRange(lowerBound, upperBound int, values []int, idx *int) *BST {
	if *idx == len(values) {
		return nil
	}
	rootValue := values[*idx]
	if rootValue < lowerBound || rootValue >= upperBound {
		return nil
	}
	*idx++
	leftSubTree := reconstructBSTFromRange(
		lowerBound,
		rootValue,
		values,
		idx,
	)
	rightSubTree := reconstructBSTFromRange(
		rootValue,
		upperBound,
		values,
		idx,
	)
	return &BST{Value: rootValue, Left: leftSubTree, Right: rightSubTree}
}
