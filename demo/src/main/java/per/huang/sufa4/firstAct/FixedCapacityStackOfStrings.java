package per.huang.sufa4.firstAct;

import java.util.Stack;

/**
 * 定容栈
 */
public class FixedCapacityStackOfStrings {
    String[] a;
    int cap;
    int current;

    public FixedCapacityStackOfStrings(int cap) {
        this.cap = cap;
        a = new String[cap];
    }

    void push(String item) {
        a[current++] = item;
    }

    String pop() {
        return a[--current];
    }

    boolean isEmpty() {
        return current == 0;
    }

    int size() {
        return cap;
    }

    boolean isFull() {
        return current == cap ;
    }
}
