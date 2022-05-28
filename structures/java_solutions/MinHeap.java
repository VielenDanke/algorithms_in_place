package structures.java_solutions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MinHeap<T extends Comparable<T>> {

    private final List<T> heap;

    public MinHeap(T[] array) {
        heap = new ArrayList<>();
        for (T elem : array) add(elem);
    }

    public MinHeap(Collection<T> collection) {
        heap = new ArrayList<>();
        for (T elem : collection) add(elem);
    }

    public void add(T elem) {
        if (elem == null) throw new IllegalArgumentException();
        heap.add(elem);
        int indexOfLastElem = heap.size() - 1;
        swim(indexOfLastElem);
    }

    public T poll() {
        return removeAt(0);
    }

    private void swim(int k) {
        int parent = (k - 1) / 2;
        while (k > 0 && less(k, parent)) {
            swap(parent, k);
            k = parent;
            parent = (k - 1) / 2;
        }
    }

    private void sink(int k) {
        int heapSize = heap.size();
        while (true) {
            int left = 2 * k + 1;
            int right = 2 * k + 2;
            int smallest = left;

            if (right < heapSize && less(right, left)) smallest = right;

            if (left >= heapSize || less(k, smallest)) break;

            swap(smallest, k);
            k = smallest;
        }
    }


    private void swap(int parent, int k) {
        T parentElem = heap.get(parent);
        T kElem = heap.get(k);
        heap.set(parent, kElem);
        heap.set(k, parentElem);
    }

    private T removeAt(int i) {
        if (heap.size() == 0) return null;

        int indexOfLastElem = heap.size() - 1;
        T removedData = heap.get(i);
        swap(i, indexOfLastElem);
        heap.remove(indexOfLastElem);

        if (i == indexOfLastElem) return removedData;
        T elem = heap.get(i);

        sink(i);

        if (heap.get(i).equals(elem)) swim(i);
        return removedData;
    }

    private boolean less(int k, int parent) {
        return heap.get(k).compareTo(heap.get(parent)) <= 0;
    }
}
