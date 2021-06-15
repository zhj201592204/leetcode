package bookOne.algorithmImpl.stageTwo;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个较长字符串big和一个包含较短字符串的数组smalls，设计一个方法，根据smalls中的每一个较短字符串，对big进行搜索。
 * 输出smalls中的字符串在big里出现的所有位置positions，其中positions[i]为smalls[i]出现的所有位置。
 * 输入：
 * big = "mississippi"
 * smalls = ["is","ppi","hi","sis","i","ssippi"]
 * 输出： [[1,4],[8],[],[3],[1,4,7,10],[5]]
 */
public class Stage2_2 {

    public int[][] multiSearch(String big, String[] smalls) {
        int[][] res = new int[smalls.length][];
        int k = 0;
        for(String str : smalls) {
            if("".equals(str)) {
                res[k] = new int[]{};
            }else{
                res[k] = findStr(str,big);
            }
            ++k;
        }
        return res;
    }

    private int[] findStr(String str,String model) {
        List<Integer> res = new ArrayList<>();
        int index = 0;
        while(model.indexOf(str,index) > -1) {
            index = model.indexOf(str,index);
            res.add(index);
            ++index;
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }
}
