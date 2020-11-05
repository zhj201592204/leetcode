package bookOne.algorithmImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 括号。设计一种算法，打印n对括号的所有合法的（例如，开闭一一对应）组合。
 * 一对括号：()
 * 两对括号：()()，(())
 * 三对括号()()(),(())(),()(()),((())),(()())
 * 回溯：n的结果集是n-1的结果集每一个位置加上()，但是会有重复的数据，使用Set可以自动去重79k
 */
public class Subject_41 {

    public List<String> generateParenthesis(int n) {
        return new ArrayList<>(genParen(n));
    }

    private Set<String> genParen(int n) {
        Set<String> result = new HashSet<>();
        if(n == 1) {
            result.add("()");
            return result;
        }
        Set<String> tempResult = genParen(n-1);
        String s;
        ArrayList<String> tArray = new ArrayList<>(tempResult);
        for(String lstr : tArray) {
            s = "()" + lstr;
            result.add(s);
            int len = lstr.length();
            for(int i=1; i<lstr.length(); i++) {
                String temp = lstr.substring(0,i);
                s = lstr.substring(0,i) + "()" + lstr.substring(i);
                result.add(s);
            }
            s = lstr + "()";
            result.add(s);
        }
        return result;
    }
}
