package bookOne.algorithmImpl;

import bookOne.helperClass.TreeNode;

/**
 * 检查子树。你有两棵非常大的二叉树：T1，有几万个节点；T2，有几万个节点。设计一个算法，判断 T2 是否为 T1 的子树。
 *
 * 如果 T1 有这么一个节点 n，其子树与 T2 一模一样，则 T2 为 T1 的子树，也就是说，从节点 n 处把树砍断，得到的树与 T2 完全相同。
 */
public class Subject_31 {

    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if(t1 == null || t2 == null) {
            return false;
        }
        if(isSubTree(t1,t2)) {
            return true;
        }
        return checkSubTree(t1.getLeft(),t2) || checkSubTree(t1.getRight(),t2);
    }

    private boolean isSubTree(TreeNode t1,TreeNode t2) {
        if(t1 == null && t2 == null) {//都到了叶子节点
            return true;
        }
        if(t1 == null || t2 == null) {
            return false;
        }
        return t1.getVal() == t2.getVal() && isSubTree(t1.getLeft(),t2.getLeft()) && isSubTree(t1.getRight(),t2.getRight());
    }
}
