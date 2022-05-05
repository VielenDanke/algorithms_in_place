package structures.java_solutions;

import java.util.LinkedList;
import java.util.List;

public class ImplementStackUsingQueues_225 {

    private final List<Integer> stack;

    public ImplementStackUsingQueues_225() {
        this.stack = new LinkedList<>();
    }

    public void push(int x) {
        stack.add(x);
    }

    public int pop() {
        int last = top();
        stack.remove(stack.size() - 1);
        return last;
    }

    public int top() {
        int last = -1;
        for (int val : stack) {
            last = val;
        }
        return last;
    }

    public boolean empty() {
        return stack.isEmpty();
    }
}
