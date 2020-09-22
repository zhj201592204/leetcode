package bookOne.algorithmImpl;
//编写程序以 x 为基准分割链表，使得所有小于 x 的节点排在大于或等于 x 的节点之前。如果链表中包含 x，x 只需出现在小于 x 的元素之后(如下所示)。
// 分割元素 x 只需处于“右半部分”即可，其不需要被置于左右两部分之间。
import bookOne.helperClass.ListNode;

public class Subject_13 {

    public ListNode partition(ListNode head, int x) {
        if(head == null) {
            return null;
        }
        ListNode pre = head;
        ListNode later = head.getNext();
        while(later != null) {
            if(later.getVal() < x) {
                pre.setNext(later.getNext());
                later.setNext(head);
                head = later;
                later = pre.getNext();
            }else {
                pre = later;
                later = later.getNext();
            }
        }
        return head;
    }
}
