package bookOne.algorithmImpl;

import java.util.Arrays;

/**
 * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
 *
 * 初始化 A 和 B 的元素数量分别为 m 和 n。
 */
public class Subject_48 {

    public void merge(int[] A, int m, int[] B, int n) {
        int[] temp = Arrays.copyOf(A,A.length);
        int i=0,j=0,k=0;
        for( ;j<n; ) {
            if(m==0 || (temp[i+1] < temp[i])) {
                break;
            }
            if(temp[i] <= B[j]) {
                A[k++]=temp[i++];
            }else{
                A[k++]=B[j++];
            }
        }
        if(j < n) {
            while(j<n) {
                A[k++]=B[j++];
            }
        }else{
            while(i<m) {
                A[k++]=temp[i++];
            }
        }
    }
}
