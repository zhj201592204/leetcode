package sortAlgorithm;

import java.util.List;

/**
 * 希尔排序，先按照一个增量对待排序数据进行分组，组内进行排序，逐步缩小增量，当增量为1时排序完成
 */
public class ShellSort {

    public <T extends Comparable> void shellSort(List<T> arr) {
        //增量分组
        for(int gap = arr.size()/2; gap>0; gap/=2) {

            //组内排序,插入
            for(int i=gap; i<arr.size(); i++) {
                int j=i;
                T temp = arr.get(j);
                while(j-gap >= 0 && temp.compareTo(arr.get(j-gap)) < 0) {
                    arr.set(j,arr.get(j-gap));
                    j-=gap;
                }
                arr.set(j,temp);
            }
        }
    }
}
