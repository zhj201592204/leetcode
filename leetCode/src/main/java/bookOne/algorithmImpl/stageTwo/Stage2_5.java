package bookOne.algorithmImpl.stageTwo;

public class Stage2_5 {

    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int res = 0;
        if(len < 2) {
            return len;
        }
        int i;
        for(i=0; i<len-1; i++) {
            if(nums[i] == nums[i+1]) {
                while(i < len-1 && nums[i] == nums[i+1]) {
                    ++i;
                }
                nums[res++] = nums[i];
            }
        }
        //最后一位
        if(i == len) {
            if(nums[i-1] != nums[i-2]) {
                nums[res++] = nums[i-1];
            }
        }else {
            if(nums[i] != nums[i-1]) {
                nums[res++] = nums[i];
            }
        }
        return res;
    }
}
