package bookOne.algorithmImpl;

import bookOne.helperClass.ListNode;

import java.util.HashSet;
import java.util.Set;

//编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。

/**
 * 使用一个set集合 来存储 链表中的数据，从而达到筛选目的，减少内存的使用也就是想办法减少用来存储的方法
 * Set：检索元素效率低下，删除和插入效率高，插入和删除不会引起元素位置改变。
 * List：和数组类似，List可以动态增长，查找元素效率高，插入删除元素效率低，因为会引起其他元素位置改变。
 */
public class Subject_10 {

    public ListNode removeDuplicateNodes(ListNode head) {
        if(head.getNext() == null) {
            return head;
        }
        Set<Integer> data = new HashSet<>();
        ListNode p = head;//结果链
        while(p != null && p.getNext() != null) {
            data.add(p.getVal());
            if(data.contains(p.getNext().getVal())) {//data包含下一个值，跳过下一个listNode
                p.setNext(p.getNext().getNext());
            }else{
                p = p.getNext();
            }
        }
        return head;
    }

}


