package com.kiran.ds.ds;

public class BasicLinkedList<X> {

    private Node first;
    private Node last;
    private int nodeCount;

    public BasicLinkedList(){
        this.first = null;
        this.last = null;
        this.nodeCount = 0;
    }

    public void add(X item) {
        // Check if the list is empty and add the first item in the list
        if(first == null) {
            first = new Node(item);
            last = first;
        }// otherwise, grab the last node and update it's value
        else {
            Node itemNode = new Node(item);
            last.setNextNode(itemNode);
            last = itemNode;
        }
        nodeCount++;
    }

    public void insert(X item, int position) {
        if(size() < position) {
            throw new IllegalStateException("The LinkedList is smaller than the position you are inserting at");
        }
        Node currentNode = first;
        // start at 1 because we are already on the first node
        for(int i = 1; i < position && currentNode != null; i++) {
            currentNode = currentNode.getNextNode();
        }

        // severs the link chain and reconnects with the new node
        Node newNode = new Node(item);
        newNode.setNextNode(currentNode.getNextNode());
        currentNode.setNextNode(newNode);
        nodeCount++;
    }

    public X remove() {
        // Check if the list is empty
        if(first == null) {
            throw new IllegalStateException("LinkedList is empty, no items to remove from the list");
        }
        // update the first pointer and throw away the old first
        X item = first.getNodeItem();
        first = first.getNextNode();
        nodeCount--;
        return item;
    }

    public X removeAt(int position) {
        if(first ==  null) {
            throw new IllegalStateException("LinkedList is empty, no items to remove from the list");
        }
        Node currentNode = first;
        Node previousNode = first;
        // start at 1 because we are already on the first node
        for(int i = 1; i < position; i++) {
            previousNode = currentNode;
            currentNode = currentNode.getNextNode();
        }
        // update the pointers and remove the current node
        previousNode.setNextNode(currentNode.getNextNode());
        nodeCount--;
        return currentNode.getNodeItem();
    }

    public void remove(Node node) {
        if(first ==  null) {
            throw new IllegalStateException("LinkedList is empty, no items to remove from the list");
        }
        Node currentNode = first;
        Node previousNode = first;
        if(first.equals(node)) {
            first = first.getNextNode();
            nodeCount--;
            return;
        }
        while(currentNode.getNextNode() != null) {
            if(currentNode.equals(node)) {
                previousNode.setNextNode(currentNode.getNextNode());
                nodeCount--;
            } else {
                previousNode = currentNode;
                currentNode = currentNode.getNextNode();
            }
        }
    }

    public X get(int position) {
        if(first ==  null) {
            throw new IllegalStateException("LinkedList is empty, no items to return from the list");
        }
        Node currentNode = first;
        for(int i = 1; i < size() && currentNode != null; i++) {
            if(i == position) {
                return currentNode.getNodeItem();
            } else {
                currentNode = currentNode.getNextNode();
            }
        }
        // if we didn't find then return null
        return null;
    }

    public int find(X item) {
        if(first ==  null) {
            throw new IllegalStateException("LinkedList is empty, no items to find in the list");
        }
        Node currentNode = first;
        for(int i = 1; i < size() && currentNode != null; i++) {
            if(currentNode.getNodeItem().equals(item)) {
                return i;
            } else {
                currentNode = currentNode.getNextNode();
            }
        }
        // if we didn't find then return -1
        return -1;
    }

    public String toString() {
        StringBuffer contents = new StringBuffer();
        Node currentNode = first;
        while(currentNode != null) {
            contents.append(currentNode.getNodeItem());
            currentNode = currentNode.getNextNode();
            if(currentNode != null) {
                contents.append(", ");
            }
        }
        return contents.toString();
    }

    public int size() {
        return this.nodeCount;
    }

    private class Node {
        private X nodeItem;
        private Node nextNode;

        public Node(X item) {
            this.nodeItem = item;
            this.nextNode = null;
        }

        public X getNodeItem() {
            return nodeItem;
        }

        public void setNodeItem(X nodeItem) {
            this.nodeItem = nodeItem;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }
    }


    public static void main(String[] args) {
        String s = new String("Good");
        s += "Day";
        System.out.println(s);
    }



}
