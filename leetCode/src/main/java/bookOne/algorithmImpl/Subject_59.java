package bookOne.algorithmImpl;

/**
 * 给定 N 个人的出生年份和死亡年份，第 i 个人的出生年份为 birth[i]，死亡年份为 death[i]，
 * 实现一个方法以计算生存人数最多的年份。
 *
 * 你可以假设所有人都出生于 1900 年至 2000 年（含 1900 和 2000 ）之间。
 * 如果一个人在某一年的任意时期处于生存状态，那么他应该被纳入那一年的统计中。
 * 例如，生于 1908 年、死于 1909 年的人应当被列入 1908 年和 1909 年的计数。
 *
 * 如果有多个年份生存人数相同且均为最大值，输出其中最小的年份。
 */
public class Subject_59 {

    public int maxAliveYear(int[] birth, int[] death) {
        int[] year = new int[101];
        int blen = birth.length;
        int bir,dea;
        int i,j;
        for(i=0; i<blen; i++) {
            bir = birth[i];
            dea = death[i];
            for(j=bir; j<=dea; j++) {
                year[j-1900] += 1;
            }
        }
        int index = 0;
        int maxAlive = 0;
        for(i=100;i>=0;i--) {
            if(maxAlive <= year[i]) {
                maxAlive = year[i];
                index = i;
            }
        }
        return index+1900;
    }
}
