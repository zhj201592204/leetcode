package bookOne.helperClass;

public class TreeNode {
    private int val;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int x) { val = x; left=null; right=null;}

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
