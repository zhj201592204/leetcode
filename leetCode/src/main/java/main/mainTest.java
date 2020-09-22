package main;


import bookOne.algorithmImpl.*;
import bookOne.helperClass.ListNode;

public class mainTest {
        public static void main(String[] args){

            Subject_14 subject_14 = new Subject_14();

            ListNode head = new ListNode(6);
            ListNode node1 = new ListNode(5);
            ListNode node2 = new ListNode(4);
            ListNode node3 = new ListNode(3);
            ListNode node4 = new ListNode(2);
            ListNode node5 = new ListNode(1);
            head.setNext(node1);
            node1.setNext(node2);
            node2.setNext(node3);
            node3.setNext(node4);
            node4.setNext(node5);

            ListNode head1 = new ListNode(9);
            ListNode node6 = new ListNode(9);
            head1.setNext(node6);

            ListNode head2 = new ListNode(1);

            ListNode result = subject_14.addTwoNumbers(head1,head2);
            while(result != null) {
                System.out.println(result.getVal());
                result = result.getNext();
            }
        }
}
