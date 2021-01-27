package bookOne.algorithmImpl;

/**
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 */
public class Subject_45 {

    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if(len == 0) {
            return 0;
        }
        int dp[] = new int[len];
        int res = 0;
        for(int i=0; i<len; i++) {
            for(int j=0; j<i; j++) {
                //新加入的数字一次和前面一个作比较，如果比前面的值小，则状态转移
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            //更新最长子序列长度
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
