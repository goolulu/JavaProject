package per.huang.sufa4.firstAct;

import org.w3c.dom.Node;

public class NodeList {
    Node head;

    int size;

    class Node {

        int name;

        Node next;

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(Node node) {
        if (isEmpty()) {
            head = node;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
        size++;
    }

    public void deleteLastNode() {
        if (!isEmpty()) {
            if (size == 1) {
                head = null;
            } else {
                Node current = head;
                for (int i = 0; i < size-2; i++) {
                    current = current.next;
                }
                current.next = null;
            }
            size--;
        }
    }

    public void delete(int k) {
        if (k > size) {
            return;
        }
        Node current = head;
        for (int i = 0; i < k-1; i++) {
            current = current.next;
        }
        current.next = current.next.next;
        size--;
    }

    public void removeAfter(Node node) {
        Node current = head;
        while (current.next != null) {
            if (current.equals(node)) {
                current.next = null;
                size--;
            } else {
                current = current.next;
            }
        }
    }



    public static void main(String[] args) {

    }
}
