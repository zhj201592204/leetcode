package BookOne;
//字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。
// 比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。
// 你可以假设字符串中只包含大小写英文字母（a至z）。

import java.util.HashMap;
import java.util.Map;

/**
 * 并不是压缩所有的相同的字符，而是压缩连续的相同的字符
 */

/**
 * 时间和内存消耗区别在
 * String 的 + 方法和StringBuilder 的 append 方法
 */
public class Subject_6 {
    public String compressString(String S) {
        if(S.length() == 0) {
            return S;
        }
        StringBuilder resultStr = new StringBuilder();
        char[] charArr = S.toCharArray();
        int sum = 1;
        resultStr.append(charArr[0]);
        for(int i=1; i<charArr.length; i++) {
            if(charArr[i] == charArr[i-1]) {
                ++sum;

            }else {
                resultStr.append(sum);
                resultStr.append(charArr[i]);
                sum=1;
            }
            if(i==charArr.length -1) {
                resultStr.append(sum);
            }
        }
        return resultStr.length() >= S.length() ? S : resultStr.toString();
    }
}
