package bookOne.algorithmImpl;

/**
 * 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。
 * 在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。
 * 给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
 */
public class Subject_52 {

    /**
     * 考虑第i个预约有两种状态，一种是接dp[i][1]，一种是不接dp[i][0]
     * 接第i个预约的时候，第i-1个预约肯定是不接，状态转移：dp[i][1] = dp[i-1][0]+nums[i]
     * 不接第i个预约的时候，第i-1个预约可接可不接，状态转移：dp[i][0] = max(dp[i-1][0],dp[i-1][1])
     */

    public int massage(int[] nums) {
        int len = nums.length;
        if(len==0) {
            return 0;
        }
        int dp0=0,dp1=nums[0];
        int dp0t,dp1t;
        //从第2个预约开始计算
        for(int i=1;i <len; i++) {
            //计算第i个不接的状态
            dp0t = Math.max(dp0,dp1);
            //计算第i个预约接的状态
            dp1t = dp0 + nums[i];

            //更新dp0和dp1；
            dp0=dp0t;
            dp1=dp1t;
        }
        return Math.max(dp0,dp1);
    }
}
