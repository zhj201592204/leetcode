package bookOne.algorithmImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * 幂集。编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 注意：在for循环里面计算大小将消耗大量的内存，
 * for(int i = 0; i < array.size(); i++)  比
 * int size = array.size();
 * for(int i= 0; i < size; i++)消耗的内存要大很多
 *
 * 此题将24行代码放入25行内就会超出内存限制，但是下面这种写法内存消耗接近最优
 * 第二，递推的思想：
 *
 * 求幂集递推：
 * 如果是空集，则所有的子集是空集
 * 若含一个元素，则，在空集的所有子集中加上这个元素，再加上空集的所有子集为当前子集，
 * 若含有两个元素，则，在上一个所有子集中加上第二个元素，再加上上一个所有的子集为当前子集
 */
public class Subject_36 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());//加上空集，任何一个集合的子集
        for(int num : nums) {
            int size = result.size();
            for(int i=0; i<size; i++) {//给每一个所有的子集加上下一个新的元素
                List<Integer> ans = new ArrayList<>();
                ans.addAll(result.get(i));
                ans.add(num);
                result.add(ans);
            }
        }
        return result;
    }
}
