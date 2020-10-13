package bookOne.algorithmImpl;

import bookOne.helperClass.ListNode;
//给定两个（单向）链表，判定它们是否相交并返回交点。请注意相交的定义基于节点的引用，而不是基于节点的值。
// 换句话说，如果一个链表的第k个节点与另一个链表的第j个节点是同一节点（引用完全相同），则这两个链表相交。

/**
 * 双指针，若headA和headB相交，那么指针P1沿着 A + B 和P2沿着 B + A到达的第二个交点的长度一样，否则到末尾为空没有交点
 */
public class Subject_16 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA,p2 = headB;
        while(p1 != p2) {
            p1 = (p1==null)?headB : p1.getNext();
            p2 = (p2==null)?headA : p2.getNext();
        }
        return p1;
    }
}
