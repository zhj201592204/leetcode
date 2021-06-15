package sortAlgorithm;

import java.util.List;

/**
 * 选择排序
 */
public class SelectSort {

    public <T extends Comparable> void selectSort(List<T> arr) {
        for(int i=0; i<arr.size(); i++) {
            int minIndex = i;
            T min = arr.get(i);
            for(int j=i+1; j<arr.size(); j++) {
                if(arr.get(j).compareTo(min) < 0) {
                    min = arr.get(j);
                    minIndex = j;
                }
            }
            arr.set(minIndex,arr.get(i));
            arr.set(i,min);
        }
    }
}
