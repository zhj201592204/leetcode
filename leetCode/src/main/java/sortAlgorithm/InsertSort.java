package sortAlgorithm;

import java.util.List;

/**
 * 插入排序
 */
public class InsertSort {

    public <T extends Comparable> void insertSort(List<T> arr) {
        for(int i=1; i<arr.size(); i++) {
            int j=i;
            T temp = arr.get(j);
            while(j>0 && temp.compareTo(arr.get(j-1)) < 0) {
                arr.set(j,arr.get(j-1));
                --j;
            }
            arr.set(j,temp);
        }
    }
}
