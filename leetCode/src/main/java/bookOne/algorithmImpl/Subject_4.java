package bookOne.algorithmImpl;

//给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
//回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
//回文串不一定是字典当中的单词。

import java.util.HashMap;

/**
 * 回文中字符的数量为奇数的个数为1个或者0个
 */
public class Subject_4 {
    public boolean canPermutePalindrome(String s) {
        HashMap<Character,Integer> result = new HashMap<>();
        char[] sArr = s.toCharArray();
        for(char c : sArr) {
            Character character = Character.valueOf(c);
            if(result.containsKey(character)) {
                result.put(character,result.get(character)+1);
            }else {
                result.put(character,1);
            }
        }
        int k = 0;
        for(Integer i : result.values()) {
            if(i%2!=0) {
                ++k;
            }
        }
        return (k ==1 || k ==0);
    }
}
