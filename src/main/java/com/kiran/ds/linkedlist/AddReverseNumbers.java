package com.kiran.ds.linkedlist;

public class AddReverseNumbers {

    public static void main (String[] args) {
//        ListNode l1 = new ListNode (2, new ListNode (4, new ListNode (3)));
//        ListNode l2 = new ListNode (5, new ListNode (6, new ListNode (4)));
        ListNode l1 = new ListNode (9);
        ListNode l2 = new ListNode (1, new ListNode (9, new ListNode (9, new ListNode (9, new ListNode (9, new ListNode (9, new ListNode (9, new ListNode (9, new ListNode (9, new ListNode (9, new ListNode (9)))))))))));
        ListNode node = addTwoNumbers (l1, l2);
        while(node != null) {
            System.out.print (node.val + ", ");
            node = node.next;
        }

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long sum = getNumber(l1) + getNumber(l2);
        ListNode node = null;
        ListNode head = new ListNode(-1);
        do {
            int val = Long.valueOf (sum % 10).intValue ();
            sum /= 10;
            if(node == null) {
                node = new ListNode(val);
                head.next = node;
            } else {
                node.next = new ListNode(val);
                node = node.next;
            }

        } while(sum != 0);
        return head.next;
    }

    private static long getNumber(ListNode l) {
        long i = 1;
        long sum = 0;
        while(l != null) {
            sum += l.val * i;
            i *= 10;
            l = l.next;
        }
        return sum;
    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode node = null;
        ListNode head = new ListNode(-1);
        int carryOver = 0;
        while(l1 != null || l2 !=null || carryOver > 0) {
            int sum = 0;
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            if(carryOver > 0) {
                sum += carryOver;
            }
            carryOver = sum / 10;
            sum = sum % 10;

            if(node == null) {
                node = new ListNode(sum);
                head.next = node;
            } else {
                node.next = new ListNode(sum);
                node = node.next;
            }
        }
        return head.next;
    }

    public static ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        ListNode node = new ListNode();
        ListNode head = node;
        ListNode previous = head;
        int carryOver = 0;
        while(l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carryOver;
            carryOver = sum / 10;
            sum %= 10;
            node.val = sum;
            node.next = new ListNode();
            previous = node;
            node = node.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null) {
            int sum = 0;
            sum += l1.val + carryOver;
            carryOver = sum/10;
            sum %= 10;
            node.val = sum;
            node.next = new ListNode();
            previous = node;
            node = node.next;
            l1 = l1.next;
        }

        while(l2 != null) {
            int sum = 0;
            sum += l2.val + carryOver;
            carryOver = sum/10;
            sum %= 10;
            node.val = sum;
            node.next = new ListNode();
            previous = node;
            node = node.next;
            l2 = l2.next;
        }

        if(carryOver > 0) {
            node.val = carryOver;
        }

        if(node.val == 0) {
            previous.next = null;
        }

        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode () {
    }

    ListNode (int val) {
        this.val = val;
    }

    ListNode (int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}