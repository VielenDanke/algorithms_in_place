package javasolutions.linkedlist.medium;

import java.util.ArrayList;
import java.util.List;
import javasolutions.linkedlist.Node;

public class DeepCopy {

    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        List<Node> nodes = new ArrayList<>();
        List<Integer> pointers = new ArrayList<>();
        List<Node> resultNodes = new ArrayList<>();

        Node temp = head;

        while (temp != null) {
            nodes.add(temp);
            temp = temp.next;
        }
        for (Node n : nodes) {
            pointers.add(nodes.indexOf(n.random));
            resultNodes.add(new Node(n.val));
        }
        for (int i = 0; i < resultNodes.size(); i++) {
            Integer index = pointers.get(i);
            if (index == -1) {
                resultNodes.get(i).random = null;
            } else {
                resultNodes.get(i).random = resultNodes.get(index);
            }
        }
        for (int i = 0; i + 1 < resultNodes.size(); i++) {
            resultNodes.get(i).next = resultNodes.get(i + 1);
        }
        return resultNodes.get(0);
    }
}
