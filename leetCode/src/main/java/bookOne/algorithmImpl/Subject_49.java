package bookOne.algorithmImpl;

/**
 * 珠玑妙算游戏（the game of master mind）的玩法如下。
 *
 * 计算机有4个槽，每个槽放一个球，颜色可能是红色（R）、黄色（Y）、绿色（G）或蓝色（B）。例如，计算机可能有RGGB 4种（槽1为红色，槽2、3为绿色，槽4为蓝色）。
 * 作为用户，你试图猜出颜色组合。打个比方，你可能会猜YRGB。要是猜对某个槽的颜色，则算一次“猜中”；要是只猜对颜色但槽位猜错了，则算一次“伪猜中”。
 * 注意，“猜中”不能算入“伪猜中”。
 *
 * 给定一种颜色组合solution和一个猜测guess，编写一个方法，返回猜中和伪猜中的次数answer，其中answer[0]为猜中的次数，answer[1]为伪猜中的次数。
 */
public class Subject_49 {

    public int[] masterMind(String solution, String guess) {
        int[] solutionCount = new int[4];
        int[] guessCount = new int [4];
        int i;
        initCount(solution,solutionCount);
        initCount(guess,guessCount);
        int[] answer = new int[2];
        for(i=0 ;i<4; i++) {
            if(solution.charAt(i) == guess.charAt(i)) {
                answer[0]++;
                if('R' == solution.charAt(i)) {
                    solutionCount[0]--;
                    guessCount[0]--;
                }else if('G' == solution.charAt(i)) {
                    solutionCount[1]--;
                    guessCount[1]--;
                }else if('B' == solution.charAt(i)) {
                    solutionCount[2]--;
                    guessCount[2]--;
                }else if('Y' == solution.charAt(i)) {
                    solutionCount[3]--;
                    guessCount[3]--;
                }
            }
        }
        for(i=0; i<4; i++) {
            if(solutionCount[i] > 0 && guessCount[i] > 0) {
                if(solutionCount[i] < guessCount[i]) {
                    answer[1]+=solutionCount[i];
                }else{
                    answer[1]+=guessCount[i];
                }
            }
        }
        return answer;
    }

    private void initCount(String str,int[] strCount) {
        int i;
        for(i=0; i<4; i++) {
            if('R' == str.charAt(i)) {
                strCount[0]++;
            }else if('G' == str.charAt(i)) {
                strCount[1]++;
            }else if('B' == str.charAt(i)) {
                strCount[2]++;
            }else if('Y' == str.charAt(i)) {
                strCount[3]++;
            }
        }
    }
}
