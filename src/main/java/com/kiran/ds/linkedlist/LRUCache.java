package com.kiran.ds.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private Integer capacity;
    //dummy nodes
    private Node head;
    private Node tail;
    private Map<Integer, Node> map;

    public LRUCache (int capacity) {
        this.capacity = capacity;
        map = new HashMap<> ();
        head = new Node(0,0);
        tail = new Node(0,0);
        head.previous = tail;
        tail.next = head;
    }

    public int get(int key) {
        if(map.containsKey (key)) {
            Node node = map.get (key);
            updateNode (node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if(map.containsKey (key)) {
            Node node = map.get (key);
            node.value = value;
            updateNode (node);
        } else {
            Node node = new Node (key, value);
            addNode(node);
            map.put (key, node);
        }
        if(map.size () > capacity) {
            Node nodeToDelete = tail.next;
            removeNode (nodeToDelete);
            map.remove (nodeToDelete.key);
        }
    }

    private void addNode (Node node) {
        node.next = head;
        node.previous = head.previous;
        head.previous = node;
        node.previous.next = node;
    }

    private void removeNode (Node node) {
        node.next.previous = node.previous;
        node.previous.next = node.next;
    }

    private void updateNode (Node node) {
        removeNode(node);
        addNode(node);
    }

    private class Node {
        Node next;
        Node previous;
        Integer key;
        Integer value;

        Node (Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main (String[] args) {
        LRUCache cache = new LRUCache (2);
        cache.put (2,1);
        cache.put (1,1);
        cache.put (2,3);
        cache.put (4,1);
        System.out.println (cache.get (1));
        System.out.println (cache.get (2));
    }
}
