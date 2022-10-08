package leetcode.system_implementations.java_solutions;

import java.util.Iterator;

public class PeekingIterator_284 implements Iterator<Integer> {

    private final Iterator<Integer> iterator;
    private Integer number;

    public PeekingIterator_284(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        if (this.iterator.hasNext()) this.number = this.iterator.next();
    }

    public Integer peek() {
        return this.number;
    }

    @Override
    public Integer next() {
        Integer nextElem = this.number;
        if (this.iterator.hasNext()) {
            this.number = this.iterator.next();
        } else {
            this.number = null;
        }
        return nextElem;
    }

    @Override
    public boolean hasNext() {
        return this.number != null;
    }
}
