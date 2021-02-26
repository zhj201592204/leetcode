package bookOne.algorithmImpl;

/**
 * 有个内含单词的超大文本文件，给定任意两个单词，找出在这个文件中这两个单词的最短距离(相隔单词数)。
 *
 * 输入：words = ["I","am","a","student","from","a","university","in","a","city"], word1 = "a", word2 = "student"
 * 输出：1
 */
public class Subject_70 {

    public int findClosest(String[] words, String word1, String word2) {
        int i=0,j=0;
        int res = words.length;
        while(i<words.length && j<words.length) {//遍历数组
            while(i<words.length && !(word1.equals(words[i]))) {//找到接下来第一个单词
                ++i;
            }
            while(j < words.length && !(word2.equals(words[j]))) {//找到接下来第二个单词
                ++j;
            }
            if(i<j) {//如果第一个单词在前，则继续找下一个第一个单词
                if(j < words.length && j-i < res) {
                    res = j-i;
                }
                ++i;
            }else {//继续找下一个第二个单词
                if(i<words.length && i-j < res) {
                    res = i-j;
                }
                ++j;
            }
        }
        return res;
    }
}
