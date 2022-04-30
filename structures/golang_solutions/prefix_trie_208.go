package golang_solutions

type trieNode struct {
	children map[rune]*trieNode
}

type Trie struct {
	root *trieNode
}

func ConstructorTrie() Trie {
	return Trie{root: &trieNode{children: make(map[rune]*trieNode)}}
}

func (this *Trie) Insert(word string) {
	node := this.root

	for _, letter := range word {
		if _, ok := node.children[letter]; !ok {
			node.children[letter] = &trieNode{children: make(map[rune]*trieNode)}
		}
		node = node.children[letter]
	}
	node.children['*'] = nil
}

func (this *Trie) Search(word string) bool {
	node := this.root

	for _, letter := range word {
		if _, ok := node.children[letter]; !ok {
			return false
		}
		node = node.children[letter]
	}
	_, ok := node.children['*']
	return ok
}

func (this *Trie) StartsWith(prefix string) bool {
	node := this.root

	for _, letter := range prefix {
		if _, ok := node.children[letter]; !ok {
			return false
		}
		node = node.children[letter]
	}
	return true
}
