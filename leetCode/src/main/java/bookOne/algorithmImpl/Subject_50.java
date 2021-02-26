package bookOne.algorithmImpl;

/**
 * 数组中占比超过一半的元素称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。
 */
public class Subject_50 {

    public int majorityElement(int[] nums) {
        int len=nums.length;
        if(len == 0) {
            return -1;
        }
        if(len == 1) {
            return nums[0];
        }
        int count = 1;
        int max = nums[0];
        int i;
        for(i=1; i<len; i++) {
            if(nums[i] == max) {
                ++count;
            }else {
                --count;
                if(count < 1) {
                    max=nums[i];
                    count=1;
                }
            }
        }
        count=0;
        for(i=0; i< len; i++) {
            if(nums[i] == max) {
                ++count;
            }
        }
        if(count*2 > len) {
            return max;
        }
        return -1;
    }
}
