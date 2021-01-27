package bookOne.algorithmImpl;

/**
 * 八皇后
 */

import java.util.*;

/**
 * List<String> tempRes = new ArrayList<>();
 * char[] row = new char[n];
 * Arrays.fill(row, '.');
 * row[position[i]] = 'Q';
 * tempRes.add(new String(row));
 */

/**
 * 超时
 */
public class Subject_44 {

    //当前行是否有皇后，值为皇后的所在列
    private int[] position;
    private Set<List<String>> result = new HashSet<>();
    private int N;
    private char[] row;

    public List<List<String>> solveNQueens(int n) {
        N=n;
        position = new int[N];
        row = new char[N];
        Arrays.fill(row, '.');
        //初始化位置数组
        for(int i=0; i<n; i++) {
            position[i]=-1;
        }
        putQueue(1);
        return new ArrayList<>(result);
    }

    //判断当前位置是否可以摆放皇后
    private int avaliable(int col,int row) {
        //判断位置是否合法
        if(col < 0 || col >= N || row < 0 || row >= N) {
            return -1;
        }
        //判断皇后斜方向和垂直方向是否冲突
        for(int i=0; i<N; i++) {
            if(position[i] != -1) {
                if(row == position[i]) {
                    return -1;
                }
                if(col-i == row-position[i]) {
                    return -1;
                }
                if(col-i == position[i]-row) {
                    return -1;
                }
            }
        }
        //可以摆放，返回列下标
        return row;
    }
    //摆放第t个皇后
    private void putQueue(int t) {
        //如果皇后都摆好了
        if(t > N) {
            List<String> tempRes = new ArrayList<>();
            for(int i=0; i<N; i++) {
                row[position[i]] = 'Q';
                tempRes.add(new String(row));
                row[position[i]] = '.';
            }
            result.add(tempRes);
        }else {
            for(int m=0; m<N; m++) {
                if(position[m] == -1) {
                    for(int n=0; n<N; n++) {
                        int r = avaliable(m,n);
                        if(r != -1) {
                            position[m] = r;
                            putQueue(t+1);
                            position[m] = -1;
                        }
                    }
                }
            }
        }
    }
}
