package com.example.demo;

import org.w3c.dom.Node;

public class sufa {

    Node head;
    Node tail;
    int size;

    public void push(Node node) {
        Node oldhead = head;
        head = node;
        head.next = oldhead;
        if (size == 0) {
            tail = head;
        }
        size++;
    }

    public void next() {

    }

    public Node peek() {
        return head;
    }

    public Node pop() {
        Node oldhead = head;
        head = head.next;
        return oldhead;
    }

    public void addfirst(Node node) {
        push(node);
    }

    public void addlast(Node node) {
        Node oldNode = tail;
        oldNode.next = node;
        tail = oldNode.next;
    }

    public void addlast1(Node node) {
        Node oldNode = tail;
        tail = node;
        oldNode.next = tail;
    }

    static class Node {
        String val;
        Node next;


        public Node() {
            this("", null);
        }

        public Node(String val) {
            this(val, null);
        }

        public Node(String val, Node next) {
            this.val = val;
            this.next = next;

        }


    }


    public static void main(String[] args) {
        sufa sf = new sufa();
        Node node1 = new Node("1");
        Node node2 = new Node("2");
        Node node3 = new Node("3");
        sf.addfirst(node1);
        sf.addlast(node2);
        sf.addlast1(node3);
        System.out.println(sf);

    }
}
