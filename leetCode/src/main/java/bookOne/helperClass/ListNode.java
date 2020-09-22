package bookOne.helperClass;

public class ListNode {

    private int val;
    private ListNode next;

    public ListNode(int x) { val = x; next=null;}

    public int getVal() {
        return this.val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

}
