package bookOne.algorithmImpl;

import bookOne.helperClass.TreeNode;

/**
 * 实现一个函数，检查一棵二叉树是否为二叉搜索树。
 * 此题目测试用例中，不允许出现重复的元素
 */
public class Subject_27 {

    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        if(root.getLeft() != null) {
            if(root.getLeft().getVal() >= root.getVal()) {
                return false;
            }
            TreeNode tempL = root.getLeft();
            while(tempL.getRight() != null) {
                tempL = tempL.getRight();
                if(tempL.getVal() >= root.getVal()) {
                    return false;
                }
            }
        }
        if(root.getRight() != null) {
            if(root.getRight().getVal() <= root.getVal()) {
                return false;
            }
            TreeNode tempR = root.getRight();
            while(tempR.getLeft() != null) {
                tempR = tempR.getLeft();
                if(tempR.getVal() <= root.getVal()) {
                    return false;
                }
            }
        }
        return isValidBST(root.getLeft()) && isValidBST(root.getRight());
    }
}
