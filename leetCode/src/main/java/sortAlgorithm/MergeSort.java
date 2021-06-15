package sortAlgorithm;

/**
 * 归并排序：分冶法
 */
public class MergeSort {

    public void mergeSort(int[] arr) {
        int len = arr.length;
        int[] temp = new int[len];
        recursion(arr,0,len-1,temp);
    }

    //递归归并
    private void recursion(int[] arr,int start,int end,int[] temp) {
        if(start < end) {
            int mid = (start+end)/2;
            //递归 分 左半边
            recursion(arr,start,mid,temp);
            //递归 分 右半边
            recursion(arr,mid+1,end,temp);
            //冶 :合并两个待排序部分
            merge(arr,start,mid,end,temp);
        }
    }

    private void merge(int[] arr,int start,int mid,int end,int[] temp) {
        int i=start,j=mid+1;
        int k=0;
        while(i <= mid && j <= end) {
            if(arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            }else {
                temp[k++] = arr[j++];
            }
        }
        while(i <= mid) {
            temp[k++] = arr[i++];
        }
        while(j <= end) {
            temp[k++] = arr[j++];
        }
        k=0;
        while(start <= end) {
            arr[start++] = temp[k++];
        }
    }
}
