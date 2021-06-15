package bookOne.algorithmImpl.stageTwo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定一组单词words，编写一个程序，找出其中的最长单词，且该单词由这组单词中的其他单词组合而成。
 * 若有多个长度相同的结果，返回其中字典序最小的一项，若没有符合要求的单词则返回空字符串。
 *
 * 输入： ["cat","banana","dog","nana","walk","walker","dogwalker"]
 * 输出： "dogwalker"
 * 解释： "dogwalker"可由"dog"和"walker"组成。
 */
public class Stage2_1 {
    /**
     * 核心思路：对每个单词从每个地方分割，分别判断前后两断是否都在单词组中
     */
    public String longestWord(String[] words) {
        //先排序，按照单词长度递减，如果单词长度一致，按照单词顺序递增
        Arrays.sort(words,(o1,o2) -> {
            if(o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }else {
                return Integer.compare(o2.length(),o1.length());
            }
        });
        Set<String> data = new HashSet<>(Arrays.asList(words));
        //每个单词依次处理
        for(String word : words) {
            data.remove(word);
            if(isInWords(word,data)) {
                return word;
            }
        }
        return "";
    }

    private boolean isInWords(String word,Set<String> words) {
        if(word.length() == 0) {
            return true;
        }
        for(int i=0; i<word.length(); i++) {
            //有一种情况符合就返回
            if(words.contains(word.substring(0,i+1)) && isInWords(word.substring(i+1),words)) {
                return true;
            }
        }
        //没有符合的情况
        return false;
    }
}
