package leetcode.array.medium.java_solutions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

interface NestedInteger {
    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    List<NestedInteger> getList();
}

public class FlattenNestedListIterator_341 {

    static class NestedIterator implements Iterator<Integer> {

        private final List<Integer> list;
        private final Iterator<Integer> iter;

        public NestedIterator(List<NestedInteger> nestedList) {
            list = new ArrayList<>();
            flatList(nestedList);
            this.iter = list.iterator();
        }

        @Override
        public Integer next() {
            return iter.next();
        }

        @Override
        public boolean hasNext() {
            return iter.hasNext();
        }

        private void flatList(List<NestedInteger> nestedList) {
            for (NestedInteger n : nestedList) {
                if (n.isInteger()) {
                    list.add(n.getInteger());
                } else {
                    flatList(n.getList());
                }
            }
        }
    }
}
