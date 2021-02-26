package bookOne.algorithmImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 在老式手机上，用户通过数字键盘输入，手机将提供与这些数字相匹配的单词列表。
 * 每个数字映射到0至4个字母。给定一个数字序列，实现一个算法来返回匹配单词的列表。
 * 你会得到一张含有有效单词的列表。映射如下图所示：
 * 输入: num = "8733", words = ["tree", "used"]
 * 输出: ["tree", "used"]
 *
 * 输入: num = "2", words = ["a", "b", "c", "d"]
 * 输出: ["a", "b", "c"]
 */
public class Subject_62 {
    public List<String> getValidT9Words(String num, String[] words) {
        //映射表
        Map<Integer,String> data = new HashMap<>();
        data.put(2,"a,b,c");
        data.put(3,"d,e,f");
        data.put(4,"g,h,i");
        data.put(5,"j,k,l");
        data.put(6,"m,n,o");
        data.put(7,"p,q,r,s");
        data.put(8,"t,u,v");
        data.put(9,"w,x,y,z");
        int digit = words[0].length();
        for(int i=0; i<digit; i++) {
            char n = num.charAt(i);
            String template = data.get(Integer.parseInt(String.valueOf(n)));
            for(int j=0; j<words.length; j++) {
                if(!("-1".equals(words[j]))) {
                    if(-1 == template.indexOf(String.valueOf(words[j].charAt(i)))) {
                        words[j] = "-1";
                    }
                }
            }
        }
        List<String> result = new ArrayList<>();
        for(int k=0; k<words.length; k++) {
            if(!("-1".equals(words[k]))) {
                result.add(words[k]);
            }
        }
        return result;
    }
}
