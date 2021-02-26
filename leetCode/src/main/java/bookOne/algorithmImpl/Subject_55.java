package bookOne.algorithmImpl;

import java.util.Arrays;

/**
 * 在一个整数数组中，“峰”是大于或等于相邻整数的元素，相应地，“谷”是小于或等于相邻整数的元素。
 * 例如，在数组{5, 8, 4, 2, 3, 4, 6}中，{8, 6}是峰， {5, 2}是谷。现在给定一个整数数组，将该数组按峰与谷的交替顺序排序。
 */
public class Subject_55 {

    public void wiggleSort(int[] nums) {
        int len = nums.length;
        int[] temp = new int[len];
        System.arraycopy(nums,0,temp,0,len);
        Arrays.sort(temp);
        int i=0,k=len-1;
        int index=0;
        while(i<k) {
            nums[index++]=temp[k--];
            nums[index++]=temp[i++];
        }
        //原数组数量为奇数
        if(i==k) {
            nums[index]=temp[i];
        }
    }
}
