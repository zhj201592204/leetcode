package sortAlgorithm;

import java.util.List;

/**
 * 快速排序
 */
public class QuickSort {

    public <T extends Comparable> void quickSort(List<T> arr,int start,int end) {
        if(start < end) {
            int s = start,e = end;
            T flag = arr.get(start);
            while( s < e) {
                //从后往前找到第一个比flag小的
                while(s < e && arr.get(e).compareTo(flag) >= 0) {
                    --e;
                }
                if(s < e) {
                    arr.set(s,arr.get(e));
                    ++s;
                }
                //从前往后找第一个比flag大的
                while(s < e && arr.get(s).compareTo(flag) <= 0) {
                    ++s;
                }
                if(s < e) {
                    arr.set(e,arr.get(s));
                    --e;
                }
            }
            arr.set(s,flag);
            quickSort(arr,start,s-1);
            quickSort(arr,s+1,end);
        }
    }
}
