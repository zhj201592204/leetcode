package bookOne.algorithmImpl;

import java.util.Arrays;

/**
 * 马戏团人塔
 * 有个马戏团正在设计叠罗汉的表演节目，一个人要站在另一人的肩膀上。
 * 出于实际和美观的考虑，在上面的人要比下面的人矮一点且轻一点。
 * 已知马戏团每个人的身高和体重，请编写代码计算叠罗汉最多能叠几个人。
 *
 * 此题思路可以先按照身高进行排序，然后查找体重的最长子序列
 */
public class Subject_46 {

    public int bestSeqAtIndex(int[] height, int[] weight) {
        int hl = height.length;
        int[][] person = new int[hl][2];
        for(int i=0; i<hl; i++) {
            person[i] = new int[]{height[i],weight[i]};
        }
        Arrays.sort(person,(a,b) -> a[0] == b[0]? b[1]-a[1] : a[0]-b[0]);
        int[] dp = new int[hl];
        int res = 0;
        for(int j=0; j<hl; j++) {

        }

        return res;
    }
}
