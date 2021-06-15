package sortAlgorithm;

import java.util.List;

/**
 * 堆排序
 */
public class HeapSort {

    public <T extends Comparable> void heapSort(T[] arr) {
        //建立最大堆
        int len = arr.length;
        buildMaxHeap(arr,len);
        for(int i=len -1; i>0; --i) {
            swap(arr,0,i);
            buildMaxHeap(arr,i);
        }
    }

    private <T extends Comparable> void buildMaxHeap(T[] arr,int len) {
        for(int i=len/2; i>=0; --i) {
            int left = i*2+1,right=i*2+2;
            if(left < len && arr[left].compareTo(arr[i]) > 0) {
                swap(arr,left,i);
            }
            if(right < len && arr[right].compareTo(arr[i]) > 0) {
                swap(arr,right,i);
            }
        }
    }

    private <T extends Comparable> void swap(T[] arr,int large,int cur) {
        T temp = arr[cur];
        arr[cur] = arr[large];
        arr[large] = temp;
    }
}
