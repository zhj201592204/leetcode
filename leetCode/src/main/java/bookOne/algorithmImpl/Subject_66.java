package bookOne.algorithmImpl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个放有字符和数字的数组，找到最长的子数组，且包含的字符和数字的个数相同。
 *
 * 返回该子数组，若存在多个最长子数组，返回左端点下标值最小的子数组。
 * 若不存在这样的数组，返回一个空数组。
 *
 * 输入: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K","L","M"]
 * 输出: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7"]
 *
 */
public class Subject_66 {

    public String[] findLongestSubarray(String[] array) {
        int len = array.length;
        int[] dif = new int[len];
        Map<Integer,Integer> data = new HashMap<>();
        int mx=0,sindex=-1,eindex=-1;
        int count=0;
        int k=0;
        for(String s : array) {
            boolean is_num = true;
            for(char c : s.toCharArray()) {
                if(c<'0' || c>'9') {
                    is_num = false;
                    break;
                }
            }
            count += is_num?-1:1;
            dif[k++]=count;
        }
        for(k=0; k<len; k++) {
            if(dif[k]==0) {
                if(k > mx) {
                    mx = k+1;//最大长度
                    sindex=0;//起始下标
                    eindex=k;//结束下标
                }
            }else {//不为0判断相同的值
                if(data.containsKey(dif[k])) {//第一次碰到该值，存起来
                    if((k-data.get(dif[k])) > mx) {
                        mx = k-data.get(dif[k]);
                        sindex = data.get(dif[k])+1;
                        eindex = k;
                    }
                }else {
                    data.put(dif[k],k);
                }
            }
        }
        if(mx > 0) {
            return Arrays.copyOfRange(array,sindex,eindex+1);
        }else {
            return new String[]{};
        }
    }
}
