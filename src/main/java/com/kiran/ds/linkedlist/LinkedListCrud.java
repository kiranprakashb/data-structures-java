package com.kiran.ds.linkedlist;

public class LinkedListCrud {

    /**
     * Traverse the LinkedList until you find the node with data greater than data in the new node.  Hold pointers to current and previous nodes.
     * Once found point the next node of previous node to new node and point the next node of the new node to current node.
     */
    private static Node insertNodeInSortedLinkedList(Node<Integer> head, Node<Integer> newNode) {
        Node<Integer> current = head;
        Node<Integer> previous = head;
        while(current.getNextNode() != null && current.getItem() < newNode.getItem()) {
            previous = current;
            current = current.getNextNode();
        }
        newNode.setNextNode(current);
        previous.setNextNode(newNode);
        return head;
    }

    /**
     * Have 3 pointers, previous, current and next.  Traverse the LinkedList and point next node of current node to previous node, previous points to current, current points to next.
     * Previous pointer at the end contains head of the reversed LinkedList.
     */
    private static Node reverseLinkedList(Node head) {
        Node previous = null;
        Node current = head;
        while(current != null) {
            Node next = current.getNextNode();
            current.setNextNode(previous);
            previous = current;
            current = next;
        }
        return previous;
    }

    /**
     * Recursively move to the end of the list.  Return when the head points to null (as last node will point to null).  While returning print all the nodes.
     */
    private static void printListFromEnd(Node head) {
        if(head == null) {
            return;
        }
        printListFromEnd(head.getNextNode());
        System.out.print(head.getItem() + " ");
    }

    private static String isListLengthOddOrEven(Node head) {
        while(head != null && head.getNextNode() != null) {
            head = head.getNextNode().getNextNode();
        }
        return head == null ? "even" : "odd";
    }

    private static Node mergeTwoLists(Node<Integer> head1, Node<Integer> head2) {
        Node<Integer> head;
        Node<Integer> curr;
        if(head1.getItem() < head2.getItem()) {
            head = head1;
            head1 = head1.getNextNode();
        } else {
            head = head2;
            head2 = head2.getNextNode();
        }
        curr = head;
        while(head1 != null && head2 != null) {
            if(head1.getItem() < head2.getItem()) {
                head.setNextNode(head1);
                head1 = head1.getNextNode();
            } else if(head2.getItem() < head1.getItem()) {
                head.setNextNode(head2);
                head2 = head2.getNextNode();
            }
            head = head.getNextNode();
        }
        return curr;
    }

    public static void main(String[] args) {
        Node<Integer> i1 = new Node<>(1);
        Node<Integer> i2 = new Node<>(2);
        Node<Integer> i4 = new Node<>(4);
        Node<Integer> i5 = new Node<>(5);
        Node<Integer> i6 = new Node<>(6);

        i1.setNextNode(i2);
        i2.setNextNode(i4);
        i4.setNextNode(i5);
        i5.setNextNode(i6);

        Node<Integer> i3 = new Node<>(3);
        Node head = insertNodeInSortedLinkedList(i1, i3);
        System.out.println(head.getItem() + ": inserted");

        Node revHead = reverseLinkedList(i1);
        System.out.println(revHead.getItem() + ": head of reversed list");

        System.out.print("Reversed List: ");
        printListFromEnd(revHead);
        System.out.println("");

        String oddOrEven1 = isListLengthOddOrEven(revHead);
        System.out.println("Odd or Even: " + oddOrEven1);

        String oddOrEven2 = isListLengthOddOrEven(revHead.getNextNode());
        System.out.println("Odd or Even: " + oddOrEven2);

        Node<Integer> n1 = new Node<>(1);
        Node<Integer> n3 = new Node<>(3);
        Node<Integer> n5 = new Node<>(5);
        Node<Integer> n7 = new Node<>(7);

        n1.setNextNode(n3);
        n3.setNextNode(n5);
        n5.setNextNode(n7);

        Node<Integer> n2 = new Node<>(2);
        Node<Integer> n4 = new Node<>(4);
        Node<Integer> n6 = new Node<>(6);
        Node<Integer> n8 = new Node<>(8);

        n2.setNextNode(n4);
        n4.setNextNode(n6);
        n6.setNextNode(n8);

        Node mergeList = mergeTwoLists(n1, n2);
    }
}
