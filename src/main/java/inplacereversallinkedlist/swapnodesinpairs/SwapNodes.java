package inplacereversallinkedlist.swapnodesinpairs;

import utils.LinkedListNode;

public class SwapNodes {

    public LinkedListNode<Integer> swapPairs(LinkedListNode<Integer> root) {
        var isFirst = true;
        LinkedListNode<Integer> current = root;
        LinkedListNode<Integer> prev = root;
        LinkedListNode<Integer> first = null;
        while (current != null) {
            if (isFirst) {
                first = current;
                current = current.next;
            } else {
                if (prev == root) root = current;
                else prev.next = current;
                first.next = current.next;
                current.next = first;
                current = first.next;
                prev = first;
            }
            isFirst = !isFirst;
        }
        return root;
    }
}
