package bookOne.algorithmImpl;
//给定一个链表，如果它是有环链表，实现一个算法返回环路的开头节点。
//有环链表的定义：在链表中某个节点的next元素指向在它前面出现过的节点，则表明该链表存在环路。

import bookOne.helperClass.ListNode;

/**
 * 快慢指针，如果有环，则快慢指针会相遇，相遇在环内
 * 可以证明，若快慢指针相遇，其中一个指针从头开始，另一个指针从相遇点开始，经过相同的步长会到达入口
 */
public class Subject_17 {

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head,fast = head;
        while(fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if(slow == fast) {
                slow = head;
                while(slow != fast) {
                    slow = slow.getNext();
                    fast = fast.getNext();
                }
                return slow;
            }
        }
        return null;
    }
}
