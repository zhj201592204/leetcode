package bookOne.algorithmImpl;

import java.util.*;

/**
 * 有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。
 * 注意，不是必须有这些素因子，而是必须不包含其他的素因子。
 * 例如，前几个数按顺序应该是 1，3，5，7，9，15，21。
 *
 */
public class Subject_69 {

    public int getKthMagicNumber(int k) {
        int[] dp = new int[k];
        dp[0] = 1;
        int threeX=0,fiveX=0,sevenX=0;
        for(int i=1; i<k; i++) {
            dp[i] = Math.min(Math.min(dp[threeX]*3,dp[fiveX]*5),dp[sevenX]*7);
            if(dp[i] == dp[threeX] * 3) {
                ++threeX;
            }
            if(dp[i] == dp[fiveX] * 5) {
                ++fiveX;
            }
            if(dp[i] == dp[sevenX] * 7) {
                ++sevenX;
            }
        }
        return dp[k-1];
    }
}
