package com.kiran.ds.linkedlist;

public class LoopLinkedList {

    /**
     * Two pointers p and q, one moves slow and another moves faster (2x).  If the two pointers meet then the LinkedList has a loop.
     */
    public static boolean findIfLoopExists(Node head) {
        Node p = head,q = head;
        while(q != null && q.getNextNode() != null) {
            p = p.getNextNode();
            q = q.getNextNode().getNextNode();
            if(p.equals(q)) {
                return true;
            }
        }
        return false;
    }

    /**
     * After finding if a LinkedList has a loop, reset p to head then start moving p and q one node at a time.  The node where they meet is the start of the loop.
     */
    public static Node findStartOfLoop(Node head) {
        Node p = head, q = head;
        while(q != null && q.getNextNode() != null) {
            p = p.getNextNode();
            q = q.getNextNode().getNextNode();
            if(p.equals(q)) {
                p = head;
                while(p != q) {
                    p = p.getNextNode();
                    q = q.getNextNode();
                }
                return p;
            }
        }
        return null;
    }

    /**
     * After finding if a LinkedList has a loop, freeze pointer q and move pointer p one node at a time and have a nodes counter.
     * When q meets p, counter gives the length of the loop.
     */
    public static int findLoopLength(Node head) {
        Node p = head, q = head;
        while(q != null && q.getNextNode() != null) {
            p = p.getNextNode();
            q = q.getNextNode().getNextNode();
            if(p.equals(q)) {
                int counter = 0;
                do {
                    p = p.getNextNode();
                    counter++;
                } while(p != q);
                return counter;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Node<Integer> i1 = new Node<>(1);
        Node<Integer> i2 = new Node<>(2);
        Node<Integer> i3 = new Node<>(3);
        Node<Integer> i4 = new Node<>(4);
        Node<Integer> i5 = new Node<>(5);
        Node<Integer> i6 = new Node<>(6);
        Node<Integer> i7 = new Node<>(7);
        Node<Integer> i8 = new Node<>(8);
        Node<Integer> i9 = new Node<>(9);
        Node<Integer> i10 = new Node<>(10);

        i1.setNextNode(i2);
        i2.setNextNode(i3);
        i3.setNextNode(i4);
        i4.setNextNode(i5);
        i5.setNextNode(i6);
        i6.setNextNode(i7);
        i7.setNextNode(i8);
        i8.setNextNode(i9);
        i9.setNextNode(i10);
        i10.setNextNode(i5);

        boolean ifLoopExists = findIfLoopExists(i1);
        System.out.println(ifLoopExists);

        Node startOfLoop = findStartOfLoop(i1);
        System.out.println(startOfLoop != null ? startOfLoop.getItem(): startOfLoop);

        int loopLength = findLoopLength(i1);
        System.out.println(loopLength);
    }
}
