package bookOne.algorithmImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 你有一个用于表示一片土地的整数矩阵land，该矩阵中每个点的值代表对应地点的海拔高度。若值为0则表示水域。由垂直、水平或对角连接的水域为池塘。池塘的大小是指相连接的水域的个数。编写一个方法来计算矩阵中所有池塘的大小，返回值需要从小到大排序。
 *输入：
 * [
 *   [0,2,1,0],
 *   [0,1,0,1],
 *   [1,1,0,1],
 *   [0,1,0,1]
 * ]
 * 输出： [1,2,4]
 */
public class Subject_61 {

    public int[] pondSizes(int[][] land) {
        //遍历土地矩阵的每一个节点，如果是0则搜索其周围的水域，是1则结束搜索
        List<Integer> data = new ArrayList<>();
        int quar;
        for(int i=0; i<land.length; i++) {
            for(int j=0; j<land[0].length; j++) {
                quar = getPool(land,i,j);
                if(quar != 0) {
                    data.add(quar);
                }
            }
        }
        int[] result =  data.stream().mapToInt(Integer::valueOf).toArray();
        Arrays.sort(result);
        return result;
    }

    private int getPool(int[][] land,int rindex,int cindex) {
        //记录水域大小初始为0
        int num=0;
        if(rindex<0 || rindex>=land.length || cindex<0 || cindex>=land[0].length || land[rindex][cindex] != 0) {
            return num;
        }
        //当前是水域且未参与搜索
        num++;
        //当前水域已经参与搜索
        land[rindex][cindex] = -1;

        //搜索该水域周围
        num += getPool(land,rindex+1,cindex);
        num += getPool(land,rindex-1,cindex);
        num += getPool(land,rindex,cindex+1);
        num += getPool(land,rindex,cindex-1);
        num += getPool(land,rindex-1,cindex-1);
        num += getPool(land,rindex-1,cindex+1);
        num += getPool(land,rindex+1,cindex-1);
        num += getPool(land,rindex+1,cindex+1);

        return num;
    }
}
