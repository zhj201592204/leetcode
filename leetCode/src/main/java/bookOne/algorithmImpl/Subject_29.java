package bookOne.algorithmImpl;

import bookOne.helperClass.TreeNode;

/**
 * 设计并实现一个算法，找出二叉树中某两个节点的第一个共同祖先。
 * 不得将其他的节点存储在另外的数据结构中。注意：这不一定是二叉搜索树。
 */
public class Subject_29 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p==root || q==root) {
            return root;
        }
        boolean lp;
        boolean lq;
        if(root.getLeft() != null) {
            lp = isParent(root.getLeft(),p);
            lq = isParent(root.getLeft(),q);
        }else{
            lp = isParent(root.getRight(),p);
            lq = isParent(root.getRight(),q);
        }
        if(lp && lq) {//都在左子树
            if(root.getLeft() == p) {
                return p;
            }
            if(root.getLeft() == q) {
                return q;
            }
            return lowestCommonAncestor(root.getLeft(),p,q);
        }
        if(!lp && !lq) {//都在右子树
            if(root.getRight() == p) {
                return p;
            }
            if(root.getRight() == q) {
                return q;
            }
            return lowestCommonAncestor(root.getRight(),p,q);
        }
        //在不同子树
        return root;
    }

    private boolean isParent(TreeNode root,TreeNode p) {
        boolean flag1 = false;
        boolean flag2 = false;
        if(root == p) {
            return true;
        }
        if(root != null) {
            flag1 = isParent(root.getLeft(),p);
            flag2 = isParent(root.getRight(),p);
        }
        return flag1 || flag2;
    }
}
