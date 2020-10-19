package bookOne.algorithmImpl;

import bookOne.helperClass.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * 从左向右遍历一个数组，通过不断将其中的元素插入树中可以逐步地生成一棵二叉搜索树。
 * 给定一个由不同节点组成的二叉搜索树，输出所有可能生成此树的数组。
 *

 * 全排列：
 * //定义好结果集
 * List<...> res = ...
 * void dfs(int level,...){
 *     //1.设定终止条件
 *     if(level达到遍历的最高层数) ....return;
 *
 *     //2.对当前层数能够访问的元素进行遍历
 *     for(){
 *         ...
 *         //3.1 最关键的一步，设定访问标记，防止重复访问
 *         dfs(level+1,访问标记数组);
 *         //3.2 擦除访问标记
 *     }
 *
 * }
 *

 * 回溯算法
 */
public class Subject_30 {

    private List<List<Integer>> resultList = new ArrayList<>();
    private LinkedList<Integer> tempList = new LinkedList<>();

    public List<List<Integer>> BSTSequences(TreeNode root) {
        if(root == null) {
            resultList.add(tempList);
            return resultList;
        }
        HashSet<TreeNode> curLevel = new HashSet<>();
        curLevel.add(root);
        dfs(curLevel);
        return resultList;
    }

    private void dfs(HashSet<TreeNode> curLevel) {
        if(curLevel.size() == 0) {
            resultList.add(new LinkedList<Integer>(tempList));
            return ;
        }
        HashSet<TreeNode> nextLevel = new HashSet<>(curLevel);
        for(TreeNode treeNode : curLevel) {
            tempList.add(treeNode.getVal());
            nextLevel.remove(treeNode);
            if(treeNode.getLeft() != null) {
                nextLevel.add(treeNode.getLeft());
            }
            if(treeNode.getRight() != null) {
                nextLevel.add(treeNode.getRight());
            }
            dfs(nextLevel);
            if(treeNode.getLeft()!=null)nextLevel.remove(treeNode.getLeft());
            if(treeNode.getRight()!=null)nextLevel.remove(treeNode.getRight());
            nextLevel.add(treeNode);
            tempList.removeLast();
        }
    }
}
