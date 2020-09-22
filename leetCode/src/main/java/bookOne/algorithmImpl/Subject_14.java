package bookOne.algorithmImpl;
//给定两个用链表表示的整数，每个节点包含一个数位。
//这些数位是反向存放的，也就是个位排在链表首部。
//编写函数对这两个整数求和，并用链表形式返回结果。

import bookOne.helperClass.ListNode;

public class Subject_14 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int extra = 0;
        int temp = 0;
        ListNode head = l1;
        ListNode pre1=l1,pre2=l2;
        while(l1 != null && l2 != null) {
            temp = l2.getVal() + l1.getVal() +  extra;
            if(temp < 10) {
                l1.setVal(temp);
                extra = 0;
            }else {
                l1.setVal(temp%10);
                extra = 1;
            }
            pre1 = l1;
            pre2 = l2;
            l1 = l1.getNext();
            l2 = l2.getNext();
        }
        if(l1 == null) {
            pre1.setNext(l2);
            handleExtra(l2,pre2,extra);
        }
        if(l2 == null) {
            handleExtra(l1,pre1,extra);
        }
        return head;
    }

    private void handleExtra(ListNode listNode,ListNode pre, int extra) {
        int temp = 0;
        if(extra == 1) {
            while(listNode != null) {
                temp = listNode.getVal() + extra;
                if(temp < 10) {
                    listNode.setVal(temp);
                    extra = 0;
                    break;
                }else {
                    listNode.setVal(temp%10);
                    extra = 1;
                }
                pre = listNode;
                listNode = listNode.getNext();
            }
            if(extra == 1) {
                pre.setNext(new ListNode(1));
            }
        }
    }
}
