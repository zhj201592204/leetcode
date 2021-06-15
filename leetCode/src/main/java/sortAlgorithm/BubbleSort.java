package sortAlgorithm;

import java.util.List;

/**
 * 冒泡排序
 */
public class BubbleSort {

    public <T extends Comparable> void bubbleSort(List<T> arr) {
        T temp;
        for(int i=0; i<arr.size()-1; i++) {
            //每次排好一个数，待排序中最大的
//            for(int j=0; j<arr.size()-1-i; j++) {
//                if(arr.get(j).compareTo(arr.get(j+1)) > 0) {
//                    temp = arr.get(j);
//                    arr.set(j,arr.get(j+1));
//                    arr.set(j+1,temp);
//                }
//            }
            //每次排好一个数，待排序中最小的
            for(int j = i+1; j<arr.size(); j++) {
                if(arr.get(j).compareTo(arr.get(i)) < 0) {
                    temp = arr.get(i);
                    arr.set(i,arr.get(j));
                    arr.set(j,temp);
                }
            }
        }
    }
}
