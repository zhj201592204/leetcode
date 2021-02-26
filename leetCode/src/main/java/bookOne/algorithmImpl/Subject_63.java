package bookOne.algorithmImpl;

import java.util.Arrays;

/**
 * 给定两个整数数组，请交换一对数值（每个数组中取一个数值），使得两个数组所有元素的和相等。
 *
 * 返回一个数组，第一个元素是第一个数组中要交换的元素，第二个元素是第二个数组中要交换的元素。若有多个答案，返回任意一个均可。若无满足条件的数值，返回空数组。
 *
 */
public class Subject_63 {

    public int[] findSwapValues(int[] array1, int[] array2) {
        int sum1=0,sum2=0;
        int i;
        for(i=0; i<array1.length; i++) {
            sum1 += array1[i];
        }
        for(i=0; i<array2.length; i++) {
            sum2 += array2[i];
        }
        int dif = sum1-sum2;
        Arrays.sort(array1);
        Arrays.sort(array2);
        i=0;
        int j=0;
        while(i<array1.length && j<array2.length) {
            if(dif == 2*(array1[i]-array2[j])) {
                return new int[]{array1[i],array2[j]};
            }
            if(dif > 2*(array1[i]-array2[j])) {
                i++;
            }else {
                j++;
            }
        }
        return new int[]{};
    }
}
