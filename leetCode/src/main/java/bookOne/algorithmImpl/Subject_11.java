package bookOne.algorithmImpl;

import bookOne.helperClass.ListNode;

import java.util.HashMap;

//实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
/**
 * 我最开始的思路：遍历一次链表，将下标和对应节点的值存在散列表里，然后取值
 * 运行时间和内存占用都不理想
 */
/**
 * 此题最优解是快慢指针法
 * 两个指针同时指向head，现将第一个指针向后移动K次，这样两个指针之间的距离为K
 * 同时移动两个指针，第一个指针指向尾部的时候，第二个指针即为所求值
 */
public class Subject_11 {

    public int kthToLast(ListNode head, int k) {
        ListNode pre = head;
        ListNode later = head;
        for(int i=0; i<k; i++) {
            later = later.getNext();
        }
        while(later!=null) {
            pre = pre.getNext();
            later = later.getNext();
        }
        return pre.getVal();
    }
}
