package bookOne.algorithmImpl;

/**
 * 编写函数，实现许多图片编辑软件都支持的「颜色填充」功能。
 * 待填充的图像用二维数组 image 表示，元素为初始颜色值。初始坐标点的横坐标为 sr 纵坐标为 sc。需要填充的新颜色为 newColor 。
 * 「周围区域」是指颜色相同且在上、下、左、右四个方向上存在相连情况的若干元素。
 * 请用新颜色填充初始坐标点的周围区域，并返回填充后的图像。
 */
public class Subject_42 {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length) {
            return image;
        }
        int row = image.length;
        int col = image[0].length;
        boolean[][] visit = new boolean[row][col];
        fillImage(image,sr,sc,newColor,visit);
        return image;
    }

    private void fillImage(int[][] image,int sr, int sc, int newColor,boolean[][] visit) {
        int color = image[sr][sc];
        //标记已访问
        image[sr][sc] = newColor;
        visit[sr][sc] = true;
        if(sr-1 >= 0 && image[sr-1][sc] == color && !visit[sr-1][sc]) {//上
            fillImage(image,sr-1,sc,newColor,visit);
        }
        if(sr+1 < image.length && image[sr+1][sc] == color && !visit[sr+1][sc]) {//下
            fillImage(image,sr+1,sc,newColor,visit);
        }
        if(sc-1 >= 0 && image[sr][sc-1] == color && !visit[sr][sc-1]) {//左
            fillImage(image,sr,sc-1,newColor,visit);
        }
        if(sc+1 < image[0].length && image[sr][sc+1] == color && !visit[sr][sc+1]) {//右
            fillImage(image,sr,sc+1,newColor,visit);
        }
    }
}
