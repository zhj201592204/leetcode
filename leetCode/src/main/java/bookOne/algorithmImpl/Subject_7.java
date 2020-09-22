package bookOne.algorithmImpl;
//给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。

/**
 * 旋转90°--> 先沿着对角线翻转，再沿着竖轴翻转
 */
public class Subject_7 {

    public void rotate(int[][] matrix) {
        int rows = matrix.length;
        //沿着对角线翻转
        for(int i=0; i<rows; i++) {
            for(int j=i; j<rows; j++) {
                int temp1 = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp1;
            }
        }
        //沿着竖轴翻转
        for(int m=0; m<rows; m++) {
            for(int n=0; n<rows/2; n++) {
                int temp2 = matrix[m][n];
                matrix[m][n] = matrix[m][rows-n-1];
                matrix[m][rows-n-1] = temp2;
            }
        }
    }
}
