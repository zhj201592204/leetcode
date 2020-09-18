package BookOne;

//字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。
// 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。

public class Subject_5 {

    public boolean oneEditAway(String first, String second) {

        if(first.length() == second.length()) {//替换一个字符或者相等
            return getDifference(first,second);
        }else if(Math.abs(first.length()-second.length()) == 1) {//去掉或者增加一个字符
            if(first.length() > second.length()) {
                return getDifferentChar(second,first);
            }
            return getDifferentChar(first,second);
        }else {
            return false;
        }
    }

    /**
     * s1比s2短
     */
    private boolean getDifferentChar(String s1,String s2) {
        int k = 0;
        char[] charsArr_1 = s1.toCharArray();
        char[] charsArr_2 = s2.toCharArray();
        for(int i=0,j=0; i<charsArr_1.length; ) {//对比
            if(charsArr_1[i] != charsArr_2[j]) {
                ++k;
                ++j;
            }else {
                ++i;
                ++j;
            }
            if(k > 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * 比较两个同等长度的字符串不同
     */
    private boolean getDifference(String s1,String s2) {
        int k = 0;
        char[] charsArr_1 = s1.toCharArray();
        char[] charsArr_2 = s2.toCharArray();
        for(int i=0; i<charsArr_1.length; i++) {//对比
            if(charsArr_1[i] != charsArr_2[i]) {
                ++k;
            }
            if(k > 1) {
                return false;
            }
        }
        return true;
    }
}
