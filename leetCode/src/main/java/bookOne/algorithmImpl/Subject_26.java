package bookOne.algorithmImpl;

import bookOne.helperClass.TreeNode;

/**
 * 实现一个函数，检查二叉树是否平衡。
 * 在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。
 */
public class Subject_26 {

    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        int leftHeight = getTreeHeight(root.getLeft());
        int rightHeight = getTreeHeight(root.getRight());
        if(Math.abs(leftHeight-rightHeight) > 1) {
            return false;
        }
        return isBalanced(root.getLeft()) && isBalanced(root.getRight());
    }

    private int getTreeHeight(TreeNode node) {
        if(node == null) {
            return 0;
        }
        int leftH = getTreeHeight(node.getLeft()) + 1;
        int rightH = getTreeHeight(node.getRight()) + 1;
        return leftH > rightH ? leftH : rightH;
    }
}
