package bookOne.algorithmImpl;

import java.util.HashSet;
import java.util.Set;

/**
 * 有重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合。
 *
 * 和上一题本质一样，不过存储结果的结构换成set自动去重即可满足题目条件
 */
public class Subject_40 {

    public String[] permutation(String S) {
        if(S.length() == 0) {
            return null;
        }
        //计算一共有多少结果
        Set<String> result = new HashSet<>();
        if(S.length() == 1) {//一个字符，返回自己
            result.add(S);
            return result.toArray(new String[0]);
        }
        String[] deep = permutation(S.substring(0,S.length()-1));
        int k = 0;
        String s = S.substring(S.length()-1);
        for(String t : deep) {//是上一个长度的字符串，每一个子串，在每一个位置插入新的字符
            result.add(s + t);
            for(int j=1; j<t.length(); j++) {
                result.add(t.substring(0,j) + s + t.substring(j));
            }
            result.add(t+s);
        }

        return result.toArray(new String[result.size()]);
    }

    private int getFactorial(int num) {
        if(num == 1) {
            return 1;
        }
        return num * getFactorial(num-1);
    }
}
