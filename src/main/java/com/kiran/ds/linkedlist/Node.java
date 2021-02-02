package com.kiran.ds.linkedlist;

public class Node<X> {

    private X item;
    private Node nextNode;

    public Node(X item) {
        this.item = item;
    }

    public X getItem() {
        return item;
    }

    public void setItem(X item) {
        this.item = item;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}
