package bookOne.algorithmImpl;

import bookOne.helperClass.TreeNode;

import java.util.Stack;

/**
 * 设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
 *
 * 如果指定节点没有对应的“下一个”节点，则返回null。
 */
public class Subject_28 {

    /**
     * 第一种情况：P有右子树，则后继节点为右子树的最左边的节点
     * 第二种情况：P没有右子树，若A节点的左子树的最右边的节点是P，则A是P的后继节点
     * 可以用栈来存储查找P的过程中遇到的所有父节点来应对第二种情况
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode temp = root;
        TreeNode tempParent = root;
        Stack<TreeNode> path = new Stack<>();
        while(temp != p) {
            if(p.getVal() < temp.getVal()) {
                tempParent = temp;
                path.push(tempParent);
                temp = temp.getLeft();
            }else {
                tempParent = temp;
                path.push(tempParent);
                temp = temp.getRight();
            }
        }
        if(temp.getRight() == null) {
            while(!path.isEmpty()) {
                tempParent = path.pop();
                if(tempParent.getLeft() == temp) {
                    return tempParent;
                }else{
                    temp = tempParent;
                }
            }
            return null;
        }
        temp = p.getRight();
        while(temp.getLeft() != null) {
            temp = temp.getLeft();
        }
        return temp;
    }
}
