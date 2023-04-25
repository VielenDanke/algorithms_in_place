package leetcode.system_implementations.java_solutions;

import java.util.HashSet;
import java.util.Set;

public class SmallestNumberInInfiniteSet_2336 {

    static class SmallestInfiniteSet {

        private final Set<Integer> deleted;
        private int next;

        public SmallestInfiniteSet() {
            this.next = 1;
            this.deleted = new HashSet<>();
        }

        public int popSmallest() {
            while (!deleted.isEmpty() && deleted.contains(next)) {
                next++;
            }
            deleted.add(next);
            return next;
        }

        public void addBack(int num) {
            deleted.remove(num);
            next = Math.min(next, num);
        }
    }
}
