package bookOne.algorithmImpl;

import java.util.Arrays;
//给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
/**
 * 条件1：长度相同
 * 条件2：每个字符在另外一个字符串里都能找到
 */
public class Subject_2 {
    public boolean CheckPermutation(String s1, String s2) {
        char[] charArr_1 = s1.toCharArray();
        char[] charArr_2 = s2.toCharArray();
        Arrays.sort(charArr_1);
        Arrays.sort(charArr_2);
        return Arrays.equals(charArr_1, charArr_2);
    }
}
