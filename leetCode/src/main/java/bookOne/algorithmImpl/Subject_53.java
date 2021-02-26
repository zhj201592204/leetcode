package bookOne.algorithmImpl;

import java.util.*;

/**
 * 编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。变位词是指字母相同，但排列不同的字符串。
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 */
public class Subject_53 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String,Integer> control = new HashMap<>();
        int index = 0;
        for(String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String tr = new String(c);
            if(!control.containsKey(tr)) {
                control.put(tr,index++);
                List<String> l = new ArrayList<>();
                l.add(s);
                result.add(l);
            }else{
                result.get(control.get(tr)).add(s);
            }
        }
        return result;
    }
}
