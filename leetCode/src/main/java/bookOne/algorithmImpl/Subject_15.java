package bookOne.algorithmImpl;

import bookOne.helperClass.ListNode;

//编写一个函数，检查输入的链表是否是回文的。

/**
 * 简单思路用栈遍历一遍把数据放进栈，然后再遍历一遍比较
 */

/**
 * 可以用快慢指针找到链表的中点
 */
public class Subject_15 {

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.getNext() !=null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        //后半部分倒置
        ListNode later = null;
        while(slow != null) {
            ListNode next = slow.getNext();
            slow.setNext(later);
            later = slow;
            slow = next;
        }
        while(slow!=null) {
            if(slow.getVal() != head.getVal()) {
                return false;
            }
            slow = slow.getNext();
            head = head.getNext();
        }
        return true;
    }
}
