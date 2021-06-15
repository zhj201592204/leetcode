package bookOne.algorithmImpl.stageTwo;

import java.util.HashMap;
import java.util.Map;

/**
 * 假设你有两个数组，一个长一个短，短的元素均不相同。找到长数组中包含短数组所有的元素的最短子数组，其出现顺序无关紧要。
 *
 * 返回最短子数组的左端点和右端点，如有多个满足条件的子数组，返回左端点最小的一个。若不存在，返回空数组。
 */
public class Stage2_3 {

    public int[] shortestSeq(int[] big, int[] small) {
        if(small.length > big.length) {
            return new int[0];
        }
        int[] res = new int[]{0,big.length-1};
        Map<Integer,Integer> data = new HashMap<>();
        int minIndex;
        //先把所有的元素放到Map里
        for(int i : small) {
            data.put(i,-1);
        }
        int count = small.length;
        for(int i=0; i<big.length; i++) {
            //Map的遍历速度比数组快很多
            //这里如果改成遍历数组再更新Map就会超时
            if(data.containsKey(big[i])) {
                if(data.get(big[i]) == -1) {
                    --count;
                }
                data.put(big[i],i);
               //如果已包含全部的元素，计算最小的下标，更新结果值
                minIndex = Integer.MAX_VALUE;
                if(count <= 0) {
                    for(Integer key : data.keySet()) {
                        minIndex = Math.min(minIndex,data.get(key));
                    }
                    if(i-minIndex < res[1]-res[0]) {
                        res[0] = minIndex;
                        res[1] = i;
                    }
                }
            }
        }
        if(count > 0) {
            return new int[0];
        }
        return res;
    }
}
