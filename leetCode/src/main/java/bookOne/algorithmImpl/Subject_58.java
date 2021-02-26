package bookOne.algorithmImpl;

import java.util.Arrays;

/**
 * 给定两个整数数组a和b，计算具有最小差绝对值的一对数值（每个数组中取一个值），并返回该对数值的差
 */
public class Subject_58 {

    public int smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int alen = a.length;
        int blen = b.length;
        int res = Integer.MAX_VALUE;
        int i=0,j=0;
        long dif;
        while(i<alen && j<blen) {
            dif = Math.abs((long)a[i]-(long)b[j]);
            if(dif <= Integer.MAX_VALUE) {
                res = Math.min(res,(int)dif);
            }
            if(a[i]< b[j]) {
                i++;
            }else {
                j++;
            }
        }
        return res;
    }
}
