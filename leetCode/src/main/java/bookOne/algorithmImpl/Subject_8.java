package bookOne.algorithmImpl;
//编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。

/**
 * 先遍历一次记录下0的下标，然后置0
 * 关键点在于如何节约内存，能够使用更小的内存来存储需要置0的位置
 */
public class Subject_8 {

    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[] rowIndex = new boolean[rows];
        boolean[] colIndex = new boolean[cols];
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(0 == matrix[i][j]) {
                    rowIndex[i] = true;
                    colIndex[j] = true;
                }
            }
        }
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(rowIndex[i] || colIndex[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
