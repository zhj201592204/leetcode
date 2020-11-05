package bookOne.algorithmImpl;

import bookOne.helperClass.TreeNode;

/**
 * 给定一棵二叉树，其中每个节点都含有一个整数数值(该值或正或负)。
 * 设计一个算法，打印节点数值总和等于某个给定值的所有路径的数量。注意，路径不一定非得从二叉树的根节点或叶节点开始或结束，但是其方向必须向下(只能从父节点指向子节点方向)。
 *
 */
public class Subject_32 {

    public int pathSum(TreeNode root, int sum) {
        if(root == null) {
            return 0;
        }
        int rootPathSum = path(root,sum,0,0);//计算根节点
        return rootPathSum + pathSum(root.getLeft(),sum) + pathSum(root.getRight(),sum);
    }

    //从一个节点开始遍历到叶子节点，计算以这个节点为根节点开始的路径数量
    private int path(TreeNode root, int sum, int _sum, int totalPath) {
        if(root == null) {//找到一个叶子节点，返回数量
            return 0;
        }
        _sum += root.getVal();
        if(_sum == sum) {
            totalPath++;
        }
        return totalPath + path(root.getLeft(),sum,_sum,0) + path(root.getRight(),sum,_sum,0);
    }
}
