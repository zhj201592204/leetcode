package bookOne.algorithmImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 设想有个机器人坐在一个网格的左上角，网格 r 行 c 列。机器人只能向下或向右移动，但不能走到一些被禁止的网格（有障碍物）。设计一种算法，寻找机器人从左上角移动到右下角的路径。
 */
public class Subject_34 {

    private List<List<Integer>> resultPath = new ArrayList<>();//记录一条路径
    private int r;//行数
    private int c;//列数
    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        r = obstacleGrid.length;
        if(r <= 0) {
            return resultPath;
        }
        resultPath.clear();
        c = obstacleGrid[0].length;
        if(obstacleGrid[r-1][c-1] == 1) {//终点是障碍物，无法到达
            return resultPath;
        }
        boolean[][] visit = new boolean[r][c];//记录是否访问过的点
        getExport(0,0,obstacleGrid,visit);
        return resultPath;
    }

    private boolean getExport(int x, int y,int[][] obstacleGrid,boolean[][] visit) {
        if(x>=r || y>=c || visit[x][y] || obstacleGrid[x][y]==1) {
            return false;
        }
        resultPath.add(Arrays.asList(x,y));
        visit[x][y] = true;
        if(getExport(x+1,y,obstacleGrid,visit) || getExport(x,y+1,obstacleGrid,visit)) {
            return true;
        }
        resultPath.remove(resultPath.size()-1);
        return false;
    }
}
