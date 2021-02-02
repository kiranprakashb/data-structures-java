package com.kiran.ds.linkedlist;

public class FindInLinkedList {

    /**
     * Two pointers p and q, q doesn't move until p has moved n nodes.  After that both p and q move one node each until p reaches the end of the LinkedList.
     * At this point the node where q stops is the nth node from the last.
     */
    public static Node returnNthNodeFromLast(Node head, int n) {
        Node p = head, q = null;
        for(int i=1; i<n; i++) {
            p = p.getNextNode();
        }

        while(p.getNextNode() != null) {
            if(q == null) {
                q = head;
            } else {
                p = p.getNextNode();
                q = q.getNextNode();
            }
        }
        return q;
    }

    /**
     * Find the difference (diff) between lengths of both the lists.  Identify the longer list, move the pointer(p) to diff to equalize the list lengths.
     * From this point on move both the pointers of longer list (p) and shorter list (q) one node at a time.  The node where p=q is the intersecting point.
     */
    public static Node findIntersectingNode(Node list1Head, Node list2Head) {
        int l1 = 1, l2 = 1, diff = 0;
        Node p = list1Head, q = list2Head;
        while(p.getNextNode() != null) {
            p = p.getNextNode();
            l1++;
        }
        while(q.getNextNode() != null) {
            q = q.getNextNode();
            l2++;
        }
        if(l1 > l2) {
            diff = l1 - l2;
            p = list1Head;
            q = list2Head;
        } else {
            diff = l2 - l1;
            p = list2Head;
            q = list1Head;
        }

        for(int i=0; i<diff; i++) {
            p = p.getNextNode();
        }
        while(p.getNextNode() != null) {
            p = p.getNextNode();
            q = q.getNextNode();
            if(p.equals(q)) {
                return p;
            }
        }
        return null;
    }

    /**
     * Have 2 pointers p and q, q moves at twice the speed as p.  Once q reaches end of list, p is the middle of the list.
     */
    private static Node findMiddle(Node head) {
        Node p = head; Node q = head;
        while(q.getNextNode() != null) {
            p = p.getNextNode();
            q = q.getNextNode().getNextNode();
        }
        return p;
    }

    public static void main(String[] args) {
        Node<Integer> i1 = new Node<>(1);
        Node<Integer> i2 = new Node<>(2);
        Node<Integer> i3 = new Node<>(3);
        Node<Integer> i4 = new Node<>(4);
        Node<Integer> i5 = new Node<>(5);

        i1.setNextNode(i2);
        i2.setNextNode(i3);
        i3.setNextNode(i4);
        i4.setNextNode(i5);

        Node node = returnNthNodeFromLast(i1, 4);
        System.out.println("nth (4th) node from last: " + node.getItem());

        Node<Integer> i7 = new Node<>(7);
        Node<Integer> i8 = new Node<>(8);
        Node<Integer> i9 = new Node<>(9);

        i7.setNextNode(i8);
        i8.setNextNode(i9);
        i9.setNextNode(i4);

        Node intersectingNode = findIntersectingNode(i1, i7);
        System.out.println("Intersecting node: " + intersectingNode.getItem());

        Node middle = findMiddle(i1);
        System.out.println("Middle node: " + middle.getItem());
    }
}
