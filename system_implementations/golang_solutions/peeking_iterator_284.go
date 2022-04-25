package golang_solutions

type Iterator struct {
}

func (i *Iterator) next() int {
	return 1
}

func (i *Iterator) hasNext() bool {
	return true
}

type IteratorNumber struct {
	number int
}

type PeekingIterator struct {
	iterator   *Iterator
	nextNumber *IteratorNumber
}

func ConstructorPeekingIterator(iter *Iterator) *PeekingIterator {
	p := &PeekingIterator{}
	if iter.hasNext() {
		p.iterator = iter
		p.nextNumber = &IteratorNumber{number: iter.next()}
	}
	return p
}

func (this *PeekingIterator) hasNext() bool {
	return this.nextNumber != nil
}

func (this *PeekingIterator) next() int {
	nextElem := this.nextNumber.number
	if this.iterator.hasNext() {
		this.nextNumber.number = this.iterator.next()
	} else {
		this.nextNumber = nil
	}
	return nextElem
}

func (this *PeekingIterator) peek() int {
	return this.nextNumber.number
}
