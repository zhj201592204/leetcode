package bookOne.algorithmImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * 设计一个方法，找出任意指定单词在一本书中的出现频率。
 *
 * 你的实现应该支持如下操作：
 *
 * WordsFrequency(book)构造函数，参数为字符串数组构成的一本书
 * get(word)查询指定单词在书中出现的频率
 *
 */
public class Subject_56 {

    private Map<String,Integer> result = new HashMap<>();
    public Subject_56(String[] book) {
        for(String s : book) {
            result.put(s,result.getOrDefault(s,0)+1);
        }
    }

    public int get(String word) {
        return result.getOrDefault(word,0);
    }
}
