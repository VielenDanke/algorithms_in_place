package golang_solutions

type AncestralTree struct {
	Name     string
	Ancestor *AncestralTree
}

func GetYoungestCommonAncestor(top, descendantOne, descendantTwo *AncestralTree) *AncestralTree {
	// Write your code here.
	first := make([]*AncestralTree, 0)
	second := make([]*AncestralTree, 0)
	for descendantOne != nil {
		first = append(first, descendantOne)
		descendantOne = descendantOne.Ancestor
	}
	for descendantTwo != nil {
		second = append(second, descendantTwo)
		descendantTwo = descendantTwo.Ancestor
	}
	var last *AncestralTree
	for len(first) != 0 && len(second) != 0 && (first[len(first)-1].Name == second[len(second)-1].Name) {
		last = first[len(first)-1]
		first = first[:len(first)-1]
		second = second[:len(second)-1]
	}
	return last
}
