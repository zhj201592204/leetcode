package bookOne.algorithmImpl;

/**
 * 设计一个算法，判断玩家是否赢了井字游戏。输入是一个 N x N 的数组棋盘，由字符" "，"X"和"O"组成，其中字符" "代表一个空位。
 *
 * 以下是井字游戏的规则：
 *
 * 玩家轮流将字符放入空位（" "）中。
 * 第一个玩家总是放字符"O"，且第二个玩家总是放字符"X"。
 * "X"和"O"只允许放置在空位中，不允许对已放有字符的位置进行填充。
 * 当有N个相同（且非空）的字符填充任何行、列或对角线时，游戏结束，对应该字符的玩家获胜。
 * 当所有位置非空时，也算为游戏结束。
 * 如果游戏结束，玩家不允许再放置字符。
 * 如果游戏存在获胜者，就返回该游戏的获胜者使用的字符（"X"或"O"）；如果游戏以平局结束，则返回 "Draw"；如果仍会有行动（游戏未结束），则返回 "Pending"。
 *
 */
public class Subject_57 {
    public String tictactoe(String[] board) {
        int len = board.length;
        boolean flag;
        String s,t;
        char c;
        int i,j;
        //判断正对角
        c = board[0].charAt(0);
        flag = true;
        for(i=0; i<len; i++) {
            s = board[i];
            if(s.charAt(i) != c) {
                flag = false;
                break;
            }
        }
        if(flag) {
            if(!(" ".equals(String.valueOf(c)))) {
                return String.valueOf(c);
            }
        }
        //判断反对角
        c = board[0].charAt(len-1);
        flag = true;
        for(i=0; i<len; i++) {
            s = board[i];
            if(s.charAt(len-i-1) != c) {
                flag = false;
                break;
            }
        }
        if(flag) {
            if(!(" ".equals(String.valueOf(c)))) {
                return String.valueOf(c);
            }
        }
        //判断横向和竖向
        boolean clear = true;
        for(i=0; i<len; i++) {
            s = board[i];
            c = s.charAt(i);
            flag = true;//默认获胜
            //判断横向是否一致
            for(j=0; j<len; j++) {
                if(clear) {
                    if(' ' == s.charAt(j)){
                        clear = false;
                    }
                }
                if(s.charAt(j) != c) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                if(!(" ".equals(String.valueOf(c)))) {
                    return String.valueOf(c);
                }
            }
            flag=true;
            //判断纵向是否一致
            for(j=0; j<len; j++) {
                t = board[j];
                if(clear) {
                    if(' ' == t.charAt(i)){
                        clear = false;
                    }
                }
                if(t.charAt(i) != c) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                if(!(" ".equals(String.valueOf(c)))) {
                    return String.valueOf(c);
                }
            }
        }
        if(clear) {
            return "Draw";
        }
        return "Pending";
    }
}
