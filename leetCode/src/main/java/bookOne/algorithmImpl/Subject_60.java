package bookOne.algorithmImpl;

import java.util.Arrays;

/**
 * 给定一个整数数组，编写一个函数，找出索引m和n，只要将索引区间[m,n]的元素排好序，整个数组就是有序的。
 * 注意：n-m尽量最小，也就是说，找出符合条件的最短序列。函数返回值为[m,n]，
 * 若不存在这样的m和n（例如整个数组是有序的），请返回[-1,-1]。
 */
public class Subject_60 {

    public int[] subSort(int[] array) {
        int len = array.length;
        if(len<3) {
            return new int[]{-1,-1};
        }
        int result;
        int[] temp = new int[len];
        int i;
        for(i=0; i<len; i++) {
            temp[i] = array[i];
        }
        Arrays.sort(temp);
        int sindex=-1,eindex=-1;
        for(i=0; i<len; i++) {
            if(array[i] != temp[i]) {
                sindex=i;
                break;
            }
        }
        for(i=len-1; i>=0; i--) {
            if(array[i] != temp[i]) {
                eindex=i;
                break;
            }
        }
        return new int[]{sindex,eindex};
    }
}
