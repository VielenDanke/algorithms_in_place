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

public class FlattenNestedListIterator_341 implements Iterator<Integer> {

    private final Iterator<Integer> unflattenListIterator;

    public FlattenNestedListIterator_341(List<NestedInteger> nestedList) {
        List<Integer> unflattenList = new ArrayList<>();

        for (NestedInteger n : nestedList) {
            unflatten(n, unflattenList);
        }
        this.unflattenListIterator = unflattenList.iterator();
    }

    @Override
    public Integer next() {
        return unflattenListIterator.next();
    }

    @Override
    public boolean hasNext() {
        return unflattenListIterator.hasNext();
    }

    private void unflatten(NestedInteger nestedInteger, List<Integer> root) {
        if (!nestedInteger.isInteger()) {
            List<NestedInteger> list = nestedInteger.getList();

            for (NestedInteger n : list) {
                unflatten(n, root);
            }
        } else {
            root.add(nestedInteger.getInteger());
        }
    }
}
