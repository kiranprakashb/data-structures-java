package com.kiran.ds.linkedlist;

import java.util.EmptyStackException;

public class LinkedListStack<T> {

    private Node<T> top;
    private int length;

    public LinkedListStack() {
    }

    public void push(T item) {
        Node<T> node = new Node<>(item);
        node.setNextNode(top);
        top = node;
        length++;
    }

    public T pop() {
        if(length == 0) {
            throw new EmptyStackException();
        }
        T item = top.getItem();
        top = top.getNextNode();
        return item;
    }

    public T peek() {
        if(length == 0) {
            throw new EmptyStackException();
        }
        return top.getItem();
    }
}
