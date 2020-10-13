package bookOne.algorithmImpl;


import bookOne.helperClass.TreeNode;

/**
 * 给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
 *\
 */
public class Subject_24 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return defs(nums,0,nums.length-1);
    }

    private TreeNode defs(int[] nums,int low, int high) {
        int middle = (low+high)/2;
        if(low == high) {
            return new TreeNode(nums[low]);
        }
        if(low > high) {
            return null;
        }
        TreeNode root = new TreeNode(nums[middle]);
        root.setLeft(defs(nums,low,middle-1));
        root.setRight(defs(nums,middle+1,high));
        return root;
    }
}
