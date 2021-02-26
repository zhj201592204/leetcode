package bookOne.algorithmImpl;

import bookOne.helperClass.TreeNode;

/**
 * 二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。实现一个方法，把二叉搜索树转换为单向链表，要求依然符合二叉搜索树的性质，转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。
 *
 * 返回转换后的单向链表的头节点。
 */
public class Subject_51 {

    private TreeNode head = new TreeNode(-1);
    private TreeNode prev = null;
    public TreeNode convertBiNode(TreeNode root) {
        convert(root);
        return head.getRight();
    }

    private void convert(TreeNode root) {
        if(root==null) {
            return;
        }
        convert(root.getLeft());
        if(prev==null) {
            head.setRight(root);
            prev=root;
        }else{
            prev.setRight(root);
            prev=root;
        }
        prev.setLeft(null);
        convert(root.getRight());
    }
}
