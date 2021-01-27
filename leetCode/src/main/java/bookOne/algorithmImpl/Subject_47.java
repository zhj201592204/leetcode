package bookOne.algorithmImpl;

import java.util.Arrays;

/**
 * 堆箱子。给你一堆n个箱子，箱子宽 wi、深 di、高 hi。
 * 箱子不能翻转，将箱子堆起来时，下面箱子的宽度、高度和深度必须大于上面的箱子。
 * 实现一种方法，搭出最高的一堆箱子。箱堆的高度为每个箱子高度的总和。
 *
 * 输入使用数组[wi, di, hi]表示每个箱子。
 */
public class Subject_47 {

    public int pileBox(int[][] box) {
        Arrays.sort(box,(a,b) -> a[0]==b[0]? a[1]==b[1]?b[2]-a[2]:b[1]-a[1] : a[0]-b[0]);
        int len = box.length;
        int[] dp_val = new int[len];
        dp_val[0] = box[0][2];
        int res=dp_val[0];
        for(int i=1; i<len; i++){
            int max = 0,base_dep = box[i][1],base_hei = box[i][2];
            for(int j=0; j<i ;j++) {
                if(base_dep > box[j][1] && base_hei > box[j][2]) {
                    //？
                    max = Math.max(max,dp_val[j]);
                }
            }
            dp_val[i] = max + base_hei;
            res = Math.max(res,dp_val[i]);
        }
        return res;
    }
}
