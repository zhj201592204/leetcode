package bookOne.algorithmImpl;


/**
 * 无重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合，字符串每个字符均不相同。
 */
public class Subject_39 {

    public String[] permutation(String S) {
        if(S.length() == 0) {
            return null;
        }
        //计算一共有多少结果
        String[] result = new String[getFactorial(S.length())];
        if(S.length() == 1) {//一个字符，返回自己
            result[0] = S;
            return result;
        }
        String[] deep = permutation(S.substring(0,S.length()-1));
        int k = 0;
        String s = S.substring(S.length()-1);
        for(String t : deep) {//是上一个长度的字符串，每一个子串，在每一个位置插入新的字符
            result[k++] = s + t;
            for(int j=1; j<t.length(); j++) {
                result[k++] = t.substring(0,j) + S.substring(S.length()-1) + t.substring(j);
            }
            result[k++] = t+s;
        }

        return result;
    }

    private int getFactorial(int num) {
        if(num == 1) {
            return 1;
        }
        return num * getFactorial(num-1);
    }
}
