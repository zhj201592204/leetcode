package bookOne.algorithmImpl;
//实现一种算法，删除单向链表中间的某个节点（即不是第一个或最后一个节点），假定你只能访问该节点。

import bookOne.helperClass.ListNode;

public class Subject_12 {

    /**
     * 把当前节点的下一节点值赋值给当前节点，
     * 然后删除下一个节点：把当前节点的下一个节点修改为下一个节点的下一个节点，达成删除当前节点的目的
     */
    public void deleteNode(ListNode node) {
        ListNode temp = node.getNext();
        node.setVal(temp.getVal());
        node.setNext(temp.getNext());
    }
}
